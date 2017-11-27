(ns sicp.chapter03.3-33-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-33 :refer [averager]]
            [sicp.chapter03.constraints :refer [get-value make-connector
                                                set-value!]]))

(deftest test-averager
  (let [a (make-connector)
        b (make-connector)
        c (make-connector)]
    (averager a b c)
    (is (= :done (set-value! a 3 :user)))
    (is (= :done (set-value! b 4 :user)))
    (is (= 3.5 (get-value c)))))
