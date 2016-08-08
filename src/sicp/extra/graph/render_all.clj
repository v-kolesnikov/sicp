(ns sicp.extra.graph.render-all
  (:require [sicp.chapter02.2-64 :as sicp-2-64]
            [sicp.chapter02.2-71 :as sicp-2-71]
            [sicp.extra.graph.viz :as v]))

(defn draw-tree-2-64 []
  (let [tree (sicp-2-64/list->tree '(1 3 5 7 9 11))]
    (v/render-image :simple tree "target/2_64_test.png")))

(defn draw-tree-2-71 []
  (v/render-image :huffman
                  (sicp-2-71/exp-frequency-huffman-tree 5)
                  "target/2_71_test_freq_05.png"))

(defn -main [& args]
  (draw-tree-2-64)
  (draw-tree-2-71)
  (System/exit 0))
