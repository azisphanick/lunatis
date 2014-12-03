(ns lapmachine.repl
  (:require [lapmachine.parser :as parser]))

(defn repl []
  (do
    (print "(LAP)Machine> ")
    (flush))
  (let [input (read-line)]
    (println (parser/parse input))
    (recur)))

(defn -main [& args]
  (println "Welcome to (LAP)Machine REPL")
  (println "============================")
  (flush)
  (repl))
