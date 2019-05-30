package myapp


import grails.rest.*
import grails.converters.*
import groovy.transform.CompileStatic

@CompileStatic
class DriverController extends RestfulController {
    static responseFormats = ['json', 'xml']
    DriverController() {
        super(Driver)
    }

    def add(){
        def driver = Driver.get(1)
        def vehicle_list = Vehicle.where{
            name == "Pickup"
        }
        driver.vehicles.addAll(vehicle_list.list())
        respond driver
    }
}
