(ns sicp.chapter02.2-34
  (:require [sicp.common :as sicp]))

(defn horner-eval-v1
  [x coefficient-sequence]
  (sicp/accumulate (fn [this-coeff higher-terms]
                     (+ this-coeff
                        (* x higher-terms)))
                   0
                   coefficient-sequence))

(defn horner-eval-v2
  [x coefficient-sequence]
  (let [f (fn [higher-terms this-coeff]
            (+ this-coeff
               (* x higher-terms)))]
    (->> coefficient-sequence
         reverse
         (reduce f 0))))
