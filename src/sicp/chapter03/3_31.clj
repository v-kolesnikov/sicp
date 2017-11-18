(ns sicp.chapter03.3-31
  (:require [sicp.chapter03.wirelang :refer [call-each]]))

(defn make-wire []
  (let [signal-value (atom 0)
        action-procs (atom [])]
    (letfn [(set-signal! [value]
              {:pre [(contains? [0 1] value)]}
              (if-not (= @signal-value value)
                (do (reset! signal-value value)
                    (call-each @action-procs))
                :done))
            (accept-action-proc! [proc] (swap! action-procs conj proc))]
      {:get-signal (fn [] @signal-value)
       :set-signal! set-signal!
       :add-action! accept-action-proc!
       :actions (fn [] @action-procs)})))
