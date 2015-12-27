(ns sicp.chapter01.1-45
  (:require [sicp.chapter01.1-16 :refer [fast-expt]]
            [sicp.chapter01.1-35 :refer [fixed-point]]
            [sicp.chapter01.1-36 :refer [average-damp]]
            [sicp.chapter01.1-43 :refer [repeated]]))

(defn nth-root
  [x n]
  (let [damps (Math/ceil (dec (/ (Math/log (inc n))
                                 (Math/log 2))))
        nth-average (repeated average-damp
                              damps)
        transform #(/ x (fast-expt % (dec n)))]
    (fixed-point (nth-average transform)
                 1.0)))
