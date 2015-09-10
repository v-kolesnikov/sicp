(ns sicp.chapter01.1-23-test
  (:require [clojure.test :refer :all]
            [sicp.test-helper :refer :all]
            [sicp.chapter01.1-23 :refer :all]
            [sicp.common :refer [avg]]))

(deftest test-search-for-primes
  (let [searched-primes
        (map #(search-for-primes % 3) [1000 10000 100000 1000000 10000000])
        avg-times (reduce #(conj %1 (avg (vals %2))) nil searched-primes)
        avg-ratio (->> avg-times
                       (partition 2 1)
                       (reduce #(conj %1
                                      (float (/ (first %2)
                                                (second %2))))
                               nil)
                       (avg))]
    (println "Average time:" (avg avg-times))
    (println "Average times:" avg-times)
    (println "Average ratio:" avg-ratio)))
