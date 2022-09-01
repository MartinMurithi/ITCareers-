package com.wachiramartin.recyclerviewonclicklistener;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Description_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        ImageView imageView = findViewById(R.id.iv_careerLogo);
        TextView textView = findViewById(R.id.tv_careerTitle);
        EditText editText = findViewById(R.id.et_careerDescription);

        Intent intent = getIntent();
        if (intent != null) {
            int image = getIntent().getIntExtra("image", 0);
            String name = getIntent().getStringExtra("name");
            String about = getIntent().getStringExtra("description");

            imageView.setImageResource(image);
            textView.setText(name);
            editText.setText(about);
        }
    }
}