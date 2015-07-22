package com.simran.groovysample;

import android.app.ListActivity
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListAdapter(new ToDoListAdapter(this, R.layout.todo_list_item))
    }

    @Override
    protected void onResume() {
        super.onResume()
        /*  With Java this would look like this:
            ArrayAdapter<ToDoItem> adapter = (ArrayAdapter<ToDoItem>) getListAdapter();
            adapter.clear()
            adapter.addAll((ToDoApplication) getApplication()).getToDos());
            adapter.notifyDataSetChanged()
        */

        listAdapter.clear()
        listAdapter.addAll(application.toDos)
        listAdapter.notifyDataSetChanged()
    }

    @Override
    boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.todo_list_menu, menu);
        return true;
    }

    @Override
    boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_add_item) {
            startActivity(new Intent(this, CreateTodoActivity.class))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}