(ns sicp.test-helper
  (:require [clojure.test :refer [is]]))

(defn assert-equal
  [expected actual]
  (is (= expected actual)))

(defn assert_is
  [actual]
  (is actual))
