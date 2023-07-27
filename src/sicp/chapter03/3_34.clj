(ns sicp.chapter03.3-34
  (:require [sicp.chapter03.constraints :refer [multiplier]]))

(defn squarter
  [a b]
  (multiplier a a b))
