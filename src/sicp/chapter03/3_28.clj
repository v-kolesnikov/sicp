(ns sicp.chapter03.3-28
  (:require [sicp.chapter03.wirelang :refer [add-action! after-delay get-signal
                                             logical-or or-gate-delay
                                             set-signal!]]))

(defn or-gate
  [a1 a2 output]
  (let [or-proc
        (fn [] (let [value (logical-or (get-signal a1)
                                       (get-signal a2))]
                 (after-delay or-gate-delay
                              (fn [] (set-signal! output value)))))]
    (add-action! a1 or-proc)
    (add-action! a2 or-proc)
    :ok))
