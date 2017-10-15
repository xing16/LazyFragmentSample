package com.xing.lazyfragmentsample.http;


import com.xing.lazyfragmentsample.CoderBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {

    @GET("{type}/{pageSize}/{curPage}")
    Observable<BaseResponse<CoderBean>> getCoderText(@Path("type") String type,
                                                     @Path("pageSize") int pageSize,
                                                     @Path("curPage") int curPage);


}
