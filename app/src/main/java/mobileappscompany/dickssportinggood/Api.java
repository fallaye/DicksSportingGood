package mobileappscompany.dickssportinggood;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by fallaye on 1/15/18.
 */

public interface Api {

    String BASE_URL = "https://movesync-qa.dcsg.com/dsglabs/mobile/api/";

    @GET("venue")
    Call<List<SportingGood>> getSportingGoods();

}

