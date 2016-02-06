(ns sicp.chapter02.2-48-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-02 :as sicp-2-48]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-segment
  (assert-equal [[0 0] [1 1]] (sicp-2-48/make-segment [0 0] [1 1])))

(deftest test-start-segment
  (let [segment (sicp-2-48/make-segment [0 0] [1 1])]
    (assert-equal [0 0] (sicp-2-48/start-segment segment))))

(deftest test-end-segment
  (let [segment (sicp-2-48/make-segment [0 0] [1 1])]
    (assert-equal [1 1] (sicp-2-48/end-segment segment))))
