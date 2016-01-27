(ns sicp.chapter02.2-36-test
  (:require [clojure.test :refer [deftest]]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-36 :as sicp-2-36]
            [sicp.test-helper :refer [assert-equal]]))

(ct/defspec spec-accumulate-n
  20
  (prop/for-all [v (->> (gen/generate gen/nat)
                        (gen/vector gen/int)
                        (gen/fmap seq)
                        (gen/list)
                        (gen/not-empty))]
                (= (apply map + v)
                   (sicp-2-36/accumulate-n-v1 + 0 v)
                   (sicp-2-36/accumulate-n-v2 + 0 v))))

(deftest test-accumulate-n
  (let [s '((1 2 3) (4 5 6) (7 8 9) (10 11 12))]
    (assert-equal '(22 26 30) (sicp-2-36/accumulate-n-v1 + 0 s))
    (assert-equal '(22 26 30) (sicp-2-36/accumulate-n-v2 + 0 s))))
