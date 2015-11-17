(defproject sicp "0.1.0-SNAPSHOT"
  :description "Structure and Interpretation of Computer Programs"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-kibit "0.1.2"]
            [lein-cljfmt "0.3.0"]
            [lein-cloverage "1.0.6"]
            [jonase/eastwood "0.2.2"]]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/tools.trace "0.7.8"]
                 [cljfmt "0.3.0"]
                 [jonase/eastwood "0.2.2"]]
  :main ^:skip-aot sicp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
