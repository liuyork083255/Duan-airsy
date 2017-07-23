package liu.york.mapper;

import liu.york.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/7/16.
 */
@Repository
public interface UserMapper {
    UserModel selectUserByUP(@Param("username") String username,@Param("password") String password);
    int updateUser(UserModel userModel);
}
