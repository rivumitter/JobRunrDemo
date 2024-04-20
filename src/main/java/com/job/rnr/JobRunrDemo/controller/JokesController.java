package com.job.rnr.JobRunrDemo.controller;

import com.job.rnr.JobRunrDemo.service.JokesService;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
public class JokesController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private JokesService jokesService;

    @GetMapping("/{name}/{numberOfSeconds}")
    public String createNamedJob(@PathVariable String name, @PathVariable Integer numberOfSeconds) {

        jobScheduler.schedule(Instant.now().plusSeconds(numberOfSeconds),
                ()-> jokesService.getARandomJoke(name));


        return name + " your random joke will be after "+ numberOfSeconds + " seconds";
    }
}
