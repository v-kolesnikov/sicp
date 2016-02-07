(ns sicp.chapter02.2-47)

(defn make-frame
  [origin edge1 edge2]
  (list origin edge1 edge2))

(defn origin-frame
  [[origin _ _]]
  origin)

(defn edge1-frame
  [[_ edge _]]
  edge)

(defn edge2-frame
  [[_ _ edge]]
  edge)
