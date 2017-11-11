package cx.mb.stubby4j.service;

import io.github.azagniotov.stubby4j.client.StubbyClient;
import okhttp3.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientServiceImplTest {

    private StubbyClient stubbyClient;

    @Before
    public void setUp() throws Exception {

        stubbyClient = new StubbyClient();
        stubbyClient.startJetty(9999,"src/test/java/cx/mb/stubby4j/service/test.yaml");

    }

    @After
    public void tearDown() throws Exception {
        stubbyClient.stopJetty();
    }

    @Value("${url.simple.get}")
    private String url200;

    @Test
    public void get200() throws Exception {

        HttpClientService service = new HttpClientServiceImpl(url200);
        Response response = service.simpleGet();
        assertThat(response.code(), is(HttpStatus.OK.value()));
        assertThat(response.body().string(), is("{ }"));
    }

    @Test
    public void getBut404() throws IOException {

        HttpClientService service = new HttpClientServiceImpl(url200 + "/hoge");
        Response response = service.simpleGet();
        assertThat(response.code(), is(HttpStatus.NOT_FOUND.value()));
    }
}