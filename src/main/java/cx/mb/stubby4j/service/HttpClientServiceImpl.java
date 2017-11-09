package cx.mb.stubby4j.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class HttpClientServiceImpl implements HttpClientService {

   /**
    * URL
    */
   @Value ("${url}")
   private String url;

   OkHttpClient client = new OkHttpClient();

   @Override
   public String get() throws IOException {

      Request request = new Request.Builder()
              .url(url)
              .build();

      Response response = client.newCall(request).execute();
      return response.body().string();
   }
}
