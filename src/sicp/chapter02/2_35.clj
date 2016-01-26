(ns sicp.chapter02.2-35)

(defn count-leaves
  [tree]
  (let [f #(if (list? %)
             (count-leaves %)
             1)]
    (->> tree
         (map f)
         (reduce + 0))))
