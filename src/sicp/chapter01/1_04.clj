(ns sicp.chapter01.1-04)

(defn a-plus-abs-b [a b]
  ((if (pos? b) + -) a b))
