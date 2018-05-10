package com.example.nishan.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nishan.retrofit.Adapter.ActorListAdapter;
import com.example.nishan.retrofit.Model.Actor;
import com.example.nishan.retrofit.Rest.ApiClient;
import com.example.nishan.retrofit.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView listViewActorList;
    private List<Actor> actors;


    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "/api/utilitiesapi/getsearch?q=anmol";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewActorList = (ListView) findViewById(R.id.listViewActorList);


        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call call = apiService.findAll();
        call.enqueue(new Callback() {
            @Override
            public void onResponse(Call call, Response response) {
                actors = (List<Actor>) response.body();
                listViewActorList.setAdapter(new ActorListAdapter(getApplicationContext(), actors));
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
