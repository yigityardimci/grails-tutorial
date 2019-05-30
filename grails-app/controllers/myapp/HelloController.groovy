package myapp


import grails.rest.*
import grails.converters.*

class HelloController {
	static responseFormats = ['json', 'xml']
	
    def index() {
        Hello hello = new Hello();
        hello.setResponse("helloworld");
        respond hello
    }
}
