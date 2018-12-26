package com.haluancorp.robustmobile;

import com.haluancorp.robustmobile.object.Company;
import com.haluancorp.robustmobile.object.CurrentUserInformation;
import com.haluancorp.robustmobile.object.Login;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Interface {
    @FormUrlEncoded
    @POST("servlet/manager")
    Call<Login> login(@Field("cmd") String cmd,
                      @Field("userId") String userId,
                      @Field("pin") String pin);

    @FormUrlEncoded
    @POST("servlet/manager")
    Call<Company> company(@Field("cmd") String cmd,
                          @Field("cls") String cls,
                          @Field("start") int start,
                          @Field("nlist") int nlist,
                          @Field("ncres") int ncres,
                          @Field("dform0") String dform0,
                          @Field("populate") Boolean populate,
                          @Header("Cookie") String cookie);

    @FormUrlEncoded
    @POST("servlet/manager")
    Call<CurrentUserInformation> currentUserInformation(@Field("cmd") String cmd,
                                                         @Header("Cookie") String cookie);
}
