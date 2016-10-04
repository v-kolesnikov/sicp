(ns sicp.common.pairs
  (:require [clojure.test :as test]))

(defn car [z]
  (z (fn [p q] p)))

(defn cdr [z]
  (z (fn [p q] q)))

(defn cons
  [x y]
  (fn [m] (m x y)))

(def pair? test/function?)
