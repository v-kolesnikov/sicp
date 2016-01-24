(ns sicp.chapter02.2-31
  (:require [sicp.common :as sicp]))

(defn tree-map
  [f tree]
  (letfn [(process-node [node]
            (if (list? node)
              (tree-map f node)
              (f node)))]
    (map process-node tree)))

(defn square-tree
  [tree]
  (tree-map sicp/square tree))
