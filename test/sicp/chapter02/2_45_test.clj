(ns sicp.chapter02.2-45-test
  (:require [clojure.test :refer [deftest function?]]
            [sicp.chapter02.2-45 :as sicp-2-45]
            [sicp.test-helper :refer [assert-true]]))

(def painter? function?)
(def fake-painter identity)

(deftest test-right-split
  (assert-true (painter? (sicp-2-45/right-split fake-painter 1)))
  (assert-true (painter? (sicp-2-45/right-split fake-painter 5))))

(deftest test-upsplit
  (assert-true (painter? (sicp-2-45/up-split fake-painter 1)))
  (assert-true (painter? (sicp-2-45/up-split fake-painter 5))))
