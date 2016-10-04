(ns sicp.test-helper
  (:require [clojure.test :refer [is]]))

(defmacro assert-equal
  ([expected actual] `(assert-equal ~expected ~actual nil))
  ([expected actual msg] `(is (= ~expected ~actual) ~msg)))

(defmacro assert-true
  ([expr] `(assert-true ~expr nil))
  ([expr msg] `(is ~expr ~msg)))

(defmacro assert-false
  ([expr] `(assert-false ~expr nil))
  ([expr msg] `(assert-true (not ~expr) ~msg)))
