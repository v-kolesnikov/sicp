(ns sicp.chapter02.2-50
  (:require [sicp.chapter02.2-46 :refer [make-vect sub-vect]]
            [sicp.chapter02.2-47 :refer [make-frame]]
            [sicp.chapter02.2-49 :refer [frame-coord-map]]))

(defn transform-painter
  [painter origin corner1 corner2]
  (fn [frame]
    (let [m (frame-coord-map frame)
          new-origin (m origin)
          new-edge1 (sub-vect (m corner1) new-origin)
          new-edge2 (sub-vect (m corner2) new-origin)
          new-frame (make-frame new-origin new-edge1 new-edge2)]
      (painter new-frame))))

(defn flip-horiz
  [painter]
  (transform-painter painter
                     (make-vect 1 0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))

(defn rotate-counterclockwise-180
  [painter]
  (transform-painter painter
                     (make-vect 1.0 1.0)
                     (make-vect 0.0 1.0)
                     (make-vect 1.0 0.0)))

(defn rotate-counterclockwise-270
  [painter]
  (transform-painter painter
                     (make-vect 0.0 1.0)
                     (make-vect 0.0 0.0)
                     (make-vect 1.0 1.0)))
