package liu.york.service;

import liu.york.model.UsdIdNameModel;
import liu.york.model.UsdModel;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface UsdService {
    List<UsdModel> selectUsdByUserId(String userid);
    @Transactional
    int insertUsd(UsdModel usdModel);
    int updateUsd(UsdModel usdModel);
    int deleteUsd(String snid);
    List<UsdIdNameModel> getAllSnName(String userid);
    int validateInsertSNid(String sn);
    int updateSNstate(String sn);
    int validateDataComing(String sn);
    UsdModel selectUsdBySN(String sn);
    int validateUsdName(String snname);
    int insertSN(String sn);
    int selectUsdTotal();
    List<UsdModel> selectUsd(int num1,int num2);
    List<UsdIdNameModel> getAll();
    int selectSNById(String sn);

}
