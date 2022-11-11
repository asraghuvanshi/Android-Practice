package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText ,editText1, editText2, editText3;
    private ArrayList<Contact> contactArrayList;
    private ContactAdapter contactAdapter;
    private DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.add_button);
        editText1 = findViewById(R.id.input_id);
        editText2 = findViewById(R.id.input_name);
        editText3 = findViewById(R.id.input_number);
        contactAdapter = new ContactAdapter(contactArrayList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        db = new DatabaseHandler(this);
        db.AddContact(new Contact(1,"Krishna", "91231212"));
//        db.AddContact(new Contact(2,"Shyam", "121212111"));
//        ArrayList<Contact> contacts = db.contactArrayList();
        ContactAdapter contactAdapter = new ContactAdapter(this , db.contactArrayList());
        recyclerView.setLayoutManager(new LinearLayoutManager(this , LinearLayoutManager.VERTICAL,false));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String input_id = editText1.getText().toString();
                final String input_name = editText2.getText().toString();
                final String input_phone_number = editText3.getText().toString();

                db.AddContact(new Contact(input_id , input_name, input_phone_number));
                ArrayList<Contact> contacts = db.contactArrayList();
                Log.i("Size", ""+contacts.size());
                Toast.makeText(MainActivity.this, "Added successfully"+db, Toast.LENGTH_SHORT).show();
                recyclerView.setAdapter(contactAdapter);
            }
        });
        recyclerView.hasFixedSize();
        recyclerView.setAdapter(contactAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(db!=null){
            db.close();
        }
    }
}