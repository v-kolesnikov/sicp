(ns sicp.chapter02.2-44-test
  (:require [clojure.test :refer [deftest function?]]
            [sicp.chapter02.2-44 :as sicp-2-44]
            [sicp.test-helper :refer [assert-true]]))

(def painter? function?)
(def fake-painter identity)

(deftest test-upsplit-v1
  (assert-true (painter? (sicp-2-44/up-split-v1 fake-painter 1)))
  (assert-true (painter? (sicp-2-44/up-split-v1 fake-painter 5))))

(deftest test-upsplit-v2
  (assert-true (painter? (sicp-2-44/up-split-v2 fake-painter 1)))
  (assert-true (painter? (sicp-2-44/up-split-v2 fake-painter 5))))
