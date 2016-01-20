(ns sicp.chapter02.2-22
  (:require [sicp.common :as sicp]))

(defn square-list-v1
  [coll]
  (loop [things coll
         answer nil]
    (if (empty? things)
      (reverse answer)
      (recur (rest things)
             (cons (sicp/square (first things))
                   answer)))))

(defn square-list-v2
  [coll]
  (loop [things coll
         answer nil]
    (if (empty? things)
      answer
      (recur (rest things)
             (concat answer
                     (list (sicp/square (first things))))))))
