package main

import (

	// standard pkgs
	"fmt"
	"html/template"
	"log"
	"net/http"

	// non standard pkgs
	"github.com/bpdp/configo"
	//	"github.com/gorilla/mux"
)

type Config struct {
	Title     string
	Port      string
	Staticdir string
	Routes    struct {
		Home    HandlerName
		Display HandlerName
	}
}

type HandlerName struct {
	Handler string
}

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

	var cnf Config

	if err := configo.ReadConfig("conf/lapmachine.toml", &cnf); err != nil {
		fmt.Println("Config Load Error: %g", err)
	}

	http.HandleFunc("/display", handler)
	http.Handle("/", http.FileServer(http.Dir(cnf.Staticdir)))
	fmt.Println(cnf.Title + " serving http request at port " + cnf.Port)
	fmt.Println("Home: " + cnf.Routes.Home.Handler)
	fmt.Println("Display: " + cnf.Routes.Display.Handler)
	http.ListenAndServe(cnf.Port, nil)

}
