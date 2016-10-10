(ns sicp.chapter02.2-77.scheme-number
  (:require [sicp.common.dispatch-table :as dt]
            [sicp.common.tagged-data :as t]))

(defn tag [x]
  (t/attach-tag 'scheme-number x))

(defn add [x y] (+ x y))
(defn sub [x y] (- x y))
(defn mul [x y] (* x y))
(defn div [x y] (/ x y))

(defn install-package [table]
  (dt/put table 'add '(scheme-number scheme-number) (comp tag add))
  (dt/put table 'sub '(scheme-number scheme-number) (comp tag sub))
  (dt/put table 'mul '(scheme-number scheme-number) (comp tag mul))
  (dt/put table 'div '(scheme-number scheme-number) (comp tag div))
  (dt/put table 'make 'scheme-number tag)
  'done)
