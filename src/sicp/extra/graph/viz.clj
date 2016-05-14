(ns sicp.extra.graph.viz
  (:require [clojure.string :as s]
            [rhizome.dot :as d]
            [rhizome.viz :as g]
            [sicp.chapter02.2-67 :as sicp-2-67]))

(defn tree-type-dispatch
  [tag & _] tag)

(defmulti tree-structure #'tree-type-dispatch)

(defmethod tree-structure :simple
  [_ tree]
  (let [descriptor #(hash-map :label (first %))]
    [seq rest tree :node->descriptor descriptor]))

(defmethod tree-structure :huffman
  [_ tree]
  (let [branch? #(not (sicp-2-67/leaf? %))
        children #(vector (sicp-2-67/left-branch %)
                          (sicp-2-67/right-branch %))
        descriptor #(hash-map
                     :label (if (sicp-2-67/leaf? %)
                              (s/join \space (rest %))
                              (format "{%s} %d"
                                      (s/join \space (sicp-2-67/symbols %))
                                      (sicp-2-67/weight %))))]
    [branch? children tree :node->descriptor descriptor]))

(defn tree->dot
  [tag tree]
  (->> tree
       (tree-structure tag)
       (apply d/tree->dot)))

(defn render-image
  [tag tree filename]
  (-> (tree->dot tag tree)
      (g/dot->image)
      (g/save-image filename)))
