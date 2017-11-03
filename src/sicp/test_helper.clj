(ns sicp.test-helper
  (:require [clojure.test :refer [is]]))

(defmacro assert-equal
  [expected actual]
  `(assert-true (= ~expected ~actual)))

(defmacro assert-true
  [expr]
  `(is ~expr))

(defmacro assert-false
  [expr]
  `(assert-true (not ~expr)))
