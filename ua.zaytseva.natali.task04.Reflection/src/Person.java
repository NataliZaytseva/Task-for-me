/**
 * Created by Natali on 19.11.2014.
 */
public class Person {
    private int age = 0;
    private String gender = "N/A";
    private String Name = "Unknown";
    private String Something;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public void setAge(int age, String Name) {
//        this.age = age;
//        this.Name = Name;
//    }

    public void setAge(double age) {
        this.age = (int) age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSomething() {
        return Something;
    }

    @Override
    public String toString() {
        return "Person: " + "age = " + age + ", gender = " + gender + ", Name = " + Name;
    }
}
