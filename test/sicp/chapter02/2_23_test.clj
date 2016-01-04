(ns sicp.chapter02.2-23-test
  (:require [clojure.test.check.clojure-test :as ct]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [sicp.chapter02.2-23 :as sicp-2-23]))

(ct/defspec spec-for-each
  20
  (prop/for-all [v (gen/list gen/int)]
                (let [counter (atom 0)]
                  (sicp-2-23/for-each (fn [_] (swap! counter inc)) v)
                  (= @counter
                     (count v)))))
