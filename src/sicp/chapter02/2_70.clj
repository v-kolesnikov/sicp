(ns sicp.chapter02.2-70
  (:require [sicp.chapter02.2-69 :refer [generate-huffman-tree]]))

(def rock-songs-alphabet
  (let [freq-map '((A 2) (BOOM 1) (GET 2) (JOB 2) (NA 16) (SHA 3) (YIP 9) (WAH 1))]
    (generate-huffman-tree freq-map)))
