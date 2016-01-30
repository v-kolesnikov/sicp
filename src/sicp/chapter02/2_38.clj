(ns sicp.chapter02.2-38)

(defn fold-left-v1
  [op initial coll]
  (letfn [(iter [result tail]
            (if (seq tail)
              (iter (op result (first tail))
                    (rest tail))
              result))]
    (iter initial coll)))

(defn fold-left-v2
  [op initial coll]
  (loop [tail coll
         acc initial]
    (if (seq tail)
      (recur (rest tail)
             (op acc
                 (first tail)))
      acc)))
