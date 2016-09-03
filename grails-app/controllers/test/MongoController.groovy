package test

import grails.gorm.multitenancy.Tenants

class MongoController {

    static scaffold = Mongo

    def test() {
        Tenants.withCurrent {

            // after the 2nd call this should return a value, it doesn't :(
            // unless you copy the db entry over to the default database, in which case it's found
            // -> findByXYZ methods seem to always be querying the default database
            Mongo existing = Mongo.findByName("Flo")
            log.debug("Existing: ${existing}")

            // this however returns all values for the correct tenant as expected
            def allMongos = Mongo.findAll()
            log.debug("All list size: ${allMongos.size()}")

            // write operations occur on the correct tenant -> the following works as expected
            Mongo.withTransaction {
                Mongo mongo = new Mongo(name: "Flo")
                mongo.save()
            }
        }
    }
}
