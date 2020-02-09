package rights_db.persons;

public class Persons {
    private int persons_id;
    private String surname;
    private int age;
    private String name;
    private String patronimic;

    public Persons(int persons_id, String surname, int age, String name, String patronimic) {
        this.persons_id = persons_id;
        this.surname = surname;
        this.age = age;
        this.name = name;
        this.patronimic = patronimic;
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

    @Override
    public String toString() {
        return "Persons{" +
                "persons_id = " + persons_id +
                ", surname = '" + surname + '\'' +
                ", age = " + age +
                ", name = " + name +
                ", patronimic = " + patronimic +
                '}';
    }

}
