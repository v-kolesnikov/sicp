(ns sicp.chapter01.1-08)

(defn square
  [x]
  (* x x))

(defn improve
  [guess x]
  (/ (+ (/ x
           (square guess))
        (* 2 guess))
     3))

(defn good-enough?
  [prev-guess guess x]
  (< (Math/abs (- guess
                  prev-guess))
     0.0000001))

(defn cbrt [x]
  (loop [prev-guess 0 guess 1.0]
    (if (good-enough? prev-guess guess x)
      guess
      (recur guess (improve guess x)))))
