package com.xx.xx.web;

import com.google.common.collect.Maps;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.Map;

@Path("/test")
@Produces("application/json;charset=utf-8")
public class TestResource {
    @GET
    @Path("t")
    public Response authenticate(@QueryParam("ticket") String ticket, @QueryParam("serviceId") String serviceId) {
        Map<String, String> map = Maps.newHashMap();
        map.put("ticket", ticket);
        map.put("serviceId", serviceId);
        return Response.ok().entity(map).build();
    }
}
