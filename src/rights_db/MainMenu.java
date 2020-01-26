package rights_db;

import rights_db.services.InputService;
import rights_db.services.PersonsService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class MainMenu {

    private final InputService inputService;
    private final PersonsService personsService;

    public MainMenu() {
        this.inputService = new InputService();
        this.personsService = new PersonsService();
    }

    public void start() {
        String mainInput = "";
        do {
            try {
                inputService.printMainMenu();
                mainInput = inputService.getInputString();
                switch (mainInput) {
                    case "1":
                        System.out.println("Enter surname");
                        String surname = inputService.getInputString();
                        System.out.println("Enter name");
                        String name = inputService.getInputString();
                        System.out.println("Enter patronimic");
                        String patronimic = inputService.getInputString();
                        personsService.addNewPersons(surname, name, patronimic);
                        break;
                    case "2":
                        personsService.printAllPersonsData();
                        break;
                    case "3":
                        break;
                    case "e":
                        break;
                    default:
                        System.out.println("Wrong input");
                }
            } catch (NoSuchElementException e) {
                System.out.println("There is no such entity: " + e.getMessage());
            } catch (IOException | NumberFormatException | SQLException e) {
                System.err.println("Error: " + e.getMessage());
            }
        } while (!mainInput.equals("e"));
    }
}
