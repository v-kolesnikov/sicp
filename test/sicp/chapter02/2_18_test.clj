(ns sicp.chapter02.2-18-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-18 :as sicp-2-18]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-reverse
  20
  (prop/for-all [v (gen/list gen/int)]
                (= (reverse v)
                   (sicp-2-18/reverse v))))

(deftest test-reverse
  (assert-equal '(25 16 9 4 1)
                (sicp-2-18/reverse (list 1 4 9 16 25))))
