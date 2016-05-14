(ns sicp.chapter02.2-69-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-67 :as sicp-2-67]
            [sicp.chapter02.2-69 :as sicp-2-69]
            [sicp.extra.graph.viz :as v]
            [sicp.test-helper :refer :all]))

(def sample-tree
  (->> (sicp-2-67/make-leaf 'C 1)
       (sicp-2-67/make-code-tree (sicp-2-67/make-leaf 'D 1))
       (sicp-2-67/make-code-tree (sicp-2-67/make-leaf 'B 2))
       (sicp-2-67/make-code-tree (sicp-2-67/make-leaf 'A 4))))

(deftest test-generate-huffman-tree
  (assert-equal sample-tree (sicp-2-69/generate-huffman-tree '((A 4) (B 2) (D 1) (C 1))))
  (assert-equal sample-tree (sicp-2-69/generate-huffman-tree '((D 1) (C 1) (A 4) (B 2)))))

(deftest test-draw-tree
  (let [tree (sicp-2-69/generate-huffman-tree '((A 8) (B 3) (C 1) (D 1) (E 1) (F 1) (G 1) (H 1)))]
    (assert-true (v/render-image :huffman tree "target/2_69_test.png"))))
