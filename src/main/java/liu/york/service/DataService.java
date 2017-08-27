package liu.york.service;

import liu.york.model.DataModel;

import java.util.List;

/**
 * Created by liu.yang on 2017/7/28.
 */
public interface DataService {
    List<DataModel> selectDataBySNid(String snid);
    int insertData(DataModel dataModel);
    int selectDataTotal();
    List<DataModel> selectDataById(String dataid,int num1,int num2);
}
