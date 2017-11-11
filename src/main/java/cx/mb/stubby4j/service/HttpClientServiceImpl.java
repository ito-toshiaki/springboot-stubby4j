package cx.mb.stubby4j.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * Http Client.
 */
@Service
public class HttpClientServiceImpl implements HttpClientService {

   /**
    * URL
    */
   private String url;

   @Autowired
   public HttpClientServiceImpl(@Value("${url.simple.get}") String url) {
       this.url = url;
   }

   OkHttpClient client = new OkHttpClient();

   @Override
   public Response simpleGet() throws IOException {

      Request request = new Request.Builder()
              .url(url)
              .build();

       return client.newCall(request).execute();
   }
}
