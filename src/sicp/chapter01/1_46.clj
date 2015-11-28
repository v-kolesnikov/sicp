(ns sicp.chapter01.1-46
  (:require [sicp.common :refer [avg square]]))

(defn iterative-improve
  [good? improve]
  (fn [x]
    (loop [guess x]
      (let [next-guess (improve guess)]
        (if (good? next-guess)
          next-guess
          (recur next-guess))))))

(defn sqrt
  [x]
  (let [good? (fn [guess]
                (< (Math/abs (- (square guess) x))
                   0.001))
        improve (fn [guess]
                  (avg [guess (/ x guess)]))
        iterator (iterative-improve good? improve)]
    (iterator 1.0)))

(defn fixed-point
  [f first-guess]
  (let [close-enough? (fn [guess]
                        (< (Math/abs (- guess (f guess)))
                           0.00001))
        iterator (iterative-improve close-enough? f)]
    (iterator first-guess)))
