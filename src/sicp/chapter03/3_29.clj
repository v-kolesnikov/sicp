(ns sicp.chapter03.3-29
  (:require [sicp.chapter03.wirelang :refer [after-delay and-gate get-signal
                                             inverter logical-or make-wire
                                             or-gate-delay set-signal!]]))

(defn or-gate
  [input-a input-b output]
  (let [or-proc (fn []
                  (let [value (logical-or (get-signal input-a)
                                          (get-signal input-b))]
                    (after-delay or-gate-delay
                                 (fn [] (set-signal! output value)))))
        not-input-a (make-wire)
        not-input-b (make-wire)
        not-and-gate (make-wire)]

    ; A || B = !(!A & !B)
    (inverter input-a not-input-a) ; !A
    (inverter input-b not-input-b) ; !B
    (and-gate not-input-a not-input-b not-and-gate) ; (!A & !B)
    (inverter not-and-gate output) ; !(!A & !B)

    :ok))
