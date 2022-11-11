package com.example.sqlitedatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private Context context;
    private ArrayList<Contact> contactArrayList;
    private ArrayList<Contact> mcontactArrayList;
    private DatabaseHandler databaseHandler;
    ContactAdapter(Context context, ArrayList<Contact> contactArrayList){
        this.context = context;
        this.contactArrayList = contactArrayList;
        this.mcontactArrayList = contactArrayList;
        databaseHandler = new DatabaseHandler(context);
    }

    public ContactAdapter(ArrayList<Contact> contactArrayList) {
        this.contactArrayList = contactArrayList;
    }

    @NonNull
    @Override
    public ContactAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.add_contacts ,parent,false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactAdapter.ContactViewHolder holder, int position) {
        final Contact contact = contactArrayList.get(position);
        holder.editText1.setText(String.valueOf(contact.getId()));
        holder.editText2.setText(String.valueOf(contact.getName()));
        holder.editText3.setText(String.valueOf(contact.getPhone_number()));
    }

    @Override
    public int getItemCount() {
        return contactArrayList.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView editText1, editText2, editText3;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            editText1 =(TextView) itemView.findViewById(R.id.enter_contact_id);
            editText2 =(TextView) itemView.findViewById(R.id.enter_contact_name);
            editText3 = (TextView) itemView.findViewById(R.id.enter_phone_number);
        }
    }
}
