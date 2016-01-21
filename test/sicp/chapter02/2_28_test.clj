(ns sicp.chapter02.2-28-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-28 :as sicp-2-28]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-fringle
  20
  (prop/for-all [v (gen/list (gen/list gen/int))]
                (= (flatten v)
                   (sicp-2-28/fringle v))))

(deftest test-fringle
  (let [x '((1 2) (3 4))]
    (assert-equal (list) (sicp-2-28/fringle (list)))
    (assert-equal '(1 2 3 4) (sicp-2-28/fringle x))
    (assert-equal '(1 2 3 4 1 2 3 4) (sicp-2-28/fringle (list x x)))))
