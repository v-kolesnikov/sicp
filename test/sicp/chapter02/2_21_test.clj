(ns sicp.chapter02.2-21-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-21 :as sicp-2-21]))

(ct/defspec spec-square-list
  20
  (prop/for-all [v (gen/not-empty (gen/list gen/int))]
                (= (sicp-2-21/square-list-v1 v)
                   (sicp-2-21/square-list-v2 v)
                   (sicp-2-21/square-list-v3 v))))
