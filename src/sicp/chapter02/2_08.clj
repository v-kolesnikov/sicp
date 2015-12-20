(ns sicp.chapter02.2-08
  (:require [sicp.chapter02.2-07 :refer :all]))

(defn sub-interval
  [a b]
  (make-interval (- (lower-bound a)
                    (upper-bound b))
                 (- (upper-bound a)
                    (lower-bound b))))
