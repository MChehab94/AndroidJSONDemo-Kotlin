package mchehab.com.jsondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        val listPersons = createListFromFile()
        val arrayAdapter = ArrayAdapter<Person>(this, android.R.layout.simple_list_item_1,
                listPersons)
        listView.adapter = arrayAdapter
    }

    private fun createListFromFile() : List<Person>{
        val list = mutableListOf<Person>()
        val json = assets.open("persons.txt")
                .bufferedReader()
                .readText()

        val jsonArray = JSONArray(json)
        for (i in 0..(jsonArray.length() - 1)){
            list.add(Person(jsonArray.getJSONObject(i)))
        }

        return list
    }
}