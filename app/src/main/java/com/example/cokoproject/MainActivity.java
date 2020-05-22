package com.example.cokoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<User> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button likesButton = (Button)findViewById(R.id.button_heart);

        likesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, LikesListActivity.class);
                startActivity(intent);
            }
        });

//        recyclerView = findViewById(R.id.recy);
//        recyclerView.setHasFixedSize(true);
//        layoutManager = new LinearLayoutManager(this);
//        recyclerView.setLayoutManager(layoutManager);
//        arrayList = new ArrayList<>();
//
//        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference("User");  // dp 테이블 연결
//        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                // 파이어베이스의 데이터를 받아오는 곳
//                arrayList.clear();
//                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    User user = snapshot.getValue(User.class);
//                    arrayList.add(user);
//                }
//                adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.e("MainActivity", String.valueOf(databaseError.toException()));
//            }
//        });
//
//
//        adapter = new CustomAdapter(arrayList, this);
//        recyclerView.setAdapter(adapter);
    }
}
