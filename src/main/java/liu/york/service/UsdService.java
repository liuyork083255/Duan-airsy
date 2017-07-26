package liu.york.service;

import liu.york.model.UsdModel;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface UsdService {
    List<UsdModel> selectUsdByUserId(int userid);
    int insertUsd(UsdModel usdModel);
    int updateUsd(UsdModel usdModel);
    int deleteUsd(String snid);
}
