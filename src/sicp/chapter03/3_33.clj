(ns sicp.chapter03.3-33
  (:require [sicp.chapter03.constraints :refer [connect error forget-value!
                                                get-value has-value?
                                                set-value!]]
            [sicp.common :as c]))

(defn averager
  [a b c]
  (letfn [(process-new-value []
            (let [has-values? (fn [& args] (every? has-value? args))
                  new-a (fn [] (c/avg [(get-value b) (get-value c)]))
                  new-b (fn [] (c/avg [(get-value a) (get-value c)]))
                  new-c (fn [] (c/avg [(get-value a) (get-value b)]))]
              (cond (has-values? a b) (set-value! c (new-c) me)
                    (has-values? a c) (set-value! b (new-b) me)
                    (has-values? b c) (set-value! a (new-a) me))))
          (process-forget-value []
                                (forget-value! a me)
                                (forget-value! b me)
                                (forget-value! c me)
                                (process-new-value))
          (me [request]
              (cond (= request :I-have-a-value) (process-new-value)
                    (= request :I-lost-my-value) (process-forget-value)
                    :else (error "Unknown request -- AVEARAGER" request)))]
    (connect a me)
    (connect b me)
    (connect c me)
    me))
