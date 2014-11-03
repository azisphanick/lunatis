;; in the meantime, it was blatantly stolen from:
;; https://gist.github.com/pooster/6221672

(ns cenna.parser
 (:require [instaparse.core :as insta]))

(def parser
  (insta/parser
        "sexp = lparen operation rparen
         <lparen> = <'('>
         <rparen> = <')'>
         operation = operator + args
         operator = '+' | '-' | '*' | '/'
         args = snumber+ ssexp* 
         <ssexp>   = space sexp
         <snumber> = space number
         <space>  = <#'[ ]*'> 
         number = #'[0-9]+'
        "))

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
