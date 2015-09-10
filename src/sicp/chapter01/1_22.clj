(ns sicp.chapter01.1-22
  (:require [sicp.chapter01.1-21 :refer [prime?]]
            [sicp.common :refer [avg]]))

(defn report-prime
  [n elapsed-time]
  (hash-map n elapsed-time))

(defn start-prime-test
  [n start-time]
  (if (prime? n)
    (report-prime n
                  (- (System/nanoTime)
                     start-time))))

(defn timed-prime-test
  [n]
  (start-prime-test n (System/nanoTime)))

(defn search-for-primes
  [start prime-count]
  (loop [number (inc start)
         acc {}]
    (cond
      (= (count acc)
         prime-count) acc
      :else (recur (+ number 2)
                   (conj acc
                         (timed-prime-test number))))))

(defn avg-time-ratio
  [count-primes start-values]
  (->> start-values
       (map #(search-for-primes % count-primes))
       (reduce #(conj %1
                      (avg (vals %2)))
               nil)
       (partition 2 1)
       (reduce #(conj %1
                      (float (/ (first %2)
                                (second %2))))
               nil)
       (avg)))
