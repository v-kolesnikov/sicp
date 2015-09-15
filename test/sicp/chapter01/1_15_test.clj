(ns sicp.chapter01.1-15-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-15 :refer :all]))

(deftest test-sine
  (assert-true (< (Math/abs (- (Math/sin 12.15)
                               (sicp.chapter01.1-15/sine 12.15)))
                  0.1)))
