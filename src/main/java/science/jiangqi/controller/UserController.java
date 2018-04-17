package science.jiangqi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import science.jiangqi.entity.User;

/**
 * Created by chongaizhen on 2018/04/17.
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class UserController {

    @RequestMapping(value = "/auth/login", method = RequestMethod.POST)
    public User login(@RequestBody User user){
        return user;
    }
}
