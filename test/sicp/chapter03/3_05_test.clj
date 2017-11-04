(ns sicp.chapter03.3-05-test
  (:require [clojure.test :refer :all]
            [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter03.3-05 :refer :all]))

(defn approximately-equal
  [x y accuracy]
  (< (Math/abs (- x y))
     accuracy))

(deftest test-estimate-integral
  (is (estimate-integral (circle 5 7 3) 2 4 8 10 10000))
  (is (estimate-pi 10000)))

(ct/defspec spec-estimate-integral
  10
  (prop/for-all [integral (gen/fmap #(estimate-integral (circle 5 7 3) 2 4 8 10 %)
                                    (gen/return 1000))]
                (approximately-equal integral (* (Math/PI) 9) 1.3)))

(ct/defspec spec-estimate-pi
  10
  (prop/for-all [pi (gen/fmap estimate-pi (gen/return 1000))]
                (approximately-equal pi Math/PI 0.2)))
