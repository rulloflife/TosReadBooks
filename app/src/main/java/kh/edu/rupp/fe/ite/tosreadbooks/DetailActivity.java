package kh.edu.rupp.fe.ite.tosreadbooks;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import kh.edu.rupp.fe.ite.tosreadbooks.model.Product;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PRODUCT_JSON = "productJson";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);

        //Use Toolbar to replace ActionBar
        setSupportActionBar(toolbar);

        //Show back button on Toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Remove title
        getSupportActionBar().setTitle("");

        SimpleDraweeView imgProduct = findViewById(R.id.imgDetail);
        TextView txtTitle = findViewById(R.id.titleDetail);
        TextView txtAuthor = findViewById(R.id.authorDetail);

        Intent intent = getIntent();
        //String imgUrl = intent.getStringExtra("imgUrl");
        String productJson = intent.getStringExtra(EXTRA_PRODUCT_JSON);
        Gson gson = new Gson();
        Product product = gson.fromJson(productJson, Product.class);
        imgProduct.setImageURI(product.getThumbnailUrl());
        txtTitle.setText(product.getTitle());
        txtAuthor.setText(product.getAuthor());

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_more, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == android.R.id.home){

        } else if (item.getItemId() == R.id.mnu_search){

        } else if (item.getItemId() == R.id.mnu_more){

        }

        return super.onOptionsItemSelected(item);
    }
}
