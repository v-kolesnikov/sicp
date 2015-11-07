(ns sicp.chapter01.1-33
  (:require [sicp.chapter01.1-21 :refer [prime?]]
            [sicp.chapter01.1-20 :refer [gcd]]
            [sicp.chapter01.1-21 :refer [prime?]]
            [sicp.common :refer [square]]))

(defn filtered-accumulate
  [combiner null-value term a next-term b filter-term]
  (loop [a a
         acc null-value]
    (if (> a b)
      acc
      (recur (next-term a)
             (if (filter-term a)
               (combiner acc (term a))
               acc)))))

(defn summ-of-primes-squares
  [a b]
  (filtered-accumulate + 0 square a inc b prime?))

(defn product-of-pos-coprimes
  [a b]
  (letfn [(coprime? [a]
            (= (gcd b a) 1))]
    (filtered-accumulate * 1 identity a inc b coprime?)))
