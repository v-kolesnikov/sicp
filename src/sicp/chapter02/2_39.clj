(ns sicp.chapter02.2-39
  (:require [sicp.chapter02.2-38 :as sicp-2-38]
            [sicp.common :as sicp]))

(def fold-right sicp/accumulate)
(def fold-left sicp-2-38/fold-left-v2)

(defn reverse-right
  [coll]
  (fold-right #(concat %2 (list %1)) '() coll))

(defn reverse-left
  [coll]
  (fold-left conj '() coll))
