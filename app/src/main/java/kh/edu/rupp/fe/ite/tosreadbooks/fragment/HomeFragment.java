package kh.edu.rupp.fe.ite.tosreadbooks.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.ErrorListener;

import kh.edu.rupp.fe.ite.tosreadbooks.R;
import kh.edu.rupp.fe.ite.tosreadbooks.adapter.ProductsAdapter;
import kh.edu.rupp.fe.ite.tosreadbooks.model.Product;

public class HomeFragment extends Fragment {

    private ProgressBar progressBar;
    private ProductsAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // ProgressBar
        progressBar = view.findViewById(R.id.progress);

        // Reference to RecyclerView
        RecyclerView recyclerViews = view.findViewById(R.id.recyclerView);

        // Create and assign layout manager
        RecyclerView.LayoutManager layoutManagers = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerViews.setLayoutManager(layoutManagers);

        // Create and assign adapter
        adapter = new ProductsAdapter();
        recyclerViews.setAdapter(adapter);

        loadProduct();
    }
    private void loadProduct(){
        // Create request queue
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());

        // Create a request
        String url = "http://10.0.2.2/Weeks/data.php";
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                progressBar.setVisibility(View.GONE);
                Gson gson = new Gson();
                Type lisType = new TypeToken<List<Product>>(){}.getType();
                List<Product> products = gson.fromJson(response, lisType);
                adapter.setProducts(products);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Load data error. Please try again later.",Toast.LENGTH_LONG);
                Log.d("vis", "Load data error" + error.getMessage());
            }
        });
        // Add request to the queue
        requestQueue.add(request);
    };
}
