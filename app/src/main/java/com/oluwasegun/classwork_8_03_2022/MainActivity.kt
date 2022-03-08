package com.oluwasegun.classwork_8_03_2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Contacts
import android.provider.ContactsContract
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var contacts : ArrayList<Contact>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var recyclerVie = findViewById<View>(R.id.activity_main_recycler_view) as RecyclerView

        contacts = Contact.createContactsList(60)

        val adapter = ContactAdapter(contacts)

        recyclerVie.adapter = adapter

        recyclerVie.layoutManager = LinearLayoutManager(this
        )
    }
}