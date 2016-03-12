(ns sicp.chapter02.2-61)

(defn adjoin-set
  [elm s]
  (loop [[x & xs :as st] s
         acc '()]
    (cond
      (empty? st) (-> elm (cons acc) reverse)
      (= elm x) s
      (< elm x) (-> elm (cons acc) reverse (concat st))
      :else (recur xs (cons x acc)))))

(defn element-of-set?
  [elm s]
  (loop [[x & xs :as st] s]
    (cond (empty? st) false
          (= elm x) true
          (< elm x) false
          :else (recur xs))))

(defn intersection-set
  [set1 set2]
  (loop [[x1 & xs1 :as st1] set1
         [x2 & xs2 :as st2] set2
         acc '()]
    (cond
      (or (empty? st1) (empty? st2)) (reverse acc)
      (= x1 x2) (recur xs1 xs2 (cons x1 acc))
      (< x1 x2) (recur xs1 st2 acc)
      (> x1 x2) (recur st1 xs2 acc))))
