package com.beyzalsk.veri_cekme;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TimeApi {
    @GET("Europe/Istanbul")
    Call <Turkey> getTime();
}
