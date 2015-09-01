(ns sicp.chapter01.1-07)

; From § 1.1.7
(defn averrage
  [x y]
  (/ (+ x y) 2))

(defn improve
  [guess x]
  (averrage guess (/ x guess)))

(defn square
  [x]
  (* x x))

(defn good-enough?
  [guess x]
  (< (Math/abs (- (square guess)
                  x))
     0.001))

(defn sqrt [x]
  (loop [guess 1.0]
    (if (good-enough? guess x)
      guess
      (recur (improve guess x)))))

; Exercise 1.7 Solution
(defn better-good-enough?
  [prev-guess guess x]
  (< (Math/abs (- guess
                  prev-guess))
     0.000001))

(defn better-sqrt [x]
  (loop [prev-guess 0 guess 1.0]
    (if (better-good-enough? prev-guess guess x)
      guess
      (recur guess (improve guess x)))))
