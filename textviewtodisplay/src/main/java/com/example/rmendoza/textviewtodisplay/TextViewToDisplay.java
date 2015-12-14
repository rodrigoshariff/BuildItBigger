package com.example.rmendoza.textviewtodisplay;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TextViewToDisplay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view_to_display);

        TextView textDisplay = (TextView) this.findViewById(R.id.textDisplay);

        Intent intent = getIntent();

        if (!(intent == null ))//&& intent.hasExtra(Intent.EXTRA_TEXT)) {
        {
            String EntireJoke = intent.getStringExtra("EntireJoke");
            textDisplay.setText(EntireJoke);

        }
    }
}
