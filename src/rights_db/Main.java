package rights_db;

import rights_db.services.PersonsService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();

        mainMenu.start();
    }
}
