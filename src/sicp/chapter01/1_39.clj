(ns sicp.chapter01.1-39
  (:require [sicp.chapter01.1-38 :refer [cont-frac]]
            [sicp.common :refer [square]]))

(defn tan-cf
  [x k]
  (let [n (fn [i] (if (= i 1)
                    x
                    (- (square x))))
        d (fn [i] (dec (* i 2)))]
    (float (cont-frac n d k))))
