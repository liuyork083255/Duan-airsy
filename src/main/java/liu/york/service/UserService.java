package liu.york.service;

import liu.york.model.UserModel;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface UserService {
    UserModel selectUserByUP(String username, String password);
    int updateUser(UserModel userModel);
    List<UserModel> getAllUser(int num1,int num2);
    int selectUserTotal();
    int insertUser(UserModel userModel);
    UserModel selectUserByEmail(String email);
    UserModel selectUserByName(String username);
}
