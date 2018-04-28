package com.phinix.apps.grocerymanagement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    SearchResult searchResultFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void addProduct(View view) {
            Intent intent = new Intent(MainActivity.this,Add_product.class);
            startActivity(intent);
    }

    public void searchItem(View view) {


        searchResultFragment = new SearchResult();
        loadFragment(searchResultFragment);
        ProductDatabaseHelper dbHelper  = new ProductDatabaseHelper(this);
        List<Product_Detail> product_details = dbHelper.getAllProducts();

        for(Product_Detail list:product_details){
            String msg = "primary id "+list.getDbPrimaryID()+
                    ", name "+list.getProductName()+", purchase price "
                    + list.getProductPurchasePrice();
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    private void loadFragment(Fragment fragment) {
// create a FragmentManager
        FragmentManager fm = getSupportFragmentManager();
// create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
// replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.search_result_fl, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}

