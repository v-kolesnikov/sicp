(ns sicp.chapter02.2-22-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-22 :as sicp-2-22]
            [sicp.common :as sicp]))

(ct/defspec spec-square-list
  20
  (prop/for-all [v (gen/not-empty (gen/list gen/int))]
                (= (map sicp/square v)
                   (sicp-2-22/square-list-v1 v)
                   (sicp-2-22/square-list-v2 v))))
