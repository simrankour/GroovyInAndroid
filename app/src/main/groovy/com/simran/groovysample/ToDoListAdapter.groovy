package com.simran.groovysample

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

class ToDoListAdapter extends ArrayAdapter {

    ToDoListAdapter(Context context, int resource) {
        super(context, resource)
    }

    @Override
    View getView(int position, View convertView, ViewGroup parent) {
        def item = getItem(position)

        def inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
        View rowView = inflater.inflate(R.layout.todo_list_item, parent, false)

        def textViewUsername = rowView.findViewById(R.id.textview_todo_username)
        textViewUsername.text = item.username

        def textViewEmail = rowView.findViewById(R.id.textview_todo_email)
        textViewEmail.text = item.email
        return rowView
    }
}