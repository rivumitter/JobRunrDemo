package com.job.rnr.JobRunrDemo.controller;

import com.job.rnr.JobRunrDemo.service.JokesService;
import org.jobrunr.scheduling.BackgroundJob;
import org.jobrunr.scheduling.JobScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;

@RestController
public class JokesController {

    @Autowired
    private JobScheduler jobScheduler;

    @Autowired
    private JokesService jokesService;

    @GetMapping("/{name}/{time}")
    public String createNamedJob(@PathVariable String name, @PathVariable String time) {

        var schTime = LocalDateTime.parse(time);

        jobScheduler.schedule(schTime,
                ()-> jokesService.getARandomJoke(name, schTime));


        return name + " your random joke will be at "+ schTime;
    }
}
