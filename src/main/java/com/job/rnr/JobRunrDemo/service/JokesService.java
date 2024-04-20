package com.job.rnr.JobRunrDemo.service;

import com.job.rnr.JobRunrDemo.dto.Jokes;
import org.jobrunr.jobs.annotations.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Service
public class JokesService {

    @Autowired
    RestTemplate restTemplate;

    @Job(name = "jokes job")
    public void getARandomJoke(String name, LocalDateTime localDateTime) {

        Jokes jokes = restTemplate.getForEntity("https://icanhazdadjoke.com/", Jokes.class).getBody();
        assert jokes != null;
        System.out.println(name + " your joke of the day is: "+ jokes.joke());

    }
}
