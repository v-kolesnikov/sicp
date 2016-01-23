(ns sicp.chapter02.2-29-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-29 :as sicp-2-29]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-total-weight
  (let [mobile (sicp-2-29/make-mobile '(1 2) '(2 3))]
    (assert-equal 5 (sicp-2-29/total-weight mobile))))
