(ns sicp.chapter03.3-04-test
  (:require [clojure.test :refer [deftest is]]
            [sicp.chapter03.3-04 :as sicp-3-04]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-account
  (let [acc (sicp-3-04/make-account 200 'hello)]
    (dotimes [_ 6] ((acc 'olleh 'withdraw) 30))
    (assert-equal 170 ((acc 'hello 'withdraw) 30)))
  (let [acc (sicp-3-04/make-account 200 'hello)]
    (dotimes [_ 6] ((acc 'olleh 'withdraw) 30))
    (is (thrown? Exception ((acc 'olleh 'withdraw) 30)))))
