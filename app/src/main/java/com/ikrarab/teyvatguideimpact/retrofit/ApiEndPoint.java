package com.ikrarab.teyvatguideimpact.retrofit;

import com.ikrarab.teyvatguideimpact.CharListModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiEndPoint {
    @GET("characters/")
    Call<CharListModel> getCharListData();
}
