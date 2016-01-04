(ns sicp.chapter02.2-20)

(defn same-parity
  [& coll]
  (let [same-parity? (fn [a b] (= (mod a 2)
                                  (mod b 2)))
        same-as-first-parity? (partial same-parity?
                                       (first coll))]
    (filter same-as-first-parity?  coll)))
