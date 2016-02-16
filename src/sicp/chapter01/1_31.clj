(ns sicp.chapter01.1-31
  (:require [sicp.common :as sicp]))

(defn product-recursive
  [term a next-element b]
  (if (> a b)
    1
    (* (term a)
       (product-recursive term
                          (next-element a)
                          next-element
                          b))))

(defn product-iterative
  [term a next-term b]
  (loop [i a
         acc 1]
    (if (> i b)
      acc
      (recur (next-term i)
             (* acc (term i))))))

(def product product-iterative)

(defn factorial
  [n]
  (product identity 1 inc n))

(defn wallis-range
  [n]
  (let [a 3
        term (fn [x]
               (/ (dec (sicp/square x))
                  (sicp/square x)))
        next (fn [x] (+ x 2))]
    (float (product term a next n))))

(defn pi [n]
  (* 4 (wallis-range n)))
