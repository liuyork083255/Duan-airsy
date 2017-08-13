package liu.york.service;

import liu.york.model.UsdIdNameModel;
import liu.york.model.UsdModel;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface UsdService {
    List<UsdModel> selectUsdByUserId(String userid);
    int insertUsd(UsdModel usdModel);
    int updateUsd(UsdModel usdModel);
    int deleteUsd(String snid);
    List<UsdIdNameModel> getAllSnName(String userid);
}
