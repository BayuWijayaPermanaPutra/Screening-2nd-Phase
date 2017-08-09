package suitmedia.com.testscreeningbayuwpp;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Bayu WPP on 8/8/2017.
 */

public interface ServiceApi {
    static String BASE_URL = "http://dry-sierra-6832.herokuapp.com/api/";

    @GET("people")
    Call<List<Guest>> getEventPublic();

    class factory {
        public static ServiceApi create() {
            OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
            builder.readTimeout(20, TimeUnit.SECONDS);
            builder.connectTimeout(10, TimeUnit.SECONDS);
            builder.writeTimeout(20, TimeUnit.SECONDS);

            OkHttpClient client = builder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            return retrofit.create(ServiceApi.class);
        }
    }
}
