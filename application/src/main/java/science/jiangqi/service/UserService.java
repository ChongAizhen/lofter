package science.jiangqi.service;

import science.jiangqi.entity.User;

/**
 * Created by chongaizhen on 2018/04/17.
 */
public interface UserService {

    User login(User user);

    User findByUserName(String username);
}
