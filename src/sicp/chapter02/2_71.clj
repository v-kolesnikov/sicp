(ns sicp.chapter02.2-71
  (:require [sicp.chapter02.2-69 :as sicp-2-69]))

(defn exp-frequency-huffman-tree
  [n]
  (let [start (int \A)
        int->symbol (comp symbol str char)
        symbol-freq (fn [idx sym]
                      (list sym (->> idx (Math/pow 2) int)))]
    (->> (range start (+ start n))
         (map int->symbol)
         (map-indexed symbol-freq)
         (sicp-2-69/generate-huffman-tree))))
