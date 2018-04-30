package com.phinix.apps.grocerymanagement;


public class Product {
    private int dbPrimaryID;
    private String productName;
    private String productId;
    private int productPurchasePrice;
    private int productSellingPrice;
    private String productPurchaseDate;
    private String productSupplierName;

    public Product() {
    }

    public Product(String productName, String productId, int productPurchasePrice, int productSellingPrice, String productPurchaseDate, String productSupplierName) {
        this.productName = productName;
        this.productId = productId;
        this.productPurchasePrice = productPurchasePrice;
        this.productSellingPrice = productSellingPrice;
        this.productPurchaseDate = productPurchaseDate;
        this.productSupplierName = productSupplierName;
    }

    public Product(int dbPrimaryID, String productName, String productId, int productPurchasePrice, int productSellingPrice, String productPurchaseDate, String productSupplierName) {
        this.dbPrimaryID = dbPrimaryID;
        this.productName = productName;
        this.productId = productId;
        this.productPurchasePrice = productPurchasePrice;
        this.productSellingPrice = productSellingPrice;
        this.productPurchaseDate = productPurchaseDate;
        this.productSupplierName = productSupplierName;
    }

    public int getDbPrimaryID() {
        return dbPrimaryID;
    }

    public void setDbPrimaryID(int dbPrimaryID) {
        this.dbPrimaryID = dbPrimaryID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getProductPurchasePrice() {
        return productPurchasePrice;
    }

    public void setProductPurchasePrice(int productPurchasePrice) {
        this.productPurchasePrice = productPurchasePrice;
    }

    public int getProductSellingPrice() {
        return productSellingPrice;
    }

    public void setProductSellingPrice(int productSellingPrice) {
        this.productSellingPrice = productSellingPrice;
    }

    public String getProductPurchaseDate() {
        return productPurchaseDate;
    }

    public void setProductPurchaseDate(String productPurchaseDate) {
        this.productPurchaseDate = productPurchaseDate;
    }

    public String getProductSupplierName() {
        return productSupplierName;
    }

    public void setProductSupplierName(String productSupplierName) {
        this.productSupplierName = productSupplierName;
    }

    @Override
    public String toString() {
        return "Product{" +
                "dbPrimaryID=" + dbPrimaryID +
                ", productName='" + productName + '\'' +
                ", productId='" + productId + '\'' +
                ", productPurchasePrice=" + productPurchasePrice +
                ", productSellingPrice=" + productSellingPrice +
                ", productPurchaseDate='" + productPurchaseDate + '\'' +
                ", productSupplierName='" + productSupplierName + '\'' +
                '}';
    }
}
