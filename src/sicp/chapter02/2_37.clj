(ns sicp.chapter02.2-37)

(defn dot-product
  [v w]
  (reduce + (map * v w)))

(defn matrix-*-vector
  [m v]
  (map #(dot-product % v) m))

(defn transpose
  [m]
  (apply map list m))

(defn matrix-*-matrix
  [m n]
  (let [cols (transpose n)]
    (map #(matrix-*-vector n %) m)))
