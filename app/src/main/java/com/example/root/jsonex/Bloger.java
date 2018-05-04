package com.example.root.jsonex;

import retrofit2.Call;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class Bloger {

    public static final String key="AIzaSyBKXZTExP3PF6_0EzjfzLUI0oH_2oPaNsA";
    public static final String url="https://www.googleapis.com/blogger/v3/blogs/1463921159955360111/posts/";

    public static PostService postService=null;

    public  static PostService getService()
    {
        if(postService==null)
        {
            Retrofit retrofit =new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            postService=retrofit.create(PostService.class);

        }
        return postService;
    }


    public interface PostService
    {
        @GET("?key=?"+key)
       Call<PostList> getPostList();

        @GET("{postId}/?key"+key)
        Call<Item> getPostById(@Path("postId") String id);
    }

}
