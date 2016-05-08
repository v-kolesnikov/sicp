(ns sicp.chapter02.2-68
  (:require [sicp.chapter02.2-59 :refer [element-of-set?]]
            [sicp.chapter02.2-67 :refer :all]))

(defn encode-symbol [tree sym]
  (loop [node tree
         bits '()]
    (if (leaf? node)
      (reverse bits)
      (let [[l-branch r-branch _ _] node
            next-branch? (fn [branch] (->> branch symbols (element-of-set? sym)))]
        (cond (next-branch? l-branch) (recur l-branch (cons 0 bits))
              (next-branch? r-branch) (recur r-branch (cons 1 bits))
              :else (throw (Exception. (str "Error: tree does not contain the symbol " sym))))))))

(defn encode
  [tree message]
  (loop [[head & tail] message
         encoded-message '()]
    (if (nil? head)
      encoded-message
      (recur tail
             (concat encoded-message
                     (encode-symbol tree head))))))
