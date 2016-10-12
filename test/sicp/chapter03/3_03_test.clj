(ns sicp.chapter03.3-03-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter03.3-03 :as sicp-3-03]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-account
  (let [acc1 (sicp-3-03/make-account 200 'hello)
        acc2 (sicp-3-03/make-account 250 'world)]
    (assert-equal 170 ((acc1 'hello 'withdraw) 30))
    (assert-equal nil ((acc1 'world 'withdraw) 40))

    (assert-equal 180 ((acc1 'hello 'deposit) 10))
    (assert-equal nil ((acc1 'olleh 'deposit) 10))

    (assert-equal 220 ((acc2 'world 'withdraw) 30))
    (assert-equal nil ((acc2 'hello 'withdraw) 40))

    (assert-equal 230 ((acc2 'world 'deposit) 10))
    (assert-equal nil ((acc2 'dlrow 'deposit) 10))))
