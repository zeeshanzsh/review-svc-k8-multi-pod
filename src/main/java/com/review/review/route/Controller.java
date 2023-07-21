package com.review.review.route;

import com.review.review.dao.ReviewRepository;
import com.review.review.model.Review;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    ReviewRepository reviewRepository;

    @GetMapping("/")
    public String index(){
        return "Review service is up";
    }
    @GetMapping("/reviews")
    public List<Review> users(){
        log.info("Get all the Reviews");
        return reviewRepository.findAll();
    }

    @PostMapping("/review")
    public Review user(@RequestBody Review user){
        log.info("Saving Review Data: {}", user);
        return reviewRepository.save(user);
    }
}
