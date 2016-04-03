(ns sicp.chapter02.2-65-test
  (:require [clojure.test :refer [deftest]]
            [sicp.chapter02.2-64 :as sicp-2-64]
            [sicp.chapter02.2-65 :as sicp-2-65]
            [sicp.test-helper :refer [assert-equal]]))

(deftest test-union-set
  (assert-equal '() (sicp-2-65/union-set (sicp-2-64/list->tree '())
                                         (sicp-2-64/list->tree '())))

  (assert-equal '(3 (1 () (2 () ())) (4 () (5 () ())))
                (sicp-2-65/union-set (sicp-2-64/list->tree '(1 2 3 4 5))
                                     (sicp-2-64/list->tree '(1 2 3 4 5))))

  (assert-equal '(3 (1 (0 () ()) (2 () ())) (5 (4 () ()) (6 () (7 () ()))))
                (sicp-2-65/union-set (sicp-2-64/list->tree '(1 3 5 7))
                                     (sicp-2-64/list->tree '(0 2 4 6))))

  (assert-equal '(0 (-3 (-4 () ()) (-2 () (-1 () ()))) (3 (1 () (2 () ())) (4 () (5 () ()))))
                (sicp-2-65/union-set (sicp-2-64/list->tree '(0 1 2 3 4 5))
                                     (sicp-2-64/list->tree '(-4 -3 -2 -1)))))

(deftest test-intersection-set
  (assert-equal '()
                (sicp-2-65/intersection-set (sicp-2-64/list->tree '())
                                            (sicp-2-64/list->tree '())))

  (assert-equal '(3 (1 () ()) (4 () ()))
                (sicp-2-65/intersection-set (sicp-2-64/list->tree '(1 3 4 5))
                                            (sicp-2-64/list->tree '(1 3 4)))))
