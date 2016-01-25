(ns sicp.chapter02.2-33-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-33 :as sicp-2-33]))

(ct/defspec spec-map
  20
  (prop/for-all [v (gen/list gen/int)]
                (= (map inc v)
                   (sicp-2-33/map inc v))))

(ct/defspec spec-append
  20
  (prop/for-all [v1 (gen/list gen/int)
                 v2 (gen/list gen/int)]
                (= (concat v1 v2)
                   (sicp-2-33/append v1 v2))))

(ct/defspec spec-length
  20
  (prop/for-all [v (gen/list gen/int)]
                (= (count v)
                   (sicp-2-33/length v))))
