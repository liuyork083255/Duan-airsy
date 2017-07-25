package liu.york.model;

/**
 * Created by Administrator on 2017/7/22.
 */
public class DataModel {
    private int dataid;
    private String pmtwo;
    private String pmten;
    private String noise;
    private String speed;
    private String direction;
    private String temperature;
    private String humidity;
    private int snid;

    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
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

    public int getSnid() {
        return snid;
    }

    public void setSnid(int snid) {
        this.snid = snid;
    }
}
