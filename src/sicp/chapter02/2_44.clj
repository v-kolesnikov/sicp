(ns sicp.chapter02.2-44
  (:require [sicp.chapter02.picture-language.core :as pl]))

(defn up-split-
  [painter n]
  (if (zero? n)
    painter
    (let [smaller (right-split painter (dec n))]
      (->> smaller
           (pl/beside smaller)
           (pl/below painter)))))

(defn up-split
  [painter n]
  (reduce #(->> %1
                (pl/beside %1)
                (pl/below painter))
          painter
          (range 0 n)))
