package com.bugaandrei.proiect

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


class Home : Fragment() {


    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerAdapter

    private var titles = mutableListOf<String>()
    private var titlesShow = mutableListOf<String>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        titles.add("Andrei")
        titles.add("Claudiu")
        titles.add("Catalin")
        titles.add("Andreea")
        titles.add("Diana")
        titles.add("Mirela")
        titles.add("Oana")
        titles.add("Ovidiu")
        titles.add("Zabrac")

        titlesShow.addAll(titles)
        //Instantiating recycler view
        recyclerView = requireView().findViewById(R.id.recyclerView)
        recyclerAdapter = RecyclerAdapter(titlesShow)

        recyclerView.adapter = recyclerAdapter

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //Search menu code
        inflater.inflate(R.menu.search_menu, menu)

        var item: MenuItem = menu!!.findItem(R.id.search_action)

        if(item != null)
        {
            var searchView = item.actionView as SearchView
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener
                {
                    override fun onQueryTextSubmit(query: String?): Boolean
                    {
                        return true
                    }

                override fun onQueryTextChange(newText: String?): Boolean
                {

                    if(newText!!.isNotEmpty())
                    {
                        titlesShow.clear()
                        var search = newText.lowercase(Locale.getDefault())

                        for(i in titles)
                        {
                            if(i.lowercase(Locale.getDefault()).contains(search))
                            {
                                titlesShow.add(i)
                            }
                            recyclerView.adapter!!.notifyDataSetChanged()
                        }
                    }else
                    {
                        titlesShow.clear()
                        titlesShow.addAll(titles)
                        recyclerView.adapter!!.notifyDataSetChanged()
                    }
                    return true
                }

            })
        }

        super.onCreateOptionsMenu(menu, inflater)
    }


}