package liu.york.controller;

import liu.york.exception.AirControllerException;
import liu.york.model.DataModel;
import liu.york.model.JsonModel;
import liu.york.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by liu.yang on 2017/7/28.
 */
@Controller
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @ResponseBody
    @RequestMapping("/selectDataBySNid")
    public JsonModel selectDataBySNid(String snid){
        JsonModel json = new JsonModel();
        if(snid == null)
            throw new AirControllerException("param is null");

        List<DataModel> dataModels = dataService.selectDataBySNid(snid);

        json.setObj(dataModels);
        json.setSuccess(true);
        return json;
    }



}
