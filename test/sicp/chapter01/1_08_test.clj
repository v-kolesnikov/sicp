(ns sicp.chapter01.1-08-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-08 :refer :all]))

(deftest test-cbrt
  (assert-equal 2.0 (cbrt 8))
  (assert-equal 3.0 (cbrt 27))
  (assert-equal 4.0 (cbrt 64))
  (assert-equal 5.0 (cbrt 125))
  (assert-equal 6.0 (cbrt 216))
  (assert-equal 7.0 (cbrt 343))
  (assert-equal 8.0 (cbrt 512))
  (assert-equal 9.0 (cbrt 729)))
