(ns sicp.chapter01.1-19
  (:require [sicp.common :refer [square]]))

(defn fib [n]
  (loop [a 1
         b 0
         p 0
         q 1
         count n]
    (cond
      (zero? count) b
      (even? count) (recur a
                           b
                           (+ (square p)
                              (square q))
                           (+ (* 2 p q)
                              (square q))
                           (/ count 2))
      :else (recur (+ (* b q)
                      (* a q)
                      (* a p))
                   (+ (* b p)
                      (* a q))
                   p
                   q
                   (dec count)))))

(fib 20)
