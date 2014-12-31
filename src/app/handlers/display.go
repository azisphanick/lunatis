package handlers

import (
	"html/template"
	"log"
	"net/http"
)

func DisplayHandler(w http.ResponseWriter, req *http.Request) {

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
