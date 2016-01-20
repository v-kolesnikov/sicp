(ns sicp.chapter02.2-27
  (:require [sicp.chapter02.2-18 :as sicp-2-18]))

(defn deep-reverse-v1
  [coll]
  (loop [s coll
         acc (list)]
    (cond (empty? s) acc
          (list? (first s)) (recur (rest s)
                                   (cons (deep-reverse-v1 (first s)) acc))
          :else (recur (rest s)
                       (cons (first s) acc)))))

(defn deep-reverse-v2
  [coll]
  (if (list? coll)
    (map deep-reverse-v2 (sicp-2-18/reverse coll))
    coll))
