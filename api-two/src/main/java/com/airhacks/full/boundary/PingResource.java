package com.airhacks.full.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/ping")
public class PingResource {

    @Inject
    TestRepository testRepository;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<TestEntity> hello() {
        return testRepository.listAll();
    }
}