package jag.kumamoto.apps.gotochi.server.model;

import org.slim3.tester.AppEngineTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class PinTest extends AppEngineTestCase {

    private Pin model = new Pin();

    @Test
    public void test() throws Exception {
        assertThat(model, is(notNullValue()));
    }
}
