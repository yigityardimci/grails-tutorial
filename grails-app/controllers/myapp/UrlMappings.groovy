package myapp

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")

        '/vehicles'(resources: 'vehicle') {
            collection {
                '/search'(controller: 'vehicle', action: 'search')
            }
        }
        '/drivers'(resources: 'drivers') {
            collection {
                '/add'(controller: 'driver', action: 'add')
            }
        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
