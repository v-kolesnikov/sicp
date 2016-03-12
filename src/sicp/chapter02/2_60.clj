(ns sicp.chapter02.2-60
  (:require [sicp.chapter02.2-54 :as sicp-2-54]))

(defn element-of-set?
  [x s]
  (cond (empty? s) false
        (sicp-2-54/equal? x (first s)) true
        :else (element-of-set? x (rest s))))

(defn adjoin-set
  [x s]
  (cons x s))

(defn intersection-set-canonical
  [set1 set2]
  (loop [[x & xs :as s1] set1
         acc '()]
    (cond
      (or (empty? s1) (empty? set2)) (reverse acc)
      (element-of-set? x set2) (recur xs (cons x acc))
      :else (recur xs acc))))

(defn intersection-set-functional
  [set1 set2]
  (filter #(element-of-set? % set2) set1))

(defn union-set
  [set1 set2]
  (concat set1 set2))
