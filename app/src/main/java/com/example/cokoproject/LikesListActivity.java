package com.example.cokoproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class LikesListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<LikesInfo> arrayList;
    private FirebaseDatabase database;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_likes_list);


        recyclerView = findViewById(R.id.lists);
//        recyclerView.setHasFixedSize(false);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        arrayList = new ArrayList<>();

        database = FirebaseDatabase.getInstance();
//        databaseReference = database.getReference("User");  // dp 테이블 연결
        databaseReference = database.getReference("Likes");
        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // 파이어베이스의 데이터를 받아오는 곳
                arrayList.clear();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
//                    User user = snapshot.getValue(User.class);
//                    arrayList.add(user);
                    LikesInfo info = snapshot.getValue(LikesInfo.class);
                    arrayList.add(info);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
//                Log.e("MainActivity", String.valueOf(databaseError.toException()));
                Log.e("LikesListActivity", String.valueOf(databaseError.toException()));
            }
        });


//        adapter = new CustomAdapter(arrayList, this);
        adapter = new LikesAdapter(arrayList, this);
        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
    }


}
