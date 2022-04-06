(defproject ashikaweb2 "0.1.1-SNAPSHOT"

  :description "A simple app for conducting surveys"
  :url "http://www.ashikasoft.com"

  :dependencies [[ashikasoft/jdict "1.0.2"]
                 [ashikasoft/webstack "0.1.7"]
                 [clojure.java-time "0.3.3"]
                 [org.clojure/clojure "1.11.1"]]

  :min-lein-version "2.0.0"
  
  :source-paths ["src/clj"]
  :test-paths ["test/clj"]
  :resource-paths ["resources"]
  :target-path "target/%s/"
  :main ^:skip-aot ashikaweb2.core

  :plugins [[lein-immutant "2.1.0"]]
  :clean-targets ^{:protect false}
  [:target-path [:builds :app :compiler :output-dir] [:builds :app :compiler :output-to]]

  :profiles
  {:uberjar {:omit-source true
             :prep-tasks ["compile"]
             :aot :all
             :uberjar-name "ashikaweb2.jar"
             :source-paths ["env/prod/clj"]
             :resource-paths ["env/prod/resources"]}

   :dev           [:project/dev :profiles/dev]
   :test          [:project/dev :project/test :profiles/test]

   :project/dev  {:jvm-opts ["-Dconf=dev-config.edn"]
                  :dependencies [[binaryage/devtools "1.0.5"]
                                 [doo "0.1.11"]
                                 [expound "0.9.0"]
                                 [pjstadig/humane-test-output "0.11.0"]
                                 [prone "2021-04-23"]
                                 [ring/ring-devel "1.9.5"]
                                 [ring/ring-mock "0.4.0"]]
                  :plugins      [[com.jakemccrary/lein-test-refresh "0.23.0"]
                                 [lein-doo "0.1.11"]]
                  
                  :doo {:build "test"}
                  :source-paths ["env/dev/clj"]
                  :resource-paths ["env/dev/resources"]
                  :repl-options {:init-ns user}
                  :injections [(require 'pjstadig.humane-test-output)
                               (pjstadig.humane-test-output/activate!)]}
   :project/test {:jvm-opts ["-Dconf=test-config.edn"]
                  :resource-paths ["env/test/resources"]
                  }
                  
                  
   :profiles/dev {}
   :profiles/test {}})
