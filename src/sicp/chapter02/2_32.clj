(ns sicp.chapter02.2-32)

(defn subsets
  [coll]
  (if (empty? coll)
    (list '())
    (let [tail (subsets (rest coll))]
      (concat tail
              (map #(cons (first coll) %) tail)))))
