(ns sicp.chapter02.2-53)

(defn memq
  [item x]
  (cond (empty? x) false
        (= item  (first x)) x
        :else (memq item (rest x))))
