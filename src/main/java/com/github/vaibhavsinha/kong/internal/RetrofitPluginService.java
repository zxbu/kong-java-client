package com.github.vaibhavsinha.kong.internal;

import com.github.vaibhavsinha.kong.model.plugin.EnabledPlugins;
import com.github.vaibhavsinha.kong.model.plugin.Plugin;
import com.github.vaibhavsinha.kong.model.plugin.PluginList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vaibhav on 12/06/17.
 */
public interface RetrofitPluginService {

    @POST("/plugins/")
    Call<Plugin> createPlugin(@Body Plugin request);

    @GET("/plugins/{id}")
    Call<Plugin> getPlugin(@Path("id") String nameOrId);

    @PATCH("/plugins/{id}")
    Call<Plugin> updatePlugin(@Path("id") String nameOrId, @Body Plugin request);

    @PUT("/plugins/")
    Call<Plugin> createOrUpdatePlugin(@Body Plugin request);

    @DELETE("/plugins/{id}")
    Call<Plugin> deletePlugin(@Path("id") String nameOrId);

    @GET("/plugins/")
    Call<PluginList> listPlugins(@Query("id") String id, @Query("api_id") String apiId, @Query("consumer_id") String consumerId, @Query("name") String name, @Query("size") Long size, @Query("offset") String offset);

    @GET("/plugins/enabled")
    Call<EnabledPlugins> listEnabledPlugins();
}