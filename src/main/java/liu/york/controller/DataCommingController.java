package liu.york.controller;

import com.alibaba.fastjson.JSON;
import liu.york.model.DataModel;
import liu.york.model.JsonModel;
import liu.york.model.UsdModel;
import liu.york.service.DataService;
import liu.york.service.UsdService;
import liu.york.util.AirsyUtil;
import liu.york.util.PowerEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
        if(dataModel == null) return null;
        /*
        这里的传进来的 snid 是sn编号，但是在model中snid 代表的是 sn 所代表的主键id
        所以这里先是 根据 sn 编号拿到对应的 sn所在记录的model，从而拿到对应主键id
         */
        UsdModel usdModel = usdService.selectUsdBySN(dataModel.getSnid());

        if(usdModel == null) {
            LOGGER.info("无效的 SN 设备编号.");
            return new JsonModel(false, "无效的 SN 设备编号", null);
        }

        // 设置风力值
        if(StringUtils.isEmpty(dataModel.getPower()) && !StringUtils.isEmpty(dataModel.getSpeed())){
            double speed = 0;
            try {
                speed = Double.parseDouble(dataModel.getSpeed());
            } catch (NumberFormatException e) {
                LOGGER.error("风速值非法    data:{}   exception:{}",JSON.toJSONString(dataModel),e.getMessage());
                dataModel.setSpeed("--");
                dataModel.setPower("--");
            }
            if(speed >= 0.0 && speed < 0.2)dataModel.setPower(PowerEnum.ZERO.getPower());
            else if(speed >= 0.2 && speed < 1.5)dataModel.setPower(PowerEnum.ONE.getPower());
            else if(speed >= 1.5 && speed < 3.3)dataModel.setPower(PowerEnum.TWO.getPower());
            else if(speed >= 3.3 && speed < 5.4)dataModel.setPower(PowerEnum.THREE.getPower());
            else if(speed >= 5.4 && speed < 7.9)dataModel.setPower(PowerEnum.FOUR.getPower());
            else if(speed >= 7.9 && speed < 10.7)dataModel.setPower(PowerEnum.FIVE.getPower());
            else if(speed >= 10.7 && speed < 13.8)dataModel.setPower(PowerEnum.SEX.getPower());
            else if(speed >= 13.8 && speed < 17.1)dataModel.setPower(PowerEnum.SEVEN.getPower());
            else if(speed >= 17.1 && speed < 20.7)dataModel.setPower(PowerEnum.EIGHT.getPower());
            else if(speed >= 20.7 && speed < 24.4)dataModel.setPower(PowerEnum.NINE.getPower());
            else if(speed >= 24.4 && speed < 28.4)dataModel.setPower(PowerEnum.TEN.getPower());
            else if(speed >= 28.4 && speed < 32.6)dataModel.setPower(PowerEnum.ELEVEN.getPower());
            else if(speed >= 32.6)dataModel.setPower(PowerEnum.TWELVE.getPower());
            else{
                LOGGER.error("风力值范围异常    data:{}",JSON.toJSONString(dataModel));
                dataModel.setSpeed("--");
                dataModel.setPower("--");
            }
        }

        String direction = dataModel.getDirection();
        if(!StringUtils.isEmpty(direction)){
            switch (direction){
                case "0":dataModel.setDirection("北");break;
                case "1":dataModel.setDirection("东北");break;
                case "2":dataModel.setDirection("东");break;
                case "3":dataModel.setDirection("东南");break;
                case "4":dataModel.setDirection("南");break;
                case "5":dataModel.setDirection("西南");break;
                case "6":dataModel.setDirection("西");break;
                case "7":dataModel.setDirection("西北");break;
                default:
                    dataModel.setDirection("其它");
            }
        }


        if(dataModel.getNoise() == null) dataModel.setNoise("--");
        if(dataModel.getPmten() == null )dataModel.setPmten("--");
        if(dataModel.getPmtwo() == null) dataModel.setPmtwo("--");
        if(dataModel.getPower() == null) dataModel.setPmtwo("--");
        if(dataModel.getSpeed() == null) dataModel.setSpeed("--");
        if(dataModel.getHumidity() == null) dataModel.setHumidity("--");
        if(dataModel.getDirection() == null) dataModel.setDirection("--");
        if(dataModel.getTemperature() == null) dataModel.setTemperature("--");

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
