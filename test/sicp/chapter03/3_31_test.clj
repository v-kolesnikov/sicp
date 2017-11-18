(ns sicp.chapter03.3-31-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-31 :as sicp-3-31]
            [sicp.chapter03.wirelang :as wirelang :refer [empty-agenda?
                                                          half-adder make-wire
                                                          the-agenda]]))

(deftest test-make-wire
  (let [original-make-wire wirelang/make-wire]
    (intern 'sicp.chapter03.wirelang 'make-wire sicp-3-31/make-wire)
    (let [input-a (make-wire)
          input-b (make-wire)
          sum (make-wire)
          carry (make-wire)]
      (half-adder input-a input-b sum carry)
      (is (empty-agenda? the-agenda)))
    (intern 'sicp.chapter03.wirelang 'make-wire original-make-wire)))
