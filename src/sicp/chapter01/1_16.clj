(ns sicp.chapter01.1-16
  (:require [sicp.common :refer [square]]))

(defn fast-expt [b n]
  (loop [a 1 b b n n]
    (cond
      (zero? n) a
      (even? n) (recur a
                       (square b)
                       (/ n 2))
      :else (recur (* a b)
                   b
                   (dec n)))))
