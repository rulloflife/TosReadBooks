package kh.edu.rupp.fe.ite.tosreadbooks.adapter;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.view.SimpleDraweeView;

import kh.edu.rupp.fe.ite.tosreadbooks.R;
import kh.edu.rupp.fe.ite.tosreadbooks.model.Product;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    private SimpleDraweeView imgThumbnail;
    private TextView txtTitle;
    private TextView txtAuthor;
    private TextView txtPage;
    private TextView txtView;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);

        imgThumbnail = itemView.findViewById(R.id.img_thumbnail);
        txtTitle = itemView.findViewById(R.id.txtTitle);
        txtAuthor = itemView.findViewById(R.id.txtAuthor);
        txtPage = itemView.findViewById(R.id.txtPage);
        txtView = itemView.findViewById(R.id.txtView);

    }

    public void bindData(Product product){
        imgThumbnail.setImageURI(product.getThumbnailUrl());
        txtTitle.setText(product.getTitle());
        txtAuthor.setText(product.getAuthor());
        //txtPage.setText(product.getPages());
        //txtView.setText(product.getViews());

    }

}
