(ns sicp.chapter01.1-37-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [round]]
            [sicp.chapter01.1-37 :refer :all]))

(deftest test-golden-ratio-approximation
  (assert-equal 1.6180 (round (golden-ration-approximation 12) 4)))
