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
  (println "_________                              ")
  (println "\\_   ___ \\  ____   ____   ____ _____   ")
  (println "/    \\  \\/_/ __ \\ /    \\ /    \\\\__  \\")
  (println "\\     \\___\\  ___/|   |  \\   |  \\/ __ \\_")
  (println " \\______  /\\___  >___|  /___|  (____  / ")
  (println "        \\/     \\/     \\/     \\/     \\/")
  (println "")
  (println "Welcome to Cenna REPL")
  (println "=====================")
  (flush)
  (repl))
