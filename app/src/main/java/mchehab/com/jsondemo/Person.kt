package mchehab.com.jsondemo

import org.json.JSONObject

/**
 * Created by muhammadchehab on 10/26/17.
 */

data class Person(var firstName: String, var lastName: String, var age: Int){
    constructor(jsonObject: JSONObject) :
        this(jsonObject.getString(JSONConstants.PERSON_FIRST_NAME),
                jsonObject.getString(JSONConstants.PERSON_LAST_NAME),
                jsonObject.getInt(JSONConstants.PERSON_AGE))
    override fun toString() : String{
        return "$firstName $lastName is $age years old"
    }
}