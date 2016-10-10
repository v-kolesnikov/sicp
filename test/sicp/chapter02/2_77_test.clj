(ns sicp.chapter02.2-77-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-77 :as math]
            [sicp.test-helper :refer :all]))

(math/install-scheme-number-package)
(math/install-rational-package)
(math/install-complex-package)

(deftest test-add
  ; Scheme number
  (assert-equal (math/make-scheme-number 5)
                (math/add (math/make-scheme-number 2)
                          (math/make-scheme-number 3)))

  ; Rational
  (assert-equal (math/make-rational 2 3)
                (math/add (math/make-rational 1 3)
                          (math/make-rational 1 3)))
  (assert-equal (math/make-rational 17 12)
                (math/add (math/make-rational 2 3)
                          (math/make-rational 3 4)))
  ; Complex
  (assert-equal (math/make-complex-from-real-imag 2 6)
                (math/add (math/make-complex-from-real-imag 1 3)
                          (math/make-complex-from-real-imag 1 3)))
  (assert-equal (math/make-complex-from-real-imag 9 7)
                (math/add (math/make-complex-from-real-imag 4 -3)
                          (math/make-complex-from-real-imag 5 10))))

(deftest test-sub
  ; Scheme number
  (assert-equal (math/make-scheme-number 5)
                (math/add (math/make-scheme-number 2)
                          (math/make-scheme-number 3)))

  ; Rational
  (assert-equal (math/make-rational 1 3)
                (math/sub (math/make-rational 2 3)
                          (math/make-rational 1 3)))
  (assert-equal (math/make-rational 1 2)
                (math/sub (math/make-rational 3 4)
                          (math/make-rational 1 4)))

  ; Complex
  (assert-equal (math/make-complex-from-real-imag 1 0)
                (math/sub (math/make-complex-from-real-imag 2 3)
                          (math/make-complex-from-real-imag 1 3)))
  (assert-equal (math/make-complex-from-real-imag 2 1)
                (math/sub (math/make-complex-from-real-imag 3 4)
                          (math/make-complex-from-real-imag 1 3))))

(deftest test-mul
  ; Scheme number
  (assert-equal (math/make-scheme-number 5)
                (math/add (math/make-scheme-number 2)
                          (math/make-scheme-number 3)))

  ; Rational
  (assert-equal (math/make-rational 2 9)
                (math/mul (math/make-rational 2 3)
                          (math/make-rational 1 3)))
  (assert-equal (math/make-rational 1 2)
                (math/mul (math/make-rational 2 3)
                          (math/make-rational 3 4)))
  ; Complex
  (assert-equal (math/make-complex-from-mag-angle 1.0 0.0)
                (math/mul (math/make-complex-from-real-imag 1 0)
                          (math/make-complex-from-real-imag 1 0)))

  (assert-equal (math/make-complex-from-mag-angle 39.20459156782531
                                                  2.4827866174723168)
                (math/mul (math/make-complex-from-real-imag 2 5)
                          (math/make-complex-from-real-imag 2 7))))

(deftest test-div
  ; Scheme number
  (assert-equal (math/make-scheme-number 5)
                (math/add (math/make-scheme-number 2)
                          (math/make-scheme-number 3)))

  ; Rational
  (assert-equal (math/make-rational 1 1)
                (math/div (math/make-rational 1 3)
                          (math/make-rational 1 3)))
  (assert-equal (math/make-rational 8 9)
                (math/div (math/make-rational 2 3)
                          (math/make-rational 3 4)))
  ; Complex
  (assert-equal (math/make-complex-from-mag-angle 2.5 0.0)
                (math/div (math/make-complex-from-real-imag 5 0)
                          (math/make-complex-from-real-imag 2 0)))

  (assert-equal (math/make-complex-from-mag-angle 1.8439088914585775
                                                  0.21866894587394198)
                (math/div (math/make-complex-from-real-imag 5 3)
                          (math/make-complex-from-real-imag 3 1))))
