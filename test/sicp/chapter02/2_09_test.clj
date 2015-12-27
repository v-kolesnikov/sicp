(ns sicp.chapter02.2-09-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-07 :as sicp-2-07]
            [sicp.chapter02.2-09 :as sicp-2-09]))

(ct/defspec spec-solution
  100
  (prop/for-all [v (gen/tuple sicp-2-07/gen-interval
                              sicp-2-07/gen-interval)]
                (apply sicp-2-09/solution v)))
