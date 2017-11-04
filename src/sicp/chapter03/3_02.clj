(ns sicp.chapter03.3-02)

(defn make-monitored
  [f]
  (let [counter (atom 0)
        call-f (fn ([& args]
                    (swap! counter inc)
                    (apply f args)))
        mf (fn
             ([] (call-f))
             ([arg] (cond
                      (= arg :how-many-calls?) @counter
                      (= arg :reset-count!) (reset! counter 0)
                      :else (call-f arg)))
             ([arg & args] (apply call-f arg args)))]
    mf))
