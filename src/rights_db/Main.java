package rights_db;

import rights_db.services.PersonsService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        PersonsService personsService = new PersonsService();

//        personsService.addNewPersons("Dobriy", "Igor", "Vitalievich");
        personsService.addNewPersons("Pishchalau", "Pavel", "Sergeevich");
    }
}
