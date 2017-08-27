package liu.york.service.serviceImpl;

import liu.york.mapper.UserMapper;
import liu.york.model.UserModel;
import liu.york.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public int updateUser(UserModel userModel) {
        return userMapper.updateUser(userModel);
    }

    @Override
    public List<UserModel> getAllUser(int num1,int num2) {
        return userMapper.getAllUser(num1,num2);
    }

    @Override
    public int selectUserTotal() {
        return userMapper.selectUserTotal();
    }

    @Override
    public int insertUser(UserModel userModel) {
        return userMapper.insertUser(userModel);
    }
}
