(ns sicp.chapter01.1-27
  (:require [sicp.chapter01.1-24 :refer [expmod]]))

(defn equal-mod-expmod?
  [a n]
  (= (expmod a n n) a))

(defn check-prime
  [n]
  (loop [a 1]
    (cond
      (< a n) (if (equal-mod-expmod? a n)
                (recur (inc a))
                false)
      :else true)))
