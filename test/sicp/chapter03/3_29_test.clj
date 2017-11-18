(ns sicp.chapter03.3-29-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-29 :refer [or-gate]]
            [sicp.chapter03.wirelang :refer [and-gate-delay current-time
                                             get-signal inverter-delay
                                             make-wire propagate set-signal!
                                             the-agenda]]))

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

    (let [current-agenda-time (current-time the-agenda)]
      (propagate)
      (is (= (+ and-gate-delay
                inverter-delay
                inverter-delay)
             (- (current-time the-agenda)
                current-agenda-time))))

    (is (= 0 (test-signal 0 0)))
    (is (= 1 (test-signal 1 0)))
    (is (= 1 (test-signal 0 1)))
    (is (= 1 (test-signal 1 1)))))
