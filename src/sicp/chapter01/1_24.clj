(ns sicp.chapter01.1-24
  (:require [sicp.common :refer [square]]))

(defn expmod
  [base exp m]
  (cond
    (zero? exp) 1
    (even? exp) (rem (square (expmod base
                                     (/ exp 2)
                                     m))
                     m)
    :else (rem (* base
                  (expmod base
                          (dec exp)
                          m))
               m)))

(defn fermat-test
  [n]
  (let [try-it (fn [a]
                 (= (expmod a n n) a))]
    (try-it (inc (rand-int (dec n))))))

(defn fast-prime?
  ([n]
   (fast-prime? n 1))
  ([n times]
   (cond
     (zero? times) true
     (fermat-test n) (fast-prime? n (dec times))
     :else false)))

(defn start-prime-test
  [n start-time]
  (if (fast-prime? n)
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
