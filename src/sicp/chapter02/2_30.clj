(ns sicp.chapter02.2-30
  (:require [sicp.common :as sicp]))

(defn square-tree-v1
  [tree]
  (let [leave? (comp not list?)]
    (cond (leave? tree) (sicp/square tree)
          (empty? tree) '()
          :else (cons (square-tree-v1 (first tree))
                      (square-tree-v1 (rest tree))))))

(defn square-tree-v2
  [tree]
  (letfn [(square-node [node]
            (if (list? node)
              (square-tree-v2 node)
              (sicp/square node)))]
    (map square-node tree)))
