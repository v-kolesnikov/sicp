(ns sicp.chapter01.1-03)

(defn solution
  [a b c]
  (let [square (fn [x] (* x x))
        peaks (take-last 2 (sort [a b c]))]
    (+ (square (first peaks))
       (square (second peaks)))))
