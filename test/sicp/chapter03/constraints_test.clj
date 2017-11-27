(ns sicp.chapter03.constraints-test
  (:require [clojure.test :refer :all]
            [sicp.chapter03.constraints :refer :all]))

(deftest test-celsius-fahrenheit-converter
  (let [C (make-connector)
        F (make-connector)]
    (celsius-fahrenheit-converter C F)

    (probe "Celcius temp" C)
    (probe "Fahrenheit temp" F)

    (is (= :done (set-value! C 25 :user)))
    (is (= 25 (get-value C)))
    (is (= 77 (get-value F)))

    (is (thrown? Exception (set-value! F 212 :user)))
    (is (= 25 (get-value C)))
    (is (= 77 (get-value F)))

    (is (= :done (forget-value! C :user)))

    (is (= :done (set-value! F 212 :user)))
    (is (= 100 (get-value C)))
    (is (= 212 (get-value F)))))
