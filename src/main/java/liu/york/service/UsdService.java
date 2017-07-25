package liu.york.service;

import liu.york.model.UsdModel;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
public interface UsdService {
    List<UsdModel> selectUsdByUserId(int userid);
}
