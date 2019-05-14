package myapp


import grails.rest.*
import grails.converters.*

class VehicleController extends RestfulController {
    static responseFormats = ['json', 'xml']
    VehicleController() {
        super(Vehicle)
    }

    def search(String q,Integer max){
        println("String parameter is $q" );
        if(q) {
            def query = Vehicle.where {
                name == q
            } // Define query
            respond query.list(max: Math.min( max ?: 10, 100))
        }else{
            respond([])
        }
    }
}
