package liu.york.service.serviceImpl;

import liu.york.mapper.UsdMapper;
import liu.york.model.UsdModel;
import liu.york.service.UsdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Service
public class UsdServiceImpl implements UsdService {
    @Autowired
    private UsdMapper usdMapper;

    @Override
    public List<UsdModel> selectUsdByUserId(int userid) {
        return usdMapper.selectUsdByUserId(userid);
    }
}
