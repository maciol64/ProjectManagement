package com.example.maciol64.projectmanagement;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import static android.R.attr.password;

public class NewUserWizard extends AppCompatActivity
{
    EditText usernameEditText;
    EditText passwordEditText;
    TextView addUserTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_user_wizard);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // var

        usernameEditText = (EditText) findViewById(R.id.username_editText);
        passwordEditText = (EditText) findViewById(R.id.password_editText);
        addUserTextView = (TextView) findViewById(R.id.addUser_textView);

        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        createUser(username, password);
    }

    private void createUser(final String username, final String password) {

        addUserTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                User newUser = new User(username, password);
                newUser.addToDataBase();

                showAlertDialog();
            }
        });
    }

    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("User successfully added")
                .setPositiveButton("ok", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        usernameEditText.setText("");
                        passwordEditText.setText("");
                    }
                });
        builder.show();
    }
}
