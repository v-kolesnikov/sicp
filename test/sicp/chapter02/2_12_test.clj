(ns sicp.chapter02.2-12-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-12 :as sicp-2-12]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-percent
  (assert-equal 10.0 (sicp-2-12/percent (sicp-2-12/make-center-percent 100 10)))
  (assert-equal 20.0 (sicp-2-12/percent (sicp-2-12/make-center-percent 400 20))))
