(ns sicp.chapter02.2-47-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-47 :as sicp-2-47]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-frame
  (assert-equal '([0 0] [1 1] [20 20]) (sicp-2-47/make-frame [0 0] [1 1] [20 20])))

(deftest test-origin-frame
  (let [frame (sicp-2-47/make-frame [0 0] [1 1] [20 20])]
    (assert-equal [0 0] (sicp-2-47/origin-frame frame))))

(deftest test-edge1-frame
  (let [frame (sicp-2-47/make-frame [0 0] [1 1] [20 20])]
    (assert-equal [1 1] (sicp-2-47/edge1-frame frame))))

(deftest test-edge2-frame
  (let [frame (sicp-2-47/make-frame [0 0] [1 1] [20 20])]
    (assert-equal [20 20] (sicp-2-47/edge2-frame frame))))
