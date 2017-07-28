package liu.york.service.serviceImpl;

import liu.york.mapper.DataMapper;
import liu.york.model.DataModel;
import liu.york.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by liu.yang on 2017/7/28.
 */
@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataMapper dataMapper;

    @Override
    public List<DataModel> selectDataBySNid(String snid) {
        return dataMapper.selectDataBySNid(snid);
    }
}
