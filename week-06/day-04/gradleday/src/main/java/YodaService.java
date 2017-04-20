import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface YodaService {
  @Headers({
      "X-Mashape-Key: GCPNTFcRrsmshaH9RZY9uTCDudd2p17qsayjsnwEqBI5Zun17W",
      "Accept: text/plain"
  })
  @GET("yoda")
  Call<ResponseBody> getLine(@Query("sentence") String text);
}