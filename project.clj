(defproject lapmachine "0.1.0"
  :description "A Language/Action Perspective-based engine for pragmatic interaction on the Web"
  :url "http://github.com/bpdp/lapmachine"
  :license {:name "Eclipse Public License v 1.0"
            :url "https://www.eclipse.org/org/documents/epl-v10.php"}
  :main lapmachine.repl
  :ring {:handler lapmachine.interact/handler}
  :repositories [["bigdata" "http://systap.com/maven/releases"]
                 ["nxparser" "http://nxparser.googlecode.com/svn/repository"]
                 ["sonatype" "https://oss.sonatype.org/content/repositories/releases"]
                 ["apache" "http://repository.apache.org/content/repositories/releases"]]
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [instaparse "1.3.5"]
                 [liberator "0.12.2"]
                 [compojure "1.3.0"]
                 [ring/ring-core "1.3.2"]
                 [com.bigdata/bigdata "1.4.0"]]
  :dev-dependencies
                [[ring/ring-devel "1.3.2"]])
