(ns sicp.chapter03.3-04)

(defn make-account
  [start password]
  (let [balance (atom start)
        try-counter (atom 0)]
    (letfn [(withdraw [amount]
              (if (>= @balance amount)
                (swap! balance - amount)
                (assert nil "Insufficient funds")))
            (deposit [amount] (swap! balance + amount))
            (dispatch
             [pass m]
             (if (= pass password)
               (do (reset! try-counter 0)
                   (cond (= m 'withdraw) withdraw
                         (= m 'deposit) deposit
                         :else (assert nil "Unknown request: MAKE-ACCOUNT")))
               (fn [& _]
                 (do (swap! try-counter inc)
                     (when (>= @try-counter 7)
                       (call-the-cops!))))))
            (call-the-cops!
             []
             (throw (Exception. (format "You made %s of failed login attempts."
                                        @try-counter))))]
      dispatch)))
