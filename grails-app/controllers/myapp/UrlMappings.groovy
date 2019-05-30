package myapp

class UrlMappings {

    static mappings = {
        delete "/$controller/$id(.$format)?"(action:"delete")
        get "/$controller(.$format)?"(action:"index")
        get "/$controller/$id(.$format)?"(action:"show")
        post "/$controller(.$format)?"(action:"save")
        put "/$controller/$id(.$format)?"(action:"update")
        patch "/$controller/$id(.$format)?"(action:"patch")


        '/vehicles'(resources: 'vehicle'){
            collection {
                '/search'( controller: 'vehicle' , action: 'search')
            }
        }

        group('/api'){
            '/hello'(controller:'hello',action:'index')
            '/driver'(resources:'driver'){
                collection {
                    '/add'( controller: 'driver' , action: 'add')
                }
            }
            '/vehicles'(resources: 'vehicle'){
                collection {
                    '/search'( controller: 'vehicle' , action: 'search')
                }
            }


        }

        "/"(controller: 'application', action:'index')
        "500"(view: '/error')
        "404"(view: '/notFound')

    }
}
