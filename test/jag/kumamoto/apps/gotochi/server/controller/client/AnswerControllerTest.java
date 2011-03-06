package jag.kumamoto.apps.gotochi.server.controller.client;

import jag.kumamoto.apps.gotochi.server.controller.client.PinsController;
import jag.kumamoto.apps.gotochi.server.service.EventLogService;
import jag.kumamoto.apps.gotochi.server.service.PrizeService;
import jag.kumamoto.apps.gotochi.server.service.UserService;

import org.slim3.tester.ControllerTestCase;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class AnswerControllerTest extends ControllerTestCase {
    

    private UserService us = new UserService();
    private EventLogService els = new EventLogService();
    private PrizeService ps = new PrizeService();

    @Test
    public void run() throws Exception {
        tester.start("/answer");
        PinsController controller = tester.getController();
        
        
        
        assertThat(controller, is(notNullValue()));
        assertThat(tester.isRedirect(), is(false));
        assertThat(tester.getDestinationPath(), is(nullValue()));
    }
}
