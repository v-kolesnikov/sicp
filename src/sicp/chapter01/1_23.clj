(ns sicp.chapter01.1-23
  (:require [sicp.common :refer [square]]))

(defn divides? [a b]
  (zero? (rem b a)))

(defn find-divisor [n test-divisor]
  (let [next-divisor (fn [n]
                       (if (> n 2) (+ n 2) 3))]
    (cond
      (> (square test-divisor)
         n) n
      (divides? test-divisor n) test-divisor
      :else (find-divisor n
                          (next-divisor test-divisor)))))

(defn smallest-divisor [n]
  (find-divisor n 2))

(defn prime? [n]
  (= n (smallest-divisor n)))

(defn start-prime-test
  [n start-time]
  (if (prime? n)
    (hash-map n
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
