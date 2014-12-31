package routes

import (
	"app/handlers"
	"github.com/justinas/alice"
	"lapmachine/middlewares"
	"net/http"
)

func ExposeRoutes() {

	commonHandlers := alice.New(middlewares.LoggingHandler, middlewares.RecoverHandler)

	http.Handle("/display", commonHandlers.ThenFunc(handlers.DisplayHandler))
	http.Handle("/", http.FileServer(http.Dir("assets/")))

}
