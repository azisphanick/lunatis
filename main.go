package main

import (

	// standard pkgs
	"fmt"
	"html/template"
	"log"
	"net/http"

	// non standard pkgs
	"github.com/bpdp/configo"
)

func handler(w http.ResponseWriter, req *http.Request) {

	t, err := template.ParseFiles("templates/default.tpl")

	if err != nil {
		log.Fatal(err)
	}

	type Person struct {
		Name string //exported field since it begins with a capital letter
	}

	p := Person{Name: "bpdp"}

	t.Execute(w, p)

}

func main() {

	var config = configo.ReadConfig("conf/lapmachine.toml")

	http.HandleFunc("/display", handler)
	http.Handle("/", http.FileServer(http.Dir("assets/")))
	fmt.Println("Serving http request at port " + config.Port)
	http.ListenAndServe(config.Port, nil)

}
