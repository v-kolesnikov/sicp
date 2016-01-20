(ns sicp.chapter02.2-25)

(def solution1
  (comp first rest first rest rest))

(def solution2
  (comp first first))

(def solution3
  (let [f (comp first rest)]
    (comp f f f f f f)))
