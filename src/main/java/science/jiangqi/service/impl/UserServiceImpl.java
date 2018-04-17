package science.jiangqi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import science.jiangqi.dao.UserMapper;
import science.jiangqi.entity.User;
import science.jiangqi.service.UserService;

/**
 * Created by chongaizhen on 2018/04/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(User user) {
        return null;
    }

    public User findByUserName(String username) {
        return null;
    }
}
