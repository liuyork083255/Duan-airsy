package liu.york.service;

import liu.york.model.UserModel;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface UserService {
    UserModel selectUserByUP(String username, String password);
}
