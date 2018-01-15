package mobileappscompany.dickssportinggood;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity: ";
    List<SportingGood> sportingGoodList;
    Context context;
    SportingGoodAdapter sportingGoodAdapter;
    RecyclerView recyclerView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadDataToView();
    }

    private void loadDataToView() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        Call<List<SportingGood>> call = api.getSportingGoods();
        call.enqueue(new Callback<List<SportingGood>>() {

            @Override
            public void onResponse(Call<List<SportingGood>> call, Response<List<SportingGood>> response) {
                List<SportingGood> sportingGoodList = response.body();

                Log.d(TAG, "In loadDataToView. Num Vevues:" + response.body().size());

                for (int i = 0; i < sportingGoodList.size(); i++) {
                    //Log.d(TAG, sportingGoodList.get(i).getName());
                }
                sportingGoodAdapter = new SportingGoodAdapter(context, sportingGoodList);
                recyclerView.setAdapter(sportingGoodAdapter);
            }

            @Override
            public void onFailure(Call<List<SportingGood>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d(TAG, t.getMessage());
            }
        });

    }
}
