(ns sicp.extra.picture-language.segments)

(defn make-segment
  [start end]
  (vector start end))

(defn start-segment
  [[start _]]
  start)

(defn end-segment
  [[_ end]]
  end)
