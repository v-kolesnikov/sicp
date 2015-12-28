(ns sicp.chapter02.2-09
  (:require [sicp.chapter02.2-07 :as sicp-2-07]
            [sicp.chapter02.2-08 :as sicp-2-08]))

(defn interval-width
  [x]
  (let [length #(Math/abs (- (sicp-2-07/upper-bound %)
                             (sicp-2-07/lower-bound %)))]
    (/ (length x) 2.0)))

(defn solution
  ; Takes two intervals and check that the width of the
  ; they sum and difference, depends only on their width.
  [a b]
  (let [width-of-sum (interval-width (sicp-2-07/add-interval a b))
        width-of-sub (interval-width (sicp-2-08/sub-interval a b))
        sum-of-width (+ (interval-width a)
                        (interval-width b))]
    (= width-of-sum
       width-of-sub
       sum-of-width)))
