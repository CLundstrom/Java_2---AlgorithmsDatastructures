package cl222ae_assign3.NorseGods;

/**
 * NorseGod.java
 *
 * @Author: Christoffer
 * @Date: 28/02/2019
 *
 * Defines the properties of a God.
 */
public class NorseGod {

    private String name;
    private String race;
    private String desc;


    public NorseGod(){

    }

    public NorseGod(String name, String race, String desc){
        this.name = name;
        this.race = race;
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public String getName() {
        return name;
    }

    public String getRace() {
        return race;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
