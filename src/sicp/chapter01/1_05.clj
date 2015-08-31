(ns sicp.chapter01.1-05)

(defn p []
  (p))

(defn test-eval-order [x y]
  (if (= x 0)
    0
    y))

(test-eval-order 0 (p))
