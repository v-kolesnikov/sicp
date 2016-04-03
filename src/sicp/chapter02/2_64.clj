(ns sicp.chapter02.2-64
  (:require [sicp.chapter02.2-63 :refer [make-tree]]))

(defn partial-tree
  [elts n]
  (if (zero? n)
    (cons '() elts)
    (let [left-size (quot (dec n) 2)
          [left-tree & non-left-elts] (partial-tree elts left-size)
          right-size (- n (inc left-size))
          this-entry (first non-left-elts)
          [right-tree & remaining-elts] (partial-tree (rest non-left-elts) right-size)]
      (cons (make-tree this-entry left-tree right-tree)
            remaining-elts))))

(defn list->tree
  [elements]
  (->> elements count (partial-tree elements) first))
