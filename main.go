package main

import (

	// standard pkgs
	"fmt"
	"net/http"

	// non standard pkgs
	"github.com/bpdp/configo"

	// Application specific
	// routes
	"app/routes"
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
	Handler interface{}
}

func main() {

	var cnf Config

	if err := configo.ReadConfig("conf/lapmachine.toml", &cnf); err != nil {
		fmt.Println("Config Load Error: %g", err)
	}

	// routes
	routes.ExposeRoutes()
	//

	fmt.Println(cnf.Title + " serving http request at port " + cnf.Port)
	fmt.Println(cnf.Routes.Home.Handler)
	fmt.Println(cnf.Routes.Display.Handler)

	http.ListenAndServe(cnf.Port, nil)

}
