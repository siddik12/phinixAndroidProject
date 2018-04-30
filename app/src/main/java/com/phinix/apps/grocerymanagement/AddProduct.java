package com.phinix.apps.grocerymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
    EditText productNameET, productIdET, puchasePriceET, sellingPriceET, puchaseDateET, supplierNameET;
    String productName;
    String productId;
    int purchasePrice;
    int sellingPrice;
    String puchaseDate;
    String supplierName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        productNameET = findViewById(R.id.productNameET);
        productIdET = findViewById(R.id.productIdET);
        puchasePriceET = findViewById(R.id.purchasePriceET);
        sellingPriceET = findViewById(R.id.sellingPriceET);
        puchaseDateET = findViewById(R.id.purchaseDateET);
        supplierNameET = findViewById(R.id.supplierNameET);

        Button buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productName = productNameET.getText().toString();
                productId = productIdET.getText().toString();
                purchasePrice = Integer.parseInt(puchasePriceET.getText().toString());
                sellingPrice = Integer.parseInt(sellingPriceET.getText().toString());
                puchaseDate = puchaseDateET.getText().toString();
                supplierName = supplierNameET.getText().toString();

                saveData();


            }
        });
    }

    public void saveData(){
        ProductDatabaseHelper productDatabaseHelper = new ProductDatabaseHelper(AddProduct.this);
        boolean saved = productDatabaseHelper.saveProduct(new Product(productName, productId, purchasePrice, sellingPrice, puchaseDate, supplierName));
        if (saved) {
            Toast.makeText(AddProduct.this, "one product_view add successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(AddProduct.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(AddProduct.this, "product_view not saved", Toast.LENGTH_SHORT).show();
        }
    }



}
