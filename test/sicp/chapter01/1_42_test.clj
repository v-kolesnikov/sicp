(ns sicp.chapter01.1-42-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.common :refer [square]]
            [sicp.chapter01.1-42 :refer :all]))

(deftest test-compose
  (assert-equal 49 ((compose square inc) 6)))
