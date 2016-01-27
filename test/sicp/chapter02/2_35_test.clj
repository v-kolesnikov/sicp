(ns sicp.chapter02.2-35-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-35 :as sicp-2-35]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-count-leves
  (assert-equal 0 (sicp-2-35/count-leaves '()))
  (assert-equal 8 (sicp-2-35/count-leaves '(((1 2) 3 4) ((1 2) 3 4)))))
