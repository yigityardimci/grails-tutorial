package hibernate.example

import grails.testing.web.controllers.ControllerUnitTest
import myapp.Make
import myapp.Model
import myapp.Vehicle
import org.grails.testing.GrailsUnitTest
import spock.lang.Specification

@SuppressWarnings('MethodName')
class VehicleControllerSpec extends Specification implements ControllerUnitTest<Vehicle>{

    static doWithSpring = {
        jsonSmartViewResolver(JsonViewResolver)
    }

    def setup() {
        def nissan = new Make(name: 'qrt').save()
        def ford = new Make(name: 'ert').save()

        def titan = new Model(name: 'qwere', make: nissan).save()
        def leaf = new Model(name: 'sdsd', make: nissan).save()
        def windstar = new Model(name: 'dfdfd', make: ford).save()

        Vehicle.saveAll(
        new Vehicle(name: 'Pickups',  make: nissan, model: titan, year: 2012),
        new Vehicle(name: 'Economyq', make: nissan, model: leaf, year: 2014),
        new Vehicle(name: 'Minivane', make: ford, model: windstar, year: 1990)
        )
    }

    def cleanup() {
        Vehicle.deleteAll()
    }

    void "test something"() {
        expect:"fix me"
        true == false
    }
    void 'test the search action finds results'() {
        when: 'A query is executed that finds results'
        controller.search('Pickup', 10)

        then: 'The response is correct'
        println(response.json)
        response.json.size() == 1
        response.json[0].name == 'Pickup'
    }
}