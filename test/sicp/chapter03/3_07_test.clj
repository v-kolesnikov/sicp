(ns sicp.chapter03.3-07-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-03 :refer [make-account]]
            [sicp.chapter03.3-07 :refer [make-joint]]))

(deftest test-make-joint
  (let [peter-acc (make-account 200 'open-sesame)
        paul-acc  (make-joint peter-acc 'open-sesame 'rosebud)]
    (is (= 170 ((peter-acc 'open-sesame 'withdraw) 30)))
    (is (= nil ((peter-acc 'rosebud 'withdraw) 40)))
    (is (= 170 ((peter-acc 'open-sesame 'withdraw) 0)))
    (is (= 170 ((paul-acc  'rosebud 'withdraw) 0)))
    (is (= 140 ((paul-acc  'rosebud 'withdraw) 30)))
    (is (= nil ((paul-acc  'open-sesame 'withdraw) 40)))
    (is (= 140 ((peter-acc 'open-sesame 'withdraw) 0)))))
