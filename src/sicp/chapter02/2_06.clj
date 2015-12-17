(ns sicp.chapter02.2-06)

(def zero
  (fn [f]
    (fn [x] x)))

(defn add-1
  [n]
  (fn [f]
    (fn [x]
      (f ((n f) x)))))

(def one
  (fn [f] f))

(def two
  (fn [f]
    (fn [x]
      (f (f x)))))

(defn add
  [a b]
  (fn [f]
    (fn [x]
      ((a f) ((b f) x)))))
