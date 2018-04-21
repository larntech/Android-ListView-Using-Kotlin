package com.example.larntech.listviewinkotlin

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listView = findViewById<ListView>(R.id.listview);

        val customAdptor = CustomAdptor(this)
        listView.adapter=customAdptor

        listView.setOnItemClickListener{ parent, view, position, id ->
            Toast.makeText(this, "You Clicked:"+" "+customAdptor.names[position],Toast.LENGTH_SHORT).show()
        }



    }
}

class CustomAdptor(private val context: Activity): BaseAdapter() {
    //Array of fruits names
    var names = arrayOf("Apple", "Strawberry", "Pomegranates", "Oranges", "Watermelon", "Bananas", "Kiwi", "Tomato", "Grapes")
    //Array of fruits desc
    var desc = arrayOf("Malus Domestica", "Fragaria Ananassa ", "Punica Granatum", "Citrus Sinensis", "Citrullus Vulgaris", "Musa Acuminata", "Actinidia Deliciosa", "Solanum Lycopersicum", "Vitis vinifera")

    //Array of fruits images
    var image = intArrayOf(R.drawable.apple, R.drawable.strawberry, R.drawable.pomegranates, R.drawable.oranges, R.drawable.watermelon, R.drawable.banana, R.drawable.kiwi, R.drawable.tomato, R.drawable.grapes)



    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val inflater = context.layoutInflater
        val view1 = inflater.inflate(R.layout.row_data,null)
        val fimage = view1.findViewById<ImageView>(R.id.fimageView)
        var fName = view1.findViewById<TextView>(R.id.fName)
        var fDesc = view1.findViewById<TextView>(R.id.fDesc)
        fimage.setImageResource(image[p0])
        fName.setText(names[p0])
        fDesc.setText(desc[p0])
        return view1
    }

    override fun getItem(p0: Int): Any {
        return image[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return image.size
    }

}