package liu.york.service.serviceImpl;

import liu.york.mapper.UserMapper;
import liu.york.model.UserModel;
import liu.york.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/16.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserModel selectUserByUP(String username, String password) {
        return userMapper.selectUserByUP(username,password);
    }
}
