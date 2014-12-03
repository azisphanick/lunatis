;; in the meantime, it was blatantly stolen from:
;; https://gist.github.com/pooster/6221672

(ns lapmachine.parser
 (:require [instaparse.core :as insta]))

(def parser
  (insta/parser
    (clojure.java.io/resource "lapmachine-grammar.bnf")))

(defn choose-operator [op]
  (case op
    "+" +
    "-" -
    "*" *
    "/" /))

(def transform-options
  {:number read-string
   :args vector
   :operator choose-operator
   :operation apply
   :sexp identity})

(defn parse [input]
  (->> (parser input) (insta/transform transform-options)))
