(ns sicp.common.tagged-data
  "Tagged data from SICP section 2.4.2"
  {:author "Vasily Kolesnikov"}
  (:require [sicp.common.pairs :as p]))

(defn attach-tag
  [type-tag contents]
  (p/cons type-tag contents))

(defn tag
  [item]
  (p/car item))

(defn contents
  [item]
  (p/cdr item))
