package com.dailycodebuffer.user.controller;

import com.dailycodebuffer.user.VO.Department;
import com.dailycodebuffer.user.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.entity.User;
import com.dailycodebuffer.user.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user) {
        log.info("Inside saveUser of UserController");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name="userService", fallbackMethod = "userFallBackMethod")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
        log.info("Inside getUserWithDepartment of UserController");
        return userService.getUserWithDepartment(userId);
    }

    public ResponseTemplateVO userFallBackMethod(Long userId,Exception e){
       System.out.println("I am in emergency Function....%%%%%%^^^^^^^^^^&&&&&&&&&*********");
       User user = new User(000l,"Admin","Admin","PGS.pune@gmail.com",4562l);
       Department department = new Department(12l,"Service Maintenance ","Pune","ITRC52");
       ResponseTemplateVO obj = new ResponseTemplateVO(user,department);

       return obj;
    }

}
