package myapp

class Driver {

    String firstName;
    String lastName;

    static constraints = {
    }
    static hasMany = [vehicles:Vehicle]
}
