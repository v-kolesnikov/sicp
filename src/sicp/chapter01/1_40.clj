(ns sicp.chapter01.1-40
  (:require [sicp.common :refer [avg]]
            [sicp.chapter01.1-35 :refer [fixed-point]]))

(defn deriv
  [g]
  (let [dx 0.00001]
    (fn [x] (/ (- (g (+ x dx))
                  (g x))
               dx))))

(defn transform [g]
  (fn [x]
    (- x
       (/ (g x)
          ((deriv g) x)))))

(defn newtons-method
  [g guess]
  (fixed-point (transform g) guess))

(defn cubic
  [a b c d]
  (fn [x] (+ (* a x x x)
             (* b x x)
             (* c x)
             d)))
