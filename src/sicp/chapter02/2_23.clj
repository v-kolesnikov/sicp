(ns sicp.chapter02.2-23)

(defn for-each
  [f coll]
  (loop [s coll]
    (when (seq s)
      (f (first s))
      (recur (rest s)))))
