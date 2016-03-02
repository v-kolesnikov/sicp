(defproject sicp "0.1.0-SNAPSHOT"
  :description "Structure and Interpretation of Computer Programs"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :plugins [[lein-kibit "0.1.2"]
            [lein-cljfmt "0.3.0"]
            [jonase/eastwood "0.2.2"]]
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/test.check "0.9.0"]
                 [quil "2.3.0"]]
  :main ^:skip-aot sicp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
