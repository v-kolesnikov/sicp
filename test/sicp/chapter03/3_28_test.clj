(ns sicp.chapter03.3-28-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-28 :refer [or-gate]]
            [sicp.chapter03.wirelang :refer [get-signal make-wire propagate
                                             set-signal!]]))

(deftest test-or-gate
  (let [input-a (make-wire)
        input-b (make-wire)
        output (make-wire)
        test-signal (fn [signal-a signal-b]
                      (set-signal! input-a signal-a)
                      (set-signal! input-b signal-b)
                      (propagate)
                      (get-signal output))]

    (is (= :ok (or-gate input-a input-b output)))

    (is (= 0 (test-signal 0 0)))
    (is (= 1 (test-signal 1 0)))
    (is (= 1 (test-signal 0 1)))
    (is (= 1 (test-signal 1 1)))))
