package com.wachiramartin.recyclerviewonclicklistener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    //We'll set this array list to the adapter.
    ArrayList<Career> careerList = new ArrayList<>();

    public static final int resultCode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.hasFixedSize();

        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        fillCareerList();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(this, careerList, MainActivity.this);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void fillCareerList(){
        String[] careerTitle = getResources().getStringArray(R.array.career_titles);
        String[] aboutCareer = getResources().getStringArray(R.array.career_descriptions);
        int[] images = {R.drawable.cyber_security, R.drawable.iot, R.drawable.mobile_computing,R.drawable.ai, R.drawable.ml, R.drawable.deep_learning,
                R.drawable.data_engineering, R.drawable.software_engineering, R.drawable.web_development, R.drawable.cloud,
                R.drawable.robotics_engineering, R.drawable.network_eng};

        for(int i = 0; i < careerTitle.length; i++){
           careerList.add(new Career(careerTitle[i], aboutCareer[i], images[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, Description_Activity.class);

        intent.putExtra("name", careerList.get(position).getCareerName());
        intent.putExtra("description", careerList.get(position).getAboutCareer());
        intent.putExtra("image", careerList.get(position).getCareerImages());

        startActivity(intent);
    }
}