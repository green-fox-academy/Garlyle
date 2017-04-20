import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;

import java.io.IOException;

public class YodaSpeak {
  public static void main(String[] args) {
    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("https://yoda.p.mashape.com/")
        .build();

    YodaService service = retrofit.create(YodaService.class);

    Call<ResponseBody> repos = service.getLine("You will learn how to speak like me someday.");

    try {
      System.out.println(repos.execute().body().string());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
