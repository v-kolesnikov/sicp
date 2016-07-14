(ns sicp.chapter02.2-69-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-67-test :refer [sample-tree]]
            [sicp.chapter02.2-69 :refer [generate-huffman-tree]]
            [sicp.extra.graph.viz :as v]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-generate-huffman-tree
  (assert-equal sample-tree (generate-huffman-tree '((A 4) (B 2) (D 1) (C 1))))
  (assert-equal sample-tree (generate-huffman-tree '((D 1) (C 1) (A 4) (B 2)))))

(v/render-image :huffman
                (generate-huffman-tree '((A 4) (B 2) (D 1) (C 1)))
                "target/2_69-1_test.png")

(v/render-image :huffman
                (generate-huffman-tree '((D 1) (C 1) (A 4) (B 2)))
                "target/2_69-2_test.png")
