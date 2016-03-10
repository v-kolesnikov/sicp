(ns sicp.chapter02.2-59
  (:require [sicp.chapter02.2-54 :as sicp-2-54]))

(defn element-of-set?
  [x s]
  (cond (empty? s) false
        (sicp-2-54/equal? x (first s)) true
        :else (element-of-set? x (rest s))))

(defn adjoin-set
  [x s]
  (if (element-of-set? x s)
    s
    (cons x s)))

(defn intersection-set
  [set1 set2]
  (loop [[fs & rs :as s1] set1
         s2 set2
         acc '()]
    (cond
      (or (empty? s1) (empty? s2)) (reverse acc)
      (element-of-set? fs s2) (recur rs s2 (cons fs acc))
      :else (recur rs s2 acc))))

(defn union-set
  [set1 set2]
  (reduce #(adjoin-set %2 %1) set1 set2))
