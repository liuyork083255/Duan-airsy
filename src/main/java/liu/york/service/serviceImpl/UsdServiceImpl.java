package liu.york.service.serviceImpl;

import liu.york.exception.AirServiceException;
import liu.york.mapper.UsdMapper;
import liu.york.model.UsdIdNameModel;
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
    public List<UsdModel> selectUsdByUserId(String userid) {
        return usdMapper.selectUsdByUserId(userid);
    }

    @Override
    public int insertUsd(UsdModel usdModel) {
//        todo 首先要判断插入的的 usdModel 是否有效
        int i;
        try{
            i = usdMapper.insertUsd(usdModel);
        }catch (Exception e){
            throw new AirServiceException("插入失败！！！");
        }

        return i;
    }

    @Override
    public int updateUsd(UsdModel usdModel) {
        return usdMapper.updateUsd(usdModel);
    }

    @Override
    public int deleteUsd(String snid) {
        return usdMapper.deleteUsd(snid);
    }

    @Override
    public List<UsdIdNameModel> getAllSnName(String userid) {
        return usdMapper.getAllSnName(userid);
    }
}
