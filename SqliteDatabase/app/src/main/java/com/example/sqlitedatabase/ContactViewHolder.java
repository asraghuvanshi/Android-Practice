package com.example.sqlitedatabase;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ContactViewHolder extends RecyclerView.ViewHolder {
    EditText editText1, editText2, editText3;

    public ContactViewHolder(@NonNull View itemView) {
        super(itemView);
        editText1 = itemView.findViewById(R.id.enter_contact_id);
        editText2 = itemView.findViewById(R.id.enter_contact_name);
        editText3 = itemView.findViewById(R.id.enter_phone_number);
    }
}
