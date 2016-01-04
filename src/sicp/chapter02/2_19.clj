(ns sicp.chapter02.2-19)

(defn no-more?
  [coll]
  (empty? coll))

(defn first-denomination
  [coll]
  (first coll))

(defn except-first-denomination
  [coll]
  (rest coll))

(defn cc
  [amount coin-values]
  (cond (zero? amount) 1
        (or (neg? amount)
            (no-more? coin-values)) 0
        :else (+ (cc amount
                     (except-first-denomination coin-values))
                 (cc (- amount
                        (first-denomination coin-values))
                     coin-values))))
