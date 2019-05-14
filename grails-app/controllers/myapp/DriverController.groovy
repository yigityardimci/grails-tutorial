package myapp


import grails.rest.*
import grails.converters.*

class DriverController extends RestfulController {
    static responseFormats = ['json', 'xml']
    DriverController() {
        super(Driver)
    }
    def add(int driver_id,String vehicle_name){
        def driver = Driver.get(1);
        def vehicle_list = Vehicle.where{
            name == "Pickup"
        }
        driver.vehicles.addAll(vehicle_list.list());
        respond driver;
    }
}
