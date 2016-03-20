(ns sicp.chapter01.1-45
  (:require [sicp.chapter01.1-16 :refer [fast-expt]]
            [sicp.chapter01.1-35 :refer [fixed-point]]
            [sicp.chapter01.1-36 :refer [average-damp]]
            [sicp.chapter01.1-43 :refer [repeated]]))

(defn nth-root
  [x n]
  (let [damp-count (-> n inc Math/log (/ (Math/log 2)) dec Math/ceil)
        nth-damp (repeated average-damp damp-count)
        transform #(->> n dec (fast-expt %) (/ x))]
    (fixed-point (nth-damp transform) 1.0)))
