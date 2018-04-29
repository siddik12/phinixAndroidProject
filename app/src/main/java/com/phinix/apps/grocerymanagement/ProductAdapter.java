package com.phinix.apps.grocerymanagement;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements Filterable {

    private List<Product> productList;
    private List<Product> filteredList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
        this.filteredList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = filteredList.get(position);
        holder.name.setText(product.getProductName());
        holder.price.setText(String.valueOf(product.getProductPurchasePrice()));
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String query = charSequence.toString();
                List<Product>tempList = new ArrayList<>();
                if(query.isEmpty()){
                    filteredList = productList;
                }else{
                    for(Product p : productList){
                        if(p.getProductName().toLowerCase().contains(query.toLowerCase())){
                            tempList.add(p);
                        }
                    }
                    filteredList = tempList;
                }
                FilterResults results = new FilterResults();
                results.values = filteredList;
                return results;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filteredList = (List<Product>) filterResults.values;
                notifyDataSetChanged();//refresh recyclerview items
            }
        };
    }

    class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView name,price;
        ProductViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            price = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
