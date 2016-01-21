(ns sicp.chapter02.2-28)

(defn fringle
  [tree]
  (loop [coll tree
         acc nil]
    (let [x (first coll)]
      (cond (empty? coll) (reverse acc)
            (list? x) (recur (concat x (rest coll))
                             acc)
            :else (recur (rest coll)
                         (cons x acc))))))
