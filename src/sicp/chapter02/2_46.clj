(ns sicp.chapter02.2-46)

(defn make-vect
  [x y]
  {:pre [(number? x) (number? y)]}
  (vector x y))

(defn xcor-vect
  [[x _]]
  x)

(defn ycor-vect
  [[_ y]]
  y)

(defn add-vect
  [[x1 y1] [x2 y2]]
  (make-vect (+ x1 x2)
             (+ y1 y2)))

(defn sub-vect
  [[x1 y1] [x2 y2]]
  (make-vect (- x1 x2)
             (- y1 y2)))

(defn scale-vect
  [s [x y]]
  {:pre [(number? s)]}
  (make-vect (* x s)
             (* y s)))
