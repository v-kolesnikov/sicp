(ns sicp.chapter03.3-06)

(def random-init 0)
(defn rand-update [x] (inc x))

(def rand'
  (let [state (atom random-init)]
    (fn [msg]
      (cond (= msg :generate) (do (swap! state rand-update)
                                  @state)
            (= msg :reset) (fn [new-state] (reset! state new-state))
            :else :unknown-msg))))
