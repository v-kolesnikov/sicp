(ns sicp.chapter01.1-41)

(defn double-func [g]
  (fn [x]
    (g (g x))))
