package liu.york.model;

import javax.validation.constraints.NotNull;

/**
 * Created by Administrator on 2017/7/22.
 */
public class DataModel {
    private String dataid;
    @NotNull(message = "PM2.0 不能为空")
    private String pmtwo;
    @NotNull(message = "PM10.0 不能为空")
    private String pmten;
    @NotNull(message = "噪音 不能为空")
    private String noise;
    @NotNull(message = "风速 不能为空")
    private String speed;
    @NotNull(message = "风向 不能为空")
    private String direction;
    @NotNull(message = "温度 不能为空")
    private String temperature;
    @NotNull(message = "湿度 不能为空")
    private String humidity;
    @NotNull(message = "风力 不能为空")
    private String power;

    @NotNull(message = "SN设备号 不能为空")
    private String snid;

    private String datetime;

    public String getDataid() {
        return dataid;
    }

    public void setDataid(String dataid) {
        this.dataid = dataid;
    }

    public String getPmtwo() {
        return pmtwo;
    }

    public void setPmtwo(String pmtwo) {
        this.pmtwo = pmtwo;
    }

    public String getPmten() {
        return pmten;
    }

    public void setPmten(String pmten) {
        this.pmten = pmten;
    }

    public String getNoise() {
        return noise;
    }

    public void setNoise(String noise) {
        this.noise = noise;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getSnid() {
        return snid;
    }

    public void setSnid(String snid) {
        this.snid = snid;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }
}
