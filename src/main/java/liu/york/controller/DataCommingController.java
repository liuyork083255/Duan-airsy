package liu.york.controller;

import com.alibaba.fastjson.JSON;
import liu.york.model.DataModel;
import liu.york.model.JsonModel;
import liu.york.model.UsdModel;
import liu.york.service.DataService;
import liu.york.service.UsdService;
import liu.york.util.AirsyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * Created by Administrator on 2017/8/20.
 */
@Controller
@RequestMapping("/dataEntry")
public class DataCommingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataCommingController.class);

    @Autowired
    private UsdService usdService;
    @Autowired
    private DataService dataService;

    @ResponseBody
    @RequestMapping(value = "/coming",method = RequestMethod.GET)
    public JsonModel comingDataGet(@Validated DataModel dataModel){
        LOGGER.info("data coming data : " + JSON.toJSONString(dataModel));
        /*
        这里的传进来的 snid 是sn编号，但是在model中snid 代表的是 sn 所代表的主键id
        所以这里先是 根据 sn 编号拿到对应的 sn所在记录的model，从而拿到对应主键id
         */
        UsdModel usdModel = usdService.selectUsdBySN(dataModel.getSnid());

        if(usdModel == null) {
            LOGGER.info("无效的 SN 设备编号.");
            return new JsonModel(false, "无效的 SN 设备编号", null);
        }

        dataModel.setSnid(usdModel.getSnid());
        dataModel.setDataid(AirsyUtil.getUUID());
        dataModel.setDatetime(AirsyUtil.getCurrentTime());

        dataService.insertData(dataModel);

        LOGGER.info("upload data success.");
        return new JsonModel(true,"上传成功",null);
    }

    @ResponseBody
    @RequestMapping(value = "/coming",method = RequestMethod.POST)
    public JsonModel comingDataPost(@Valid @RequestBody DataModel dataModel){
        return comingDataGet(dataModel);
    }
}
