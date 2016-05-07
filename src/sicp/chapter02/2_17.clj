(ns sicp.chapter02.2-17)

(defn last-pair
  [coll]
  (loop [[head & tail] coll]
    (if (empty? tail)
      (list head)
      (recur tail))))
