package channelsample.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class ChannelDataTest extends AppEngineTestCase {

    private ChannelData model = new ChannelData();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
