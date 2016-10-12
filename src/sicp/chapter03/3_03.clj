(ns sicp.chapter03.3-03)

(defn make-account
  [start password]
  (let [balance (atom start)]
    (letfn [(withdraw [amount]
              (if (>= @balance amount)
                (swap! balance - amount)
                (assert nil "Insufficient funds")))
            (deposit [amount] (swap! balance + amount))
            (dispatch [pass m]
                      (if (= pass password)
                        (cond (= m 'withdraw) withdraw
                              (= m 'deposit) deposit
                              :else (assert nil "Unknown request: MAKE-ACCOUNT"))
                        (fn [& _]
                          (do (println "Incorrect password")
                              nil))))]
      dispatch)))
