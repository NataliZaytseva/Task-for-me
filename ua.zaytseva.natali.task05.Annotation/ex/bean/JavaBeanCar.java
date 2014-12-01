package bean;

import annotation.DefaultField;
import annotation.Marker;

/**
 * Created by Natali on 27.11.2014.
 */
public class JavaBeanCar {
    
    @DefaultField(name = "Ferrari")
    private String name;
    @Marker
    private String owner;
    @Marker
    private int doorCount;
    private int age = 1967;
    private double engineValue;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getDoorCount() {
        return doorCount;
    }

    public void setDoorCount(int doorCount) {
        this.doorCount = doorCount;
    }

    public void setDoorCount(int ghj, double engineValue) {
        this.age = ghj;
        this.engineValue = engineValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "name=" + name + ", owner= " + owner + ", age= " + age +", doorCount= " + doorCount + ", engineValue= " + engineValue ;
    }
}
