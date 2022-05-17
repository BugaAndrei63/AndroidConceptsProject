package com.bugaandrei.proiect

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Contact : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        //Adding the view and making it lisen for clicks
        var openShareSheet = requireView().findViewById<Button>(R.id.showShareSheet)
        openShareSheet.setOnClickListener()
        {
            shareSheet()
        }

    }

    fun shareSheet()
    {
        //Using intents to share a message
        var message = "Buna! \n\n"+
                "Aplicatia a fost creata de Buga Andrei\n"
        var intent = Intent()
        intent.type = "text/plain"
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT,message)
        startActivity(intent)
    }

}