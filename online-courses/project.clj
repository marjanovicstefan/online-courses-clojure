(defproject online-courses "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [ring/ring-jetty-adapter "1.9.1"]
                 [metosin/compojure-api "2.0.0-alpha31"]
                 [ring-cors "0.1.13"]
                 [toucan "1.16.0"]
                 [mysql/mysql-connector-java "8.0.28"]]
  :main ^:skip-aot online-courses.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
