package com.oluwasegun.classwork_8_03_2022

import android.content.Context
import android.provider.Contacts
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(private var contacts: List<Contact>): RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val textField = itemView.findViewById<TextView>(R.id.contact_details_tv)
        val btnField = itemView.findViewById<Button>(R.id.contact_details_bn)
        val imgField = itemView.findViewById<ImageView>(R.id.contact_details_iv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.contact_details, parent, false)

        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: ContactAdapter.ViewHolder, position: Int) {
        val contact: Contact = contacts.get(position)

        val textView = viewHolder.textField
        textView.setText(contact.name)
        val button = viewHolder.btnField
        val img = viewHolder.imgField
        button.text = if(contact.isOnline) "Options" else "offline"
        button.isEnabled = contact.isOnline
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}