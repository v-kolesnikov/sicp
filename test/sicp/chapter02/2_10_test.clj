(ns sicp.chapter02.2-10-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-07 :as sicp-2-07]
            [sicp.chapter02.2-10 :as sicp-2-10]
            [sicp.common :as sicp]))

(ct/defspec spec-div-interval
  100
  (prop/for-all [v (gen/tuple sicp-2-07/gen-interval
                              sicp-2-10/gen-zero-contains-interval)]
                (sicp/error? (apply sicp-2-10/div-interval v))))
