(ns sicp.chapter01.1-05)

(defn p []
  (p))

(defn test-eval-order [x y]
  (if (zero? x)
    0
    y))

; The following code should throw an exception
; (test-eval-order 0 (p))
