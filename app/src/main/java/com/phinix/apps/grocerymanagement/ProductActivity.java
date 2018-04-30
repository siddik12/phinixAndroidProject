package com.phinix.apps.grocerymanagement;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {

    TextView textViewName,textViewId,textViewPrice,textViewSell,textViewDate,textViewSupplier;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textViewName = findViewById(R.id.textViewName);
        textViewId = findViewById(R.id.textViewId);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewSell = findViewById(R.id.textViewSell);
        textViewDate = findViewById(R.id.textViewDate);
        textViewSupplier = findViewById(R.id.textViewSupplier);

        textViewName.setText(getIntent().getStringExtra("name"));
        textViewId.setText(getIntent().getStringExtra("id"));
        textViewPrice.setText(String.valueOf(getIntent().getIntExtra("price",0)));
        textViewSell.setText(String.valueOf(getIntent().getIntExtra("sell",0)));
        textViewDate.setText(getIntent().getStringExtra("date"));
        textViewSupplier.setText(getIntent().getStringExtra("supplier"));



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
