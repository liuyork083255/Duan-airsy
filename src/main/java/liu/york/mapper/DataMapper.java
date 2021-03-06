package liu.york.mapper;

import liu.york.model.DataModel;
import liu.york.model.UserModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
@Repository
public interface DataMapper {
    List<DataModel> selectDataBySNid(@Param("snid")String snid);
    int insertData(DataModel dataModel);
    int selectDataTotal();
    List<DataModel> selectDataById(@Param("dataid")String dataid,@Param("num1")int num1,@Param("num2") int num2);
}
