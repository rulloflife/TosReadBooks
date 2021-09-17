package kh.edu.rupp.fe.ite.tosreadbooks.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.List;

import kh.edu.rupp.fe.ite.tosreadbooks.DetailActivity;
import kh.edu.rupp.fe.ite.tosreadbooks.R;
import kh.edu.rupp.fe.ite.tosreadbooks.model.Product;

public class ProductsAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    private List<Product> products;

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // Inflate a layout to View object
        View itemView; //snob
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext()); //wind
        //bind
        itemView = layoutInflater.inflate(R.layout.view_holder_product, parent, false);
        // Create a view holder
        //ProductViewHolder viewHolder = new ProductViewHolder(itemView); long code
        //return viewHolder
        return new ProductViewHolder(itemView); //sort code
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = products.get(position);
        holder.bindData(product);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                //intent.putExtra("imgUrl", product.getThumbnailUrl());
                Gson gson = new Gson();
                String productJson = gson.toJson(product);
                intent.putExtra(DetailActivity.EXTRA_PRODUCT_JSON, productJson);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(products == null){
            return 0;
        }
        return products.size();
    }

    public void setProducts(List<Product> products) {
        this.products = products;
        notifyDataSetChanged();
    }
}
