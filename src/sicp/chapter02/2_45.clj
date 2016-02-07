(ns sicp.chapter02.2-45
  (:require [sicp.chapter02.picture-language.core :as pl]))

(defn split
  [op1 op2]
  (fn [painter n]
    (reduce #(->> %1
                  (op2 %1)
                  (op1 %1))
            painter
            (range 0 n))))

(def right-split (split pl/beside pl/below))
(def up-split (split pl/below pl/beside))
