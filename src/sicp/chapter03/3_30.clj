(ns sicp.chapter03.3-30
  (:require [sicp.chapter03.wirelang :refer [full-adder make-wire]]))

(defn ripple-carry-adder
  [input-a input-b input-carry output-carry output-sum]
  (loop [[nth-input-a & rest-input-a] (reverse input-a)
         [nth-input-b & rest-input-b] (reverse input-b)
         nth-input-carry input-carry
         [nth-output-sum & rest-output-sum] (reverse output-sum)]
    (let [nth-output-carry (if (empty? rest-input-a)
                             output-carry
                             (make-wire))]
      (full-adder nth-input-a
                  nth-input-b
                  nth-input-carry
                  nth-output-carry
                  nth-output-sum)
      (when-not (empty? rest-output-sum)
        (recur rest-input-a
               rest-input-b
               nth-output-carry
               rest-output-sum)))))
