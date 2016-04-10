(ns sicp.chapter02.2-65
  (:require [sicp.chapter02.2-61 :as sicp-2-61]
            [sicp.chapter02.2-62 :as sicp-2-62]
            [sicp.chapter02.2-63 :as sicp-2-63]
            [sicp.chapter02.2-64 :as sicp-2-64]))

(defn union-set [s1 s2]
  (sicp-2-64/list->tree (sicp-2-62/union-set (sicp-2-63/tree->list-2 s1)
                                             (sicp-2-63/tree->list-2 s2))))

(defn intersection-set [s1 s2]
  (sicp-2-64/list->tree (sicp-2-61/intersection-set (sicp-2-63/tree->list-2 s1)
                                                    (sicp-2-63/tree->list-2 s2))))
