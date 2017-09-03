package liu.york.mapper;

import liu.york.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
@Repository
public interface UserMapper {
    UserModel selectUserByUP(@Param("username") String username,@Param("password") String password);
    int updateUser(UserModel userModel);
    List<UserModel> getAllUser(@Param("num1")int num1,@Param("num2") int num2);
    int selectUserTotal();
    int insertUser(UserModel userModel);
    UserModel selectUserByEmail(@Param("email") String email);
    UserModel selectUserByName(@Param("username") String username);
}
