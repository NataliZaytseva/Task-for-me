package ua.natali.t03;

/**
 * Created by natali on 08.10.14.
 */
public class Salaries {

    private int id;
    private String month;
    private double money;

    public int getId() {
        return id;
    }

    public String getMonth() {
        return month;
    }

    public double getMoney() {
        return money;
    }

    public Salaries(int id, String month, double money) {
        this.id = id;
        this.month = month;
        this.money = money;
    }

    @Override
    public String toString() {
        return "id= " + id + ", month= " + month + ", money= " + money;
    }
}

