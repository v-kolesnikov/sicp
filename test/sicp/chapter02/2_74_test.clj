(ns sicp.chapter02.2-74-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-74 :as sicp-2-74]
            [sicp.test-helper :refer :all]))

(def engineering-package
  (sicp-2-74/install-engineering-department))

(def sales-package
  (sicp-2-74/install-sales-department))

(deftest test-get-record
  (assert-true (sicp-2-74/get-record 'engineering 'Hugo))
  (assert-true (sicp-2-74/get-record 'engineering 'Alyssa))
  (assert-true (sicp-2-74/get-record 'engineering 'Ben))
  (assert-true (sicp-2-74/get-record 'engineering 'Eva))

  (assert-true (sicp-2-74/get-record 'sales 'Mike))
  (assert-true (sicp-2-74/get-record 'sales 'Jennifer))
  (assert-true (sicp-2-74/get-record 'sales 'Scott))

  (assert-false (sicp-2-74/get-record 'engineering 'Mike))
  (assert-false (sicp-2-74/get-record 'sales 'Hugo)))

(deftest test-get-salary
  (assert-equal 60000  (sicp-2-74/get-salary 'engineering 'Hugo))
  (assert-equal 90000  (sicp-2-74/get-salary 'engineering 'Alyssa))
  (assert-equal 110000 (sicp-2-74/get-salary 'engineering 'Ben))
  (assert-equal 100000 (sicp-2-74/get-salary 'engineering 'Eva))

  (assert-equal 200000 (sicp-2-74/get-salary 'sales 'Mike))
  (assert-equal 180000 (sicp-2-74/get-salary 'sales 'Jennifer))
  (assert-equal 250000 (sicp-2-74/get-salary 'sales 'Scott)))

(deftest test-find-employee-record
  (assert-true (sicp-2-74/find-employee-record ['engineering 'sales] 'Hugo))
  (assert-true (sicp-2-74/find-employee-record ['engineering 'sales] 'Mike))
  (assert-false (sicp-2-74/find-employee-record ['engineering 'sales] 'Bob)))
