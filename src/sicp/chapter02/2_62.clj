(ns sicp.chapter02.2-62)

(defn union-set
  [set1 set2]
  (loop [[x1 & xs1 :as st1] set1
         [x2 & xs2 :as st2] set2
         acc '()]
    (cond
      (empty? st1) (-> acc reverse (concat st2))
      (empty? st2) (-> acc reverse (concat st1))
      (= x1 x2) (recur xs1 xs2 (cons x1 acc))
      (< x1 x2) (recur xs1 st2 (cons x1 acc))
      (> x1 x2) (recur st1 xs2 (cons x2 acc)))))
