(ns sicp.chapter02.2-77.rational
  (:require [sicp.common :as sicp]
            [sicp.common.dispatch-table :as dt]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t]))

(defn tag [x]
  (t/attach-tag 'rational x))

(defn numer [x] (p/car x))
(defn denom [x] (p/cdr x))

(defn make [n d]
  (let [g (sicp/gcd n d)]
    (p/cons (/ n g)
            (/ d g))))

(defn add [x y]
  (make (+ (* (numer x) (denom y))
           (* (numer y) (denom x)))
        (* (denom x) (denom y))))

(defn sub [x y]
  (make (- (* (numer x) (denom y))
           (* (numer y) (denom x)))
        (* (denom x) (denom y))))

(defn mul [x y]
  (make (* (numer x) (numer y))
        (* (denom y) (denom x))))

(defn div [x y]
  (make (* (numer x) (denom y))
        (* (denom x) (numer y))))

(defn install-package [table]
  (dt/put table 'add '(rational rational) (comp tag add))
  (dt/put table 'sub '(rational rational) (comp tag sub))
  (dt/put table 'mul '(rational rational) (comp tag mul))
  (dt/put table 'div '(rational rational) (comp tag div))
  (dt/put table 'make 'rational (comp tag make))
  'done)
