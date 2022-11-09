package com.example.recycler;

import static com.example.recycler.R.drawable.april;
import static com.example.recycler.R.drawable.august;
import static com.example.recycler.R.drawable.december;
import static com.example.recycler.R.drawable.february;
import static com.example.recycler.R.drawable.january;
import static com.example.recycler.R.drawable.july;
import static com.example.recycler.R.drawable.june;
import static com.example.recycler.R.drawable.march;
import static com.example.recycler.R.drawable.may;
import static com.example.recycler.R.drawable.november;
import static com.example.recycler.R.drawable.october;
import static com.example.recycler.R.drawable.september;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerView.LayoutManager layoutManager;
    List<MyListData> monthlist ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initRecycleView();
    }

    private void initData() {
        monthlist = new ArrayList<>();
        monthlist.add(new MyListData("January" ,121 , january));
        monthlist.add(new MyListData("February" ,122 , february));
        monthlist.add(new MyListData("March" ,123 , march));
        monthlist.add(new MyListData("April" ,123 , april));
        monthlist.add(new MyListData("May" ,123 ,may));
        monthlist.add(new MyListData("June" ,123 ,june));
        monthlist.add(new MyListData("July" ,123 ,july ));
        monthlist.add(new MyListData("August" ,123 , august));
        monthlist.add(new MyListData("September" ,123 , september));
        monthlist.add(new MyListData("October" ,123 , october));
        monthlist.add(new MyListData("November" ,123 ,november));
        monthlist.add(new MyListData("December" ,123 , december));


    }

    private void initRecycleView() {
        recyclerView = findViewById(R.id.recycler_view);
        layoutManager= new LinearLayoutManager(this);
//        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        Adapter adapter = new Adapter(monthlist);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}