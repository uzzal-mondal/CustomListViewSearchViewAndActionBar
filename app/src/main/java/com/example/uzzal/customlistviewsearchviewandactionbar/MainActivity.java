package com.example.uzzal.customlistviewsearchviewandactionbar;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    // design row.xml of list view.
    // adding menu to search view in action.
    //model class to add..
    //add adapter class..
    // add some images in add to drawable folder
    //Run project and test the list view and search view.


    ListView listView;
    ListViewAdapter adapter;


    //row.xml
    String[] title;
    String[] description;
    int[] icon;


    ArrayList<Model> arrayList = new ArrayList<Model>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Items List");

        //title des icon find
        title = new String[]{"Kotlin", "Java Script", "Python", "Java", "C++", "C"};
        description = new String[]{"KT solve", "JS solve", "PY solve", "Java solve", "C++ solve ", "C solve"};
        icon = new int[]{R.drawable.kotlin, R.drawable.js, R.drawable.python, R.drawable.java, R.drawable.cplus, R.drawable.c};


        listView = findViewById(R.id.listView_id);

        for (int i = 0; i < title.length; i++) {
            Model model = new Model(title[i], description[i], icon[i]);
            //bind all strings in an array
            arrayList.add(model);
        }

        //pass results to listViewAdapter class
        adapter = new ListViewAdapter(this, arrayList);

        //bind the adapter to the listview
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem myActionMenuItem = menu.findItem(R.id.action_search);
        android.support.v7.widget.SearchView searchView = (android.support.v7.widget.SearchView) myActionMenuItem.getActionView();
        searchView.setOnQueryTextListener(new android.support.v7.widget.SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                if (TextUtils.isEmpty(s)) {

                    adapter.filter("");
                    listView.clearTextFilter();
                } else {

                    adapter.filter(s);
                }
                return true;
            }
        });


        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {

            //do your functionality here
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

}