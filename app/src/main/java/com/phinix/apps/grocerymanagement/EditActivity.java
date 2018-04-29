package com.phinix.apps.grocerymanagement;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {
    EditText editableProductName,editableProductId,editablePurchasePrice,
            editableSellingPrice,editablePurchaseDate,editableSupplierName;

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
    }

    void showPreviousData(Product product){
        editableProductName.setText(product.getProductName());
        editableProductId.setText(product.getProductId());
        editablePurchasePrice.setText(product.getProductPurchasePrice());
        editableSellingPrice.setText(product.getProductSellingPrice());
        editablePurchaseDate.setText(product.getProductPurchaseDate());
        editableSupplierName.setText(product.getProductSupplierName());
    }

}
