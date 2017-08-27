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
    int validateInsertSNid(@Param("sn") String sn);
    int updateSNstate(@Param("sn") String sn);
    int validateDataComing(@Param("sn") String sn);
    UsdModel selectUsdBySN(@Param("sn") String sn);
    int validateUsdName(@Param("snname") String snname);
    int insertSN(@Param("sn") String sn);
    int selectUsdTotal();
    List<UsdModel> selectUsd(@Param("num1")int num1,@Param("num2") int num2);
    List<UsdIdNameModel> getAll();
    int selectSNById(@Param("sn") String sn);
}
