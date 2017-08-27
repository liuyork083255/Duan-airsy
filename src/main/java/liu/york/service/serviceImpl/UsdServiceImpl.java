package liu.york.service.serviceImpl;

import liu.york.exception.AirServiceException;
import liu.york.mapper.UsdMapper;
import liu.york.model.UsdIdNameModel;
import liu.york.model.UsdModel;
import liu.york.service.UsdService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/22.
 */
@Service
public class UsdServiceImpl implements UsdService {

    private static final Logger logger = LoggerFactory.getLogger(UsdServiceImpl.class);

    @Autowired
    private UsdMapper usdMapper;

    @Override
    public List<UsdModel> selectUsdByUserId(String userid) {
        return usdMapper.selectUsdByUserId(userid);
    }

    @Override
    public int insertUsd(UsdModel usdModel) {

        int flag = validateInsertSNid(usdModel.getSn());
        if(flag == 0){
            throw new AirServiceException("SN序列号无效");
        }else{

            try {
                int i = usdMapper.insertUsd(usdModel);
                int j = usdMapper.updateSNstate(usdModel.getSn());
                if(i == 0 || j == 0){
                    throw new AirServiceException("插入失败！！！");
                }
            } catch (AirServiceException e) {
                logger.error("新增SN设备失败  msg : " + e.getMessage());
            }
        }
        return 1;
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

    @Override
    public int validateInsertSNid(String sn) {
        return usdMapper.validateInsertSNid(sn);
    }

    @Override
    public int updateSNstate(String sn) {
        return usdMapper.updateSNstate(sn);
    }

    @Override
    public int validateDataComing(String sn) {
        return usdMapper.validateDataComing(sn);
    }

    @Override
    public UsdModel selectUsdBySN(String sn) {
        return usdMapper.selectUsdBySN(sn);
    }

    @Override
    public int validateUsdName(String snname) {
        return usdMapper.validateUsdName(snname);
    }

    @Override
    public int insertSN(String sn) {

        int i = usdMapper.selectSNById(sn);
        if(i == 1)
            throw new AirServiceException("该编号已存在");
        return usdMapper.insertSN(sn);
    }

    @Override
    public int selectUsdTotal() {
        return usdMapper.selectUsdTotal();
    }

    @Override
    public List<UsdModel> selectUsd(int num1, int num2) {
        return usdMapper.selectUsd(num1,num2);
    }

    @Override
    public List<UsdIdNameModel> getAll() {
        return usdMapper.getAll();
    }

    @Override
    public int selectSNById(String sn) {
        return usdMapper.selectSNById(sn);
    }

}
