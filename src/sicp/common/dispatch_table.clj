(ns sicp.common.dispatch-table
  "Dispatch methods table from SICP section 2.4 - 2.5"
  {:author "Vasily Kolesnikov"}
  (:require [clojure.pprint :as pp]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t])
  (:refer-clojure :exclude [get]))

(defn make-table []
  (atom (list)))

(defn make-table-item
  [op tag item]
  (p/cons op (t/attach-tag tag item)))

(defn operation
  [table-item]
  (p/car table-item))

(defn tag
  [table-item]
  (t/tag (p/cdr table-item)))

(defn method
  [table-item]
  (t/contents (p/cdr table-item)))

(defn put
  [table op tag item]
  (let [method (make-table-item op tag item)]
    (swap! table conj method)))

(defn get
  [table op t]
  (loop [[head & tail] @table]
    (cond (nil? head) nil
          (and (= (operation head) op)
               (= (tag head) t)) (method head)
          :else (recur tail))))

(defn inspect [table]
  (->> @table
       (map (fn [item] {:operation (operation item)
                        :types (tag item)}))
       (pp/print-table)))
