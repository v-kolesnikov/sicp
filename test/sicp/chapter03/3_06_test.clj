(ns sicp.chapter03.3-06-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-06 :refer :all]))

(deftest test-rand'
  (is (= 0 ((rand' :reset) 0)))
  (is (= 1 (rand' :generate)))
  (is (= 2 (rand' :generate)))
  (is (= 7 ((rand' :reset) 7)))
  (is (= 8 (rand' :generate)))
  (is (= 9 (rand' :generate)))
  (is (= 0 ((rand' :reset) 0))))
