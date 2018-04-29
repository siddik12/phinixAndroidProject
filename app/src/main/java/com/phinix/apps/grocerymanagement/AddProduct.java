package com.phinix.apps.grocerymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {
    EditText productNameET, productIdET, puchasePriceET, sellingPriceET, puchaseDateET, supplierNameET;

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
    }

    public void saveProduct(View view) {
        String productName = productNameET.getText().toString();
        String productId = productIdET.getText().toString();
        int purchasePrice = Integer.parseInt(puchasePriceET.getText().toString());
        int sellingPrice = Integer.parseInt(sellingPriceET.getText().toString());
        String puchaseDate = puchaseDateET.getText().toString();
        String supplierName = supplierNameET.getText().toString();

        ProductDatabaseHelper productDatabaseHelper = new ProductDatabaseHelper(this);
        boolean saved = productDatabaseHelper.saveProduct(new Product(productName, productId, purchasePrice, sellingPrice, puchaseDate, supplierName));
        if (saved) {
            Toast.makeText(this, "one product_view add successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "product_view not saved", Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(AddProduct.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
