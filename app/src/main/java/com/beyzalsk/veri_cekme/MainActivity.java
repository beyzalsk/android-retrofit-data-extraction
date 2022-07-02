package com.beyzalsk.veri_cekme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button get;
    private TextView txt,texte,textee;
    private Retrofit retrofit;
    private String baseUrl = "https://worldtimeapi.org/api/timezone/";
    private TimeApi timeApi;
    private Call <Turkey> timeTurkeyCall;
    private Turkey turkey;


    private void init(){
        get = findViewById(R.id.get);
        txt = findViewById(R.id.txt);
        texte = findViewById(R.id.texte);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRetrofit();
            }
        });

    }
    private void setRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
       timeApi= retrofit.create(TimeApi.class);
       timeTurkeyCall=timeApi.getTime();

       timeTurkeyCall.enqueue(new Callback<Turkey>() {
           @Override
           public void onResponse(Call<Turkey> call, Response<Turkey> response) {
            if (response.isSuccessful()){
                turkey=response.body();
                if (turkey != null){
                    txt.setText(String.valueOf(turkey.getDayOfweek()));
                    texte.setText(turkey.getDateTime().split("T")[0]);


                }

            }
           }

           @Override
           public void onFailure(Call<Turkey> call, Throwable t) {
               System.out.println(t.toString());

           }
       });

    }
}