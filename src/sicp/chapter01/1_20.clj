(ns sicp.chapter01.1-20
  (:require [sicp.common :refer [square]]))

(defn gcd
  ; Return hash with GCD and iterations count
  [a b]
  (loop [a a
         b b
         n 0]
    (cond
      (zero? b) {:nod a :iter n}
      :else (recur b
                   (rem a
                        b)
                   (inc n)))))
