(ns sicp.chapter03.3-34-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.3-34 :refer [squarter]]
            [sicp.chapter03.constraints :refer [get-value make-connector probe
                                                set-value!]]))

(deftest test-squarter
  (let [a (make-connector)
        b (make-connector)]
    (squarter a b)

    (probe "A" a)
    (probe "B" b)

    (is (= :done (set-value! a 3 :user)))
    (is (= 9 (get-value b))))

  (let [a (make-connector)
        b (make-connector)]
    (squarter a b)

    (probe "A" a)
    (probe "B" b)

    (is (= :done (set-value! b 9 :user)))
    (is (nil? (get-value a)))))
