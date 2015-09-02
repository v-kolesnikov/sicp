(ns sicp.chapter01.1-12)

(defn pascal-triangle-element [n k]
  (cond
    (or (neg? k)
        (neg? n)
        (< n k)) nil
    (or (zero? k)
        (= k n)) 1
    (or (= k 1)
        (= k (dec n))) n
    :else (+ (pascal-triangle-element (dec n)
                                      (dec k))
             (pascal-triangle-element (dec n)
                                      k))))
