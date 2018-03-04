package liu.york.util;

/**
 * Created by Administrator on 2018/3/4.
 */
public enum PowerEnum {
    ZERO("0"),ONE("1"),TWO("2"),THREE("3"),FOUR("4"),FIVE("5"),SEX("6"),
    SEVEN("7"),EIGHT("8"),NINE("9"),TEN("10"),ELEVEN("11"),TWELVE("12");
    private String power;
    PowerEnum(String power){
        this.power = power;
    }

    public String getPower(){
        return power;
    }
}
