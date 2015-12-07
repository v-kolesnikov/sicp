(ns sicp.chapter02.2-02)

(defn make-point
  [x y]
  (vector x y))

(defn x-point
  [z]
  (first z))

(defn y-point
  [z]
  (second z))

(defn make-segment
  [x y]
  (vector x y))

(defn start-segment
  [z]
  (first z))

(defn end-segment
  [z]
  (second z))

(defn str-point
  [z]
  (str "(" (x-point z) "," (y-point z) ")"))

(defn midpoint-segment
  [z]
  (let [x (/ (+ (x-point (start-segment z))
                (x-point (end-segment z)))
             2)
        y (/ (+ (y-point (start-segment z))
                (y-point (end-segment z)))
             2)]
    (make-point x y)))
