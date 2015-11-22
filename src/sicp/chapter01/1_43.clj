(ns sicp.chapter01.1-43
  (:require [sicp.chapter01.1-42 :refer [compose]]))

(defn repeated
  [f n]
  (loop [g f
         k (dec n)]
    (if (pos? k)
      (recur (compose f g)
             (dec k))
      g)))
