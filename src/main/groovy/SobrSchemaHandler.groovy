

import org.grails.orm.hibernate.jdbc.schema.DefaultSchemaHandler

/**
 * Created with IntelliJ IDEA.
 * User: Domenic Benz
 * Date: 31/08/16
 * Time: 17:08
 * To change this template use File | Settings | File Templates.
 */
class SobrSchemaHandler extends DefaultSchemaHandler {

    SobrSchemaHandler() {
        super("USE %s;", "CREATE DATABASE `%s` DEFAULT CHARACTER SET = `utf8`;", "acquiappv2")
    }

}
