package rights_db.persons;

import rights_db.rights.Rights;

public class Persons {
    private int persons_id;
    private String surname;
    private int age;
    private String name;
    private String patronimic;

    private Rights right_type;

    public Persons(int persons_id, String surname, int age, String name, String patronimic, Rights right_type) {
        this.persons_id = persons_id;
        this.surname = surname;
        this.age = age;
        this.name = name;
        this.patronimic = patronimic;
        this.right_type = right_type;
    }

    public int getPersonsId() {
        return persons_id;
    }

    public void setPersonsId(int persons_id) {
        this.persons_id = persons_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronimic() {
        return patronimic;
    }

    public void setPatronimic(String patronimic) {
        this.patronimic = patronimic;
    }

    public Rights getRight_type() {
        return right_type;
    }

    public void setRight_type(Rights right_type) {
        this.right_type = right_type;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "persons_id = " + persons_id +
                ", surname = '" + surname + '\'' +
                ", age = " + age +
                ", name = '" + name + '\'' +
                ", patronimic = '" + patronimic + '\'' +
                ", RIGHTS: " + right_type +
                '}';
    }

}
