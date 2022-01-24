package com.wendy.wendyec3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.wendy.wendyec3.Interface.JsonPlaceHolderApi;
import com.wendy.wendyec3.ModelClothes.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivityPosts extends AppCompatActivity {


    private TextView mJsonTxtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_posts);

        mJsonTxtView = findViewById(R.id.jsonText);
        getPosts();
    }
    private void getPosts(){

        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Posts>> call=jsonPlaceHolderApi.getPosts();
        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {

                if(! response.isSuccessful()){
                    mJsonTxtView.setText("Codigo:"+response.code());
                    return;
                }
                List<Posts> postsList = response.body();
                for(Posts post:postsList){
                    String content = "";
                    content += "userId:"+post.getUserId() + "\n";
                    content += "id:"+post.getId() + "\n";
                    content += "title:"+post.getTitle() + "\n";
                    content += "body:"+post.getBody() + "\n\n\n";
                    mJsonTxtView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {

                mJsonTxtView.setText(t.getMessage());
            }
        });
    }
}