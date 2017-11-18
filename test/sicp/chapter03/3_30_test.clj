(ns sicp.chapter03.3-30-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-30 :refer [ripple-carry-adder]]
            [sicp.chapter03.wirelang :refer [get-signal make-wire propagate
                                             set-signal!]]))

(defn make-wires
  [signals]
  (reduce (fn [wires signal]
            (let [wire (make-wire)]
              (set-signal! wire signal)
              (conj wires wire)))
          []
          signals))

(deftest test-ripple-carry-adder
  (let [input-a (make-wires [1 1 0 1])
        input-b (make-wires [0 1 1 0])
        carry-input (make-wire)
        carry-output (make-wire)
        output-sum (make-wires [0 0 0 0])
        test-signals (fn [input-a-signals input-b-signals]
                       (ripple-carry-adder (make-wires input-a-signals)
                                           (make-wires input-b-signals)
                                           carry-input
                                           carry-output
                                           output-sum)
                       (propagate)
                       [(get-signal carry-output)
                        (map get-signal output-sum)])]
    ; 0 | 0 0 1 1
    ; 0 | 0 0 1 0
    ; 0 | 0 1 0 1
    (is (= [0 [0 1 0 1]] (test-signals [0 0 1 1] [0 0 1 0])))
    ; 0 | 1 1 0 1
    ; 0 | 0 1 1 0
    ; 1 | 0 0 1 1
    (is (= [1 [0 0 1 1]] (test-signals [1 1 0 1] [0 1 1 0])))))
