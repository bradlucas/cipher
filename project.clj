(defproject cipher "1.0.0"
  :description "AI Class cipher problem"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot cipher.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

