package com.phinix.apps.grocerymanagement;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "itemsDB";
    public static final int VERSION = 1;
    public static final String PRODUCT_TABLE_NAME = "tbl_items";
    public static final String PRODUCT_COL_PRIMARY_ID = "primary_id";
    public static final String PRODUCT_COL_NAME = "product_name";
    public static final String PRODUCT_COL_ID = "product_id";
    public static final String PRODUCT_COL_PURCHASE_PRICE = "purchase_price";
    public static final String PRODUCT_COL_SELLING_PRICE = "selling_price";
    public static final String PRODUCT_COL_PURCHASE_DATE = "purchase_date";
    public static final String PRODUCT_COL_SUPPLIER_NAME = "supplier_name";

    public static final String CREATE_PRODUCT_TABLE = "CREATE TABLE "
            + PRODUCT_TABLE_NAME + "(" +
            PRODUCT_COL_PRIMARY_ID + " INTEGER PRIMARY KEY, " +
            PRODUCT_COL_NAME + " TEXT, " +
            PRODUCT_COL_ID + " TEXT, " +
            PRODUCT_COL_PURCHASE_PRICE + " INT, " +
            PRODUCT_COL_SELLING_PRICE + " INT, " +
            PRODUCT_COL_PURCHASE_DATE + " TEXT, " +
            PRODUCT_COL_SUPPLIER_NAME + " TEXT )";

    public ProductDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_PRODUCT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean saveProduct(Product product_detail) {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_COL_NAME, product_detail.getProductName());
        contentValues.put(PRODUCT_COL_ID, product_detail.getProductId());
        contentValues.put(PRODUCT_COL_PURCHASE_PRICE, product_detail.getProductPurchasePrice());
        contentValues.put(PRODUCT_COL_SELLING_PRICE, product_detail.getProductSellingPrice());
        contentValues.put(PRODUCT_COL_PURCHASE_DATE, product_detail.getProductPurchaseDate());
        contentValues.put(PRODUCT_COL_SUPPLIER_NAME, product_detail.getProductSupplierName());
        long noOfRowsInserted = db.insert(PRODUCT_TABLE_NAME, null, contentValues);
        db.close();

        if (noOfRowsInserted > 0) {
            return true;
        } else {
            return false;
        }

    }

    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();
        String sql = "Select * from " + PRODUCT_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Product product_detail = new Product();
                product_detail.setDbPrimaryID(Integer.parseInt(cursor.getString(0)));
                product_detail.setProductName(cursor.getString(1));
                product_detail.setProductId(cursor.getString(2));
                product_detail.setProductPurchasePrice(Integer.parseInt(cursor.getString(3)));
                product_detail.setProductSellingPrice(Integer.parseInt(cursor.getString(4)));
                product_detail.setProductPurchaseDate(cursor.getString(5));
                product_detail.setProductSupplierName(cursor.getString(6));
                productList.add(product_detail);

            } while (cursor.moveToNext());
        }


        return productList;
    }

    //added by Uchchash to get product data from selected raw

    Product setEditableProduct(int id) {

        SQLiteDatabase db = this.getWritableDatabase();


        Cursor cursor = db.rawQuery("Select * from  LIST WHERE ID = " + id + "", null);


        Product product_detail = new Product();
        product_detail.setDbPrimaryID(Integer.parseInt(cursor.getString(0)));
        product_detail.setProductName(cursor.getString(1));
        product_detail.setProductId(cursor.getString(2));
        product_detail.setProductPurchasePrice(Integer.parseInt(cursor.getString(3)));
        product_detail.setProductSellingPrice(Integer.parseInt(cursor.getString(4)));
        product_detail.setProductPurchaseDate(cursor.getString(5));
        product_detail.setProductSupplierName(cursor.getString(6));

        db.close();


        return product_detail;
    }


//    end class
}
