(ns sicp.chapter03.3-07)

(defn make-joint
  [account source-password new-password]
  (fn [password & args]
    (if (= password new-password)
      (apply account source-password args)
      ; There is a vulnerability: if original account was created with nil as
      ; a password, then any password that doen't match to new-password will
      ; grant access to the original account.
      (apply account nil args))))
