(ns sicp.chapter03.3-02)

(defn make-monitored
  [f]
  (let [counter (atom 0)]
    (fn [arg]
      (if (= arg 'how-many-calls?)
        @counter
        (do (swap! counter inc)
            (f arg))))))
