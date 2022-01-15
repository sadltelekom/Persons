package persons.awacademy;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonApp {
    ArrayList<Person> persons = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public PersonApp(){
        Person steve = new Person("Steve Jobs","M",54);
        Person marie = new Person("Marie Curie","F",45);
        Person john = new Person("John Wayne","M",75);

        persons.add(steve);
        persons.add(marie);
        persons.add(john);


    }

    public void drawMenu() {
        System.out.println("------------Menu---------");
        System.out.println("1. Add person");
        System.out.println("2. Del person");
        System.out.printf("3. Show all persons: %d \n",Person.counter);
        System.out.println("4. Find person by name");
        System.out.println("5. Change person data");
        System.out.println("6. Exit app");
        System.out.print("Please choose: ");
        int choice = input.nextInt();
        input.nextLine();
        switch (choice) {
            case 1:
                addPerson();
                drawMenu();
                break;
            case 2:
                delPerson();
                drawMenu();
                break;
            case 3:
                showPersonsInfo();
                drawMenu();
                break;
            case 4:
                searchPerson();
                drawMenu();
                break;
            case 5:
                changePerson();
                drawMenu();
                break;
            case 6:
                System.exit(0);
            default:
                System.out.println("Not valid input");
                drawMenu();
                break;
        }
    }

    public void showPersonsInfo() {
        System.out.println();
        System.out.println("All Persons info:");
        for(Person person:persons){
            System.out.println(person.name + " is " + person.gender + " and "  + person.age + " years old.");
        }
        System.out.println("------------End----------");
        System.out.println();

    }

    public void addPerson() {
        System.out.println();
        persons.add(askForData());

    }

    public void delPerson() {
        if(Person.counter == 0) {
            System.out.println("First need to add persons again");
            drawMenu();
            return;
        }
        System.out.println("Delete by number");
        listPersons();
        System.out.print("Number to delete? ");
        int delete = input.nextInt();
        input.nextLine();
        persons.remove(delete-1);
        Person.counter--;
    }

    String askForName(){
        String name;
        int tries = 0;
        boolean failure = false;
        do {

            System.out.print("Persons name? ");
            name = input.nextLine();

            tries++;
            if(tries > 2) {
                System.out.println("You seem to be not serious.");
                failure = true;
                name = null;
                break;
            }
        } while (!Helper.isValidName(name));

        return name;
    }

    String askForGender() {
        int tries = 0;
        boolean failure = false;
        String gender;
        do {
            System.out.print("Persons gender? ");
            gender = input.nextLine();
            tries++;
            if(tries > 2) {
                System.out.println("You seem to be not serious.");
                failure = true;
                gender = null;
                break;
            }
        } while (!Helper.isValidGender(gender));

        return gender;
    }

    int askForAge() {
        int tries = 0;
        boolean failure = false;
        int age;
        do {
            System.out.print("Persons age? ");
            age = input.nextInt();
            input.nextLine();
            tries++;
            if(tries > 2) {
                System.out.println("You seem to be not serious.");
                failure = true;
                break;
            }
        } while (!Helper.isValidAge(age));
        return age;
    }

    Person askForData(){
        String name = askForName();
        if(name == null) {drawMenu(); return null;}

        String gender = askForGender();
        if(gender == null) {drawMenu(); return null;}

        int age = askForAge();
        if(age == 0) {drawMenu(); return null;}

        Person newPerson = new Person(name, gender, age);

        return newPerson;
    }

    public void searchPerson() {
        System.out.print("Which name to search for: ");
        String search = input.nextLine();
        for(Person person:persons) {
            if(person.name.toLowerCase().contains(search.toLowerCase())) {
                System.out.println("We have a match: " + person.name);
            }
        }
    }

    public void changePerson() {
        listPersons();
        System.out.print("Give number of person you want change data? ");
        int numberToChange = (input.nextInt() - 1);
        input.nextLine();
        System.out.println("What do you want to change?");
        System.out.println("1 Name");
        System.out.println("2 Gender");
        System.out.println("3 Age");
        System.out.print("Give number of what to change? ");
        int choice = input.nextInt();
        input.nextLine();
        Person personToChange = persons.get(numberToChange);
        switch (choice) {
            case 1:
                personToChange.setName(askForName());
                break;
            case 2:
                personToChange.setGender(askForGender());
                break;
            case 3:
                personToChange.setAge(askForAge());
                break;
            default:
                drawMenu();
                break;
        }
    }

    public void listPersons() {
        int counter = 1;

        for (Person person:persons) {
            System.out.printf("%d is %s\n",counter,person.name);
            counter++;
        }
    }
}
