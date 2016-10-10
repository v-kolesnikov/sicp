(ns sicp.chapter02.2-77
  (:require [sicp.common :as sicp]
            [sicp.common.dispatch-table :as dt]
            [sicp.chapter02.2-77.scheme-number :as math-numbers]
            [sicp.chapter02.2-77.rational :as math-rational]
            [sicp.chapter02.2-77.complex  :as math-complex]
            [sicp.common.pairs :as p]
            [sicp.common.tagged-data :as t])
  (:refer-clojure :exclude [get]))

(def dispatch-table (dt/make-table))
(def put (partial dt/put dispatch-table))
(def get (partial dt/get dispatch-table))

(defn error [msg] (assert nil msg))

(defn apply-generic
  [op & args]
  (let [type-tags (map t/tag args)]
    (if-let [proc (get op type-tags)]
      (apply proc (map t/contents args))
      (error (format "Not found methods for this types -- APPLY-GENERIC: %s %s"
                     op
                     (pr-str type-tags))))))

(defn make-scheme-number [n]
  ((get 'make 'scheme-number) n))

(defn make-rational [n d]
  ((get 'make 'rational) n d))

(defn make-complex-from-real-imag [x y]
  ((get 'make-from-real-imag 'complex) x y))

(defn make-complex-from-mag-angle [r a]
  ((get 'make-from-mag-angle 'complex) r a))

(defn add [x y] (apply-generic 'add x y))
(defn sub [x y] (apply-generic 'sub x y))
(defn mul [x y] (apply-generic 'mul x y))
(defn div [x y] (apply-generic 'div x y))

(dt/inspect dispatch-table)

(defn install-scheme-number-package []
  (math-numbers/install-package dispatch-table))

(defn install-rational-package []
  (math-rational/install-package dispatch-table))

(defn install-complex-package []
  (math-complex/install-package dispatch-table apply-generic))
