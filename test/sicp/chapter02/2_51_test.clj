(ns sicp.chapter02.2-51-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-47 :refer [make-frame]]
            [sicp.chapter02.2-51 :as sicp-2-51]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-below
  (let [painter (sicp-2-51/below identity identity)]
    (assert-equal [(make-frame [0.0 0.0] [1.0 0.0] [0.0 0.5])
                   (make-frame [0.0 0.5] [1.0 0.0] [0.0 0.5])]
                  (painter (make-frame [0.0 0.0] [1.0 0.0] [0.0 1.0])))
    (assert-equal [(make-frame [2.0 2.0] [1.0 0.0] [0.0 0.5])
                   (make-frame [2.0 2.5] [1.0 0.0] [0.0 0.5])]
                  (painter (make-frame [2.0 2.0] [1.0 0.0] [0.0 1.0])))))

(deftest test-below-rotate
  (let [painter (sicp-2-51/below-rotate identity identity)]
    (assert-equal [(make-frame [0.0 0.0] [1.0 0.0] [0.0 0.5])
                   (make-frame [0.0 0.5] [1.0 0.0] [0.0 0.5])]
                  (painter (make-frame [0.0 0.0] [1.0 0.0] [0.0 1.0])))
    (assert-equal [(make-frame [2.0 2.0] [1.0 0.0] [0.0 0.5])
                   (make-frame [2.0 2.5] [1.0 0.0] [0.0 0.5])]
                  (painter (make-frame [2.0 2.0] [1.0 0.0] [0.0 1.0])))))
