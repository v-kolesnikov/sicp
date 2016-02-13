(ns sicp.chapter02.2-51
  (:require [sicp.chapter02.2-46 :refer [make-vect]]
            [sicp.chapter02.2-50 :refer [rotate-counterclockwise-180
                                         rotate-counterclockwise-270
                                         transform-painter]]))

(defn beside
  [left-painter right-painter]
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
      (paint-right frame))))

(defn below
  [bottom-painter top-painter]
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
      (paint-top frame))))

(defn below-rotate
  [bottom-painter top-painter]
  (let [bottom-rotated (rotate-counterclockwise-270 bottom-painter)
        top-rotated (rotate-counterclockwise-270 top-painter)]
    (->> (beside bottom-rotated top-rotated)
         (rotate-counterclockwise-270)
         (rotate-counterclockwise-180))))
