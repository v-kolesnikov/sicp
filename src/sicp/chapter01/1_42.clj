(ns sicp.chapter01.1-42)

(defn compose
  [f g]
  (fn [x] (f (g x))))
