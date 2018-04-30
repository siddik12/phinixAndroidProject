package com.phinix.apps.grocerymanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {
    EditText editableProductName,editableProductId,editablePurchasePrice,
            editableSellingPrice,editablePurchaseDate,editableSupplierName;
    private Product product;

    String name,id,pdate,supplier;
    int price,sell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editableProductName = findViewById(R.id.edit_productNameET);
        editableProductId = findViewById(R.id.edit_productIdET);
        editablePurchasePrice = findViewById(R.id.edit_purchasePriceET);
        editableSellingPrice = findViewById(R.id.edit_sellingPriceET);
        editablePurchaseDate = findViewById(R.id.edit_purchaseDateET);
        editableSupplierName = findViewById(R.id.edit_supplierNameET);


        Intent intent = getIntent();
        int id = intent.getIntExtra("id",1);

        ProductDatabaseHelper databaseHelper = new ProductDatabaseHelper(this);
        product = databaseHelper.getProduct(id);
        showPreviousData(product);




    }

    void showPreviousData(Product product){

        editableProductName.setText(product.getProductName());
        editableProductId.setText(product.getProductId());
        editablePurchasePrice.setText(String.valueOf(product.getProductPurchasePrice()));
        editableSellingPrice.setText(String.valueOf(product.getProductSellingPrice()));
        editablePurchaseDate.setText(product.getProductPurchaseDate());
        editableSupplierName.setText(product.getProductSupplierName());
    }

    public void saveEditedProduct(View view) {


            product.setProductId(editableProductId.getText().toString());
            product.setProductName(editableProductName.getText().toString());
            product.setProductPurchasePrice(Integer.parseInt(editablePurchasePrice.getText().toString()));
            product.setProductSellingPrice(Integer.parseInt(editableSellingPrice.getText().toString()));
            product.setProductPurchaseDate(editablePurchaseDate.getText().toString());
            product.setProductSupplierName(editableSupplierName.getText().toString());

            ProductDatabaseHelper databaseHelper = new ProductDatabaseHelper(this);

            databaseHelper.updateProduct(product);

            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();



    }
}
