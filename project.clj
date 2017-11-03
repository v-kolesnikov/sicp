(defproject sicp "0.1.0-SNAPSHOT"
  :description "Structure and Interpretation of Computer Programs"
  :url "http://example.com/FIXME"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/test.check "0.9.0"]
                 [rhizome "0.2.7"]
                 [quil "2.4.0"]]
  :main ^:skip-aot sicp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev [:project/dev :profiles/dev]
             :project/dev {:dependencies
                           [[cljfmt "0.5.7"
                             slamhound "1.5.5"]]
                           :generators [[sicp-generator "0.1.2"]]
                           :plugins
                           [[lein-kibit "0.1.2"]
                            [lein-cljfmt "0.5.3"]
                            [lein-gen "0.2.1"]
                            [jonase/eastwood "0.2.5"]]
                           :aliases {"slamhound" ["run" "-m" "slam.hound"]}
                           :eastwood {:exclude-linters
                                      [:constant-test,
                                       :def-in-def]
                                      :exclude-namespaces
                                      [sicp.extra.graph.viz
                                       sicp.extra.graph.render-all]}}
             :profiles/dev {}
             :profiles/test {}})
