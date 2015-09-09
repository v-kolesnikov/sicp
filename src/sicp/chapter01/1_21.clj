(ns sicp.chapter01.1-21
  (:require [sicp.common :refer [square]]))

(defn divides? [a b]
  (zero? (rem b a)))

(defn find-divisor [n test-divisor]
  (cond
    (> (square test-divisor)
       n) n
    (divides? test-divisor n) test-divisor
    :else (find-divisor n
                        (inc test-divisor))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))
