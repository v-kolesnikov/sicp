(ns sicp.chapter02.2-72-test
  (:require [sicp.chapter02.2-69 :as sicp-2-69]
            [sicp.extra.graph.viz :as v]))

(v/render-image :huffman
                (sicp-2-69/generate-huffman-tree '((A 8) (B 7) (C 6) (D 5)))
                "target/2_72_test.png")
