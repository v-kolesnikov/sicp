(ns sicp.chapter03.3-01)

(defn make-accumulator
  [start]
  (let [counter (atom start)]
    (fn [x] (swap! counter + x))))
