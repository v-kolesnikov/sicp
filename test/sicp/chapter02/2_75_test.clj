(ns sicp.chapter02.2-75-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-75 :as sicp-2-75]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-make-from-real-imag
  (let [num (sicp-2-75/make-from-real-imag 2 5)]
    (assert-equal 2 (sicp-2-75/real-part num))
    (assert-equal 5 (sicp-2-75/imag-part num))
    (assert-equal 5.3851648071345040 (sicp-2-75/magnitude num))
    (assert-equal 1.1902899496825317 (sicp-2-75/angle num))))

(deftest test-make-from-mag-ang
  (let [num (sicp-2-75/make-from-mag-ang 5.38 1.19)]
    (assert-equal 2.0 (Math/ceil (sicp-2-75/real-part num)))
    (assert-equal 5.0 (Math/ceil (sicp-2-75/imag-part num)))
    (assert-equal 5.38 (sicp-2-75/magnitude num))
    (assert-equal 1.19 (sicp-2-75/angle num))))
