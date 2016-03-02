(ns sicp.extra.picture-language.core
  (:require [sicp.extra.picture-language.frames :refer :all]
            [sicp.extra.picture-language.segments :refer :all]
            [sicp.extra.picture-language.vectors :refer :all]))

(defn transform-painter
  [painter origin corner1 corner2]
  (fn [frame]
    (let [m (frame-coord-map frame)
          new-origin (m origin)
          new-edge1 (sub-vect (m corner1) new-origin)
          new-edge2 (sub-vect (m corner2) new-origin)
          new-frame (make-frame new-origin new-edge1 new-edge2)]
      (painter new-frame))))

(defn below
  ([[bottom-painter & top-painters]]
   (reduce below bottom-painter top-painters))
  ([bottom-painter top-painter]
   (let [split-point (make-vect 0.0 0.5)
         paint-bottom (transform-painter bottom-painter
                                         (make-vect 0.0 0.0)
                                         (make-vect 1.0 0.0)
                                         split-point)
         paint-top (transform-painter top-painter
                                      split-point
                                      (make-vect 1.0 0.5)
                                      (make-vect 0.0 1.0))]
     (fn [frame]
       (paint-bottom frame)
       (paint-top frame)))))

(defn beside
  ([[left-painter & right-painters]]
   (reduce beside left-painter right-painters))
  ([left-painter right-painter]
   (let [split-point (make-vect 0.5 0.0)
         paint-left (transform-painter left-painter
                                       (make-vect 0.0 0.0)
                                       split-point
                                       (make-vect 0.0 1.0))
         paint-right (transform-painter right-painter
                                        split-point
                                        (make-vect 1.0 0.0)
                                        (make-vect 0.5 1.0))]
     (fn [frame]
       (paint-left frame)
       (paint-right frame)))))

(defn flip-vert
  [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn flip-horiz
  [painter]
  (transform-painter painter
                     (make-vect 1.0 0.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn rotate180
  [painter]
  (transform-painter painter
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 0.0)))

(defn right-split
  [painter n]
  (let [ft (fn [p _] (->> p (below p) (beside painter)))]
    (reduce ft painter (range 0 n))))

(defn up-split
  [painter n]
  (let [ft (fn [p _] (->> p (beside p) (below painter)))]
    (reduce ft painter (range 0 n))))

(defn corner-split
  [painter n]
  (let [ft (fn [p i]
             (let [up (up-split painter  i)
                   right (right-split painter i)
                   top-left (beside up up)
                   bottom-right (below right right)]
               (beside (below painter top-left)
                       (below bottom-right p))))]
    (reduce ft painter (range 0 n))))

(defn square-of-four
  [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (below bottom top))))

(defn flipped-pairs
  [painter]
  (let [combiner4 (square-of-four identity flip-vert
                                  identity flip-vert)]
    (combiner4 painter)))

(defn square-limit
  [painter n]
  (let [combiner4 (square-of-four flip-horiz identity
                                  rotate180 flip-vert)]
    (combiner4 (corner-split painter n))))

(defn segments->painter
  [paint-f segment-list]
  (fn [frame]
    (let [frame-map (frame-coord-map frame)]
      (doseq [segment segment-list]
        (paint-f (frame-map (start-segment segment))
                 (frame-map (end-segment segment)))))))
