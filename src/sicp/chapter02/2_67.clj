(ns sicp.chapter02.2-67
  (:require [sicp.common :refer [error]]))

(defn make-leaf
  [sym weight]
  (list 'leaf sym weight))

(defn leaf?
  [node]
  (= 'leaf (first node)))

(defn symbol-leaf
  [leaf]
  (-> leaf rest first))

(defn weight-leaf
  [leaf]
  (-> leaf rest rest first))

(defn left-branch [[l _ _ _]] l)

(defn right-branch [[_ r _ _]] r)

(defn symbols
  [node]
  (if (leaf? node)
    (list (symbol-leaf node))
    (-> node rest rest first)))

(defn weight
  [node]
  (if (leaf? node)
    (weight-leaf node)
    (-> node rest rest rest first)))

(defn make-code-tree
  [left right]
  (list left
        right
        (concat (symbols left)
                (symbols right))
        (+ (weight left)
           (weight right))))

(defn choose-branch
  [bit branch]
  (cond (zero? bit) (left-branch branch)
        (= bit 1) (right-branch branch)
        :else (error (str "плохой бит -- CHOOSE-BRANCH" bit))))

(defn decode
  [message tree]
  (loop [[first-bit & rest-bits :as bits] message
         current-branch tree
         acc '()]
    (if (empty? bits)
      (reverse acc)
      (let [next-branch (choose-branch first-bit current-branch)]
        (if (leaf? next-branch)
          (recur rest-bits tree (cons (symbol-leaf next-branch) acc))
          (recur rest-bits next-branch acc))))))
