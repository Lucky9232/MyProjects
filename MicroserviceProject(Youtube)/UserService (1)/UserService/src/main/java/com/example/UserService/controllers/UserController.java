package com.example.UserService.controllers;

import com.example.UserService.entities.User;
import com.example.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
   private UserService userService ;

    @PostMapping
    public ResponseEntity<User> createUser( @RequestBody User user)
    {
        User user1 = userService.saveUser(user);

        return ResponseEntity.status(HttpStatus.CREATED).body(user1);

    }

    // here call hotel as well as rating service that why here add circuit breaker

    //code for rate limiter
    //@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBackMethod1")

    //code for Retry
    //@Retry(name = "userRetry", fallbackMethod = "ratingHotelFallBackMethod2")

    //code for circuit breaker
    @CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallBackMethod")
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId)
    {
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    //creating fall back method for circuit breaker
    public ResponseEntity<User> ratingHotelFallBackMethod(String userId, Exception ex)
    {
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("dummy")
                .about("This user is created dummy because some service is down")
                .userId("420")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser()
    {
        List<User> allUser = userService.getAllUser();
        return ResponseEntity.ok(allUser);
    }

}
