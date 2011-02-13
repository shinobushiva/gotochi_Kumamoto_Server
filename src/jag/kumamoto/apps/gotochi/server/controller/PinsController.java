package jag.kumamoto.apps.gotochi.server.controller;

import jag.kumamoto.apps.gotochi.server.model.Pin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.topgate.controller.JsonController;

import org.slim3.datastore.Datastore;

public class PinsController extends JsonController {

    @Override
    protected Map<String, Object> handle() throws Exception {

        Map<String, Object> map = new HashMap<String, Object>();

        List<Pin> pins = Datastore.query(Pin.class).asList();

        map.put("pins", pins);

        return map;
    }

}
