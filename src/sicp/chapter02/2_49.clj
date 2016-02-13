(ns sicp.chapter02.2-49
  (:require [sicp.chapter02.2-46 :refer :all]
            [sicp.chapter02.2-47 :refer :all]
            [sicp.chapter02.2-48 :refer :all]))

(defn draw-line
  [start-point end-point]
  ; draw line
  nil)

(defn frame-coord-map
  [frame]
  (fn [v]
    (add-vect (origin-frame frame)
              (add-vect (scale-vect (xcor-vect v)
                                    (edge1-frame frame))
                        (scale-vect (ycor-vect v)
                                    (edge2-frame frame))))))

(defn segments->painter
  ([segment-list]
   (segments->painter draw-line segment-list))
  ([paint-f segment-list]
   (fn [frame]
     (let [frame-map (frame-coord-map frame)]
       (doseq [segment segment-list]
         (paint-f (frame-map (start-segment segment))
                  (frame-map (end-segment segment))))))))

(defn frame-painter [paint-f]
  (let [segments [(make-segment [0 0] [0 1])
                  (make-segment [0 1] [1 1])
                  (make-segment [1 1] [1 0])
                  (make-segment [1 0] [0 0])]]
    (segments->painter paint-f segments)))

(defn x-painter [paint-f]
  (let [segments [(make-segment [0 0] [1 1])
                  (make-segment [0 1] [1 0])]]
    (segments->painter paint-f segments)))

(defn diamond-painter [paint-f]
  (let [segments [(make-segment [0 0.5] [0.5 1])
                  (make-segment [0.5 1] [1 0.5])
                  (make-segment [1 0.5] [0.5 0])
                  (make-segment [0.5 0] [0 0.5])]]
    (segments->painter paint-f segments)))

(defn wave-painter [paint-f]
  (let [segments [(make-segment [0.4 0.0] [0.5 0.3])
                  (make-segment [0.5 0.3] [0.6 0.0])
                  (make-segment [0.7 0.0] [0.6 0.5])
                  (make-segment [0.6 0.5] [0.7 0.5])
                  (make-segment [0.7 0.5] [1.0 0.3])
                  (make-segment [1.0 0.4] [0.7 0.6])
                  (make-segment [0.7 0.6] [0.6 0.6])
                  (make-segment [0.6 0.6] [0.67 0.83])
                  (make-segment [0.67 0.83] [0.6 1.0])
                  (make-segment [0.4 1.0] [0.33 0.83])
                  (make-segment [0.33 0.83] [0.4 0.6])
                  (make-segment [0.4 0.6] [0.3 0.6])
                  (make-segment [0.3 0.6] [0.2 0.5])
                  (make-segment [0.2 0.5] [0.0 0.7])
                  (make-segment [0.0 0.6] [0.2 0.4])
                  (make-segment [0.2 0.4] [0.3 0.5])
                  (make-segment [0.3 0.5] [0.4 0.5])
                  (make-segment [0.4 0.5] [0.3 0.0])]]
    (segments->painter paint-f segments)))
