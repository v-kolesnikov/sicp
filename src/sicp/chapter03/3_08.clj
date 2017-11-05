(ns sicp.chapter03.3-08)

(defn make-f
  []
  (let [current (atom 0)]
    (fn [number]
      (let [existing @current]
        (reset! current number)
        existing))))
