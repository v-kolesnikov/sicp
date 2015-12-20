(ns sicp.chapter02.2-07)

(defn make-interval
  [a b]
  (vector a b))

(defn lower-bound
  [interval]
  (first interval))

(defn upper-bound
  [interval]
  (second interval))

(defn add-interval
  [a b]
  (make-interval (+ (lower-bound a)
                    (lower-bound b))
                 (+ (upper-bound a)
                    (upper-bound b))))

(defn mul-interval [a b]
  (let [p1 (* (lower-bound a) (lower-bound b))
        p2 (* (lower-bound a) (upper-bound b))
        p3 (* (upper-bound a) (lower-bound b))
        p4 (* (upper-bound a) (upper-bound b))]
    (make-interval (min p1 p2 p3 p4)
                   (max p1 p2 p3 p4))))

(defn div-interval
  [a b]
  (mul-interval a
                (make-interval (/ 1.0 (upper-bound b))
                               (/ 1.0 (lower-bound b)))))
