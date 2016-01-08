(ns sicp.chapter02.2-18)

(defn reverse
  [coll]
  (loop [s coll
         acc (list)]
    (if (empty? s)
      acc
      (recur (rest s)
             (cons (first s) acc)))))
