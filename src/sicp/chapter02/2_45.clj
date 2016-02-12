(ns sicp.chapter02.2-45
  (:require [sicp.chapter02.2-44 :refer [below beside]]))

(defn split
  [op1 op2]
  (fn [painter n]
    (reduce (fn [p _]
              (->> p
                   (op2 p)
                   (op1 p)))
            painter
            (range 0 n))))

(def right-split (split beside below))
(def up-split (split below beside))
