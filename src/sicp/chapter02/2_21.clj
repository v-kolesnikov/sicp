(ns sicp.chapter02.2-21
  (:require [sicp.common :as sicp]))

(defn square-list-v1
  [coll]
  (when (seq coll)
    (cons (sicp/square (first coll))
          (square-list-v1 (rest coll)))))

(defn square-list-v2
  [coll]
  (map sicp/square coll))

(defn square-list-v3
  [coll]
  (loop [s coll
         acc nil]
    (if (empty? s)
      (reverse acc)
      (recur (rest s)
             (cons (sicp/square (first s))
                   acc)))))
