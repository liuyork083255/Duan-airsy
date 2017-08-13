package liu.york.mapper;

import liu.york.model.UsdIdNameModel;
import liu.york.model.UsdModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Repository
public interface UsdMapper {
    List<UsdModel> selectUsdByUserId(@Param("userid")String userid);
    int insertUsd(UsdModel usdModel);
    int updateUsd(UsdModel usdModel);
    int deleteUsd(@Param("snid") String snid);
    List<UsdIdNameModel> getAllSnName(@Param("userid") String userid);
}
