package com.example.da08.airbnbserach;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Da08 on 2017. 7. 28..
 */


public interface Isearch {
    public static final String SERVER = "http://192.168.10.253:8080/";
    /**
     *
     * @param checkin
     * @param checkout
     * @param guests
     * @param type      집 유형 0 개인 1 투룸 2 집전체
     * @param pricemin
     * @param pricemax
     * @param wifi      와이파이 존재여부 0 없음 1 있음
     * @return
     */
    @GET("/airbnb/house")
    Observable<ResponseBody> get(@Query("checkin") String checkin, @Query("checkout") String checkout
            , @Query("guests") int guests, @Query("type") int type, @Query("pricemin") int pricemin
            , @Query("pricemax") int pricemax, @Query("amenities") int wifi);
}
