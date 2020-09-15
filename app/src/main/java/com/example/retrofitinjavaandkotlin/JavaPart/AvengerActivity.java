package com.example.retrofitinjavaandkotlin.JavaPart;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofitinjavaandkotlin.R;
import com.example.retrofitinjavaandkotlin.interfaces.AvengerApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AvengerActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avenger);

        listView=findViewById(R.id.listViewHeroes);
        getHeroes();

    }

    private void getHeroes(){
        Retrofit retrofit=new Retrofit.Builder().baseUrl(AvengerApi.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        AvengerApi avengerApi=retrofit.create(AvengerApi.class);

        Call<List<Hero>> call=avengerApi.getHeroes();

        call.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {

                List<Hero> heroList=response.body();

                String[] heroes=new String[heroList.size()];
                for( int i=0; i<heroList.size();i++){
                    heroes[i]=heroList.get(i).getName();
                }

                listView.setAdapter(new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,heroes));
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }

}
