package cx.mb.stubby4j.service;

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
    String simpleGet() throws IOException;
}
