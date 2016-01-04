(ns sicp.chapter02.2-21
  (:require [sicp.common :as sicp]))

(defn square-list-v1
  [coll]
  (when-not (empty? coll)
    (cons (sicp/square (first coll))
          (square-list-v1 (rest coll)))))

(defn square-list-v2
  [coll]
  (map sicp/square coll))
