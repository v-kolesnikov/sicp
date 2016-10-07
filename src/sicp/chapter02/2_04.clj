(ns sicp.chapter02.2-04
  (:refer-clojure :exclude [cons]))

(defn cons
  [x y]
  (fn [m] (m x y)))

(defn car [z]
  (z (fn [p q] p)))

(defn cdr [z]
  (z (fn [p q] q)))
