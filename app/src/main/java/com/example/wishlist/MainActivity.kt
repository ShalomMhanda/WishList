package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    //lateinit var items: MutableList<WishList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val wishListRv = findViewById<RecyclerView>(R.id.wishListRv)

        val submitButton = findViewById<Button>(R.id.button)

        val emptyWishList: MutableList<WishList> = mutableListOf()

        // Create adapter passing in the list of emails
        val adapter = WishListAdapter(emptyWishList)
        // Attach the adapter to the RecyclerView to populate items
        wishListRv.adapter = adapter
        // Set layout manager to position the items
        wishListRv.layoutManager = LinearLayoutManager(this)




        submitButton.setOnClickListener {
            val itemName = findViewById<TextInputEditText>(R.id.itemNameTv)
            val itemPrice = findViewById<TextInputEditText>(R.id.priceTv)
            val itemUrl = findViewById<TextInputEditText>(R.id.urlTv)



            var storeItem: WishList = WishList(itemName.text.toString(), itemPrice.text.toString().toDouble(), itemUrl.text.toString())
            emptyWishList.add(storeItem)
            adapter.notifyItemInserted(emptyWishList.size - 1)

        }
    }
}