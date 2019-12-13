package com.airhacks.full.boundary;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("/ping")
public class PingResource {

    @Inject
    TestRepository testRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TestEntity> hello() {
        TestEntity a = new TestEntity();
        a.setName("name");
        List<TestEntity> listAll = new ArrayList<>();
        listAll.addAll(testRepository.listAll());
        listAll.add(a);
        return listAll;
    }

}