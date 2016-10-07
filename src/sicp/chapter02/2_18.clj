(ns sicp.chapter02.2-18
  (:refer-clojure :exclude [reverse]))

(defn reverse
  [coll]
  (loop [s coll
         acc (list)]
    (if (empty? s)
      acc
      (recur (rest s)
             (cons (first s) acc)))))
