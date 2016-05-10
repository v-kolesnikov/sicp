(ns sicp.chapter02.2-69
  (:require [sicp.chapter02.2-67 :refer [leaf? make-code-tree make-leaf
                                         symbol-leaf weight]]))

(defn adjoin-set
  [elm s]
  (loop [[x & xs :as st] s
         acc '()]
    (cond
      (empty? st) (-> elm (cons acc) reverse)
      (= elm x) s
      (< (weight elm) (weight x)) (-> elm (cons acc) reverse (concat st))
      :else (recur xs (cons x acc)))))

(defn make-leaf-set
  [pairs]
  (->> pairs
       (map (partial apply make-leaf))
       (reduce #(adjoin-set %2 %1) '())))

(defn successive-merge
  [pairs-set]
  (loop [[fst snd & others :as pairs] pairs-set]
    (if (nil? snd)
      fst
      (recur (adjoin-set (make-code-tree fst snd)
                         others)))))

(defn generate-huffman-tree
  [pairs]
  (successive-merge (make-leaf-set pairs)))
