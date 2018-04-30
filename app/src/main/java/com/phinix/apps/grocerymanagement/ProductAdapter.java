package com.phinix.apps.grocerymanagement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> implements Filterable {

    private List<Product> productList;
    private List<Product> filteredList;
    private Context context;

    public ProductAdapter(Context context,List<Product> productList) {
        this.productList = productList;
        this.filteredList = productList;
        this.context = context;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view,parent,false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ProductViewHolder holder, final int position) {
        final Product product = filteredList.get(position);
        holder.name.setText(product.getProductName());
        holder.price.setText(String.valueOf(product.getProductPurchasePrice()));
        holder.buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, EditActivity.class);
                intent.putExtra("id",product.getDbPrimaryID());
                context.startActivity(intent);
            }
        });
        holder.buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to delete?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        ProductDatabaseHelper databaseHelper = new ProductDatabaseHelper(context);

                        databaseHelper.deleteProduct(product.getDbPrimaryID());
                        notifyDataSetChanged();
                        Intent intent = new Intent(context, MainActivity.class);
                        context.startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });
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
        Button buttonEdit,buttonDelete;
        ProductViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textViewName);
            price = itemView.findViewById(R.id.textViewPrice);
            buttonEdit = itemView.findViewById(R.id.buttonEdit);
            buttonDelete = itemView.findViewById(R.id.buttonDelete);
        }
    }
}
