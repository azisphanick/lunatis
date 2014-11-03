(ns cenna.repl
  (:require [cenna.parser :as parser]))

(defn repl []
  (do
    (print "Cenna> ")
    (flush))
  (let [input (read-line)]
    (println (parser/parse input))
    (recur)))

(defn -main [& args]
  (println "Welcome to Cenna REPL")
  (println "=====================")
  (flush)
  (repl))
