(ns sicp.chapter02.2-17)

(defn last-pair
  [coll]
  (loop [head coll
         tail (rest coll)]
    (if (empty? tail)
      head
      (recur tail
             (rest tail)))))
