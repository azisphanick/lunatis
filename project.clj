(defproject cenna "0.1.0"
  :description "An engine for pragmatic interaction"
  :url "http://github.com/bpdp/cenna"
  :license {:name "Eclipse Public License v 1.0"
            :url "https://www.eclipse.org/org/documents/epl-v10.php"}
  :main cenna.repl
  :ring {:handler cenna.interact/handler}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [instaparse "1.3.4"]
                 [liberator "0.12.2"]
                 [compojure "1.2.2"]
                 [ring/ring-core "1.3.2"]])
