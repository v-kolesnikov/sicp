(ns sicp.chapter02.2-52
  (:require [sicp.chapter02.2-45 :refer [right-split up-split]]
            [sicp.chapter02.2-46 :refer [make-vect]]
            [sicp.chapter02.2-49 :refer [segments->painter wave-painter]]
            [sicp.chapter02.2-50 :refer [flip-horiz rotate-counterclockwise-180
                                         transform-painter]]
            [sicp.chapter02.2-51 :refer [below beside]]))

(def rotate180 rotate-counterclockwise-180)

(defn smile-wave-painter
  [paint-f]
  (let [wave-body-painter (wave-painter paint-f)
        wave-smile-painter (segments->painter paint-f [[[0.45 0.7] [0.55 0.7]]])]
    (fn [frame]
      (wave-body-painter frame)
      (wave-smile-painter frame))))

(defn corner-split
  [painter n]
  (let [ft (fn [p i]
             (let [top-left (up-split painter i)
                   bottom-right (right-split painter i)]
               (beside (below painter top-left)
                       (below bottom-right p))))]
    (reduce ft painter (range 0 n))))

(defn square-of-four
  [tl tr bl br]
  (fn [painter]
    (let [top (beside (tl painter) (tr painter))
          bottom (beside (bl painter) (br painter))]
      (below bottom top))))

(defn flip-vert
  [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 0.0)))

(defn square-limit
  [painter n]
  (let [combiner4 (square-of-four rotate180 flip-vert
                                  flip-horiz identity)]
    (combiner4 (corner-split painter n))))
