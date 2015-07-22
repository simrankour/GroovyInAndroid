package com.simran.groovysample

import android.app.Activity


class CreateTodoActivity extends Activity {

    @Override
    protected void onStart() {
        super.onStart()
        setContentView(R.layout.activity_create_todo)

        def button = findViewById(R.id.button_add_new_todo)

        // use groovy multiple assignment to map view ids to variables
        def (username, email) = [R.id.edittext_new_username, R.id.edittext_new_email].collect(this.&findViewById)

        /*
           // in Java adding the OnClickListener
           Button button = (Button) findViewById(R.id.button_add_new_todo);
           button.setOnClickListener(new View.OnClickListener() {
               @Override
               void onClick(View v) {
                   MyApplication app = (MyApplication) getApplication();
                   app.getToDos(new TodoItem(username.getText(), email.getText()));
               }
           })
       */

        button.onClickListener = {
            application.toDos << new ToDoItem(username.text.toString(), email.text.toString())
            finish()
        }
    }
}