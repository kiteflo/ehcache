package test

import grails.gorm.MultiTenant

class Mongo implements MultiTenant<Mongo> {

    String name

    static constraints = {
    }
}
