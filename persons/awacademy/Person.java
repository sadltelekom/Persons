package persons.awacademy;

public class Person {
    String name;
    String gender;
    int age;
    static int counter = 0;

    public Person(String name, String gender, int age) {
        this.name = setName(name);
        this.gender = setGender(gender);
        this.age = age;
        counter++;
    }

    int compareAge(Person otherPerson){ // Instance Method
        return this.age - otherPerson.age;
    }

    public String setName(String name) {
       this.name = Helper.sanitizeName(name);
       return this.name;
    }

    public String setGender(String gender) {
        this.gender = gender.toUpperCase();
        return gender.toUpperCase();
    }

    public void setAge(int age) {
        this.age = age;
    }
}
