(ns sicp.chapter02.2-33
  (:refer-clojure :exclude [map]))

(defn map
  [f coll]
  (reduce #(concat %1 (list (f %2))) '() coll))

(defn append
  [coll1 coll2]
  (reduce #(concat %1 (list %2)) coll1 coll2))

(defn length
  [coll]
  (reduce (fn [acc x] (inc acc)) 0 coll))
