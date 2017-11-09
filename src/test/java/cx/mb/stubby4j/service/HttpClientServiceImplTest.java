package cx.mb.stubby4j.service;

import io.github.azagniotov.stubby4j.client.StubbyClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HttpClientServiceImplTest {

    private StubbyClient stubbyClient;

    @Before
    public void setUp() throws Exception {

        stubbyClient = new StubbyClient();
        stubbyClient.startJetty(8888,"src/test/java/cx/mb/stubby4j/service/test.yaml");

    }

    @After
    public void tearDown() throws Exception {
        stubbyClient.stopJetty();
    }

    @Autowired
    private HttpClientService client;

    @Test
    public void get() throws Exception {
        assertThat(client.get(), is("{}"));
    }

}