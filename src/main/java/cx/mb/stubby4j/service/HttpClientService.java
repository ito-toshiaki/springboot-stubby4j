package cx.mb.stubby4j.service;

import okhttp3.Response;

import java.io.IOException;

/**
 * Http Client.
 */
public interface HttpClientService {

    /**
     * Simple get.
     * @return got content.
     * @throws IOException Exception
     */
    Response simpleGet() throws IOException;
}
