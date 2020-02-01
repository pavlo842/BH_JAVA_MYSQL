package rights_db;

import rights_db.services.InputService;
import rights_db.services.OrganizationsService;
import rights_db.services.PersonsService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class MainMenu {

    private final InputService inputService;
    private final PersonsService personsService;
    private final OrganizationsService organizationsService;

    public MainMenu() {
        this.inputService = new InputService();
        this.personsService = new PersonsService();
        this.organizationsService = new OrganizationsService();
    }

    public void start() {
        String mainInput = "";
        do {
            try {
                inputService.printMainMenu();
                mainInput = inputService.getInputString();
                switch (mainInput) {
                    case "1":
                        System.out.println("Введите фамилию");
                        String surname = inputService.getInputString();
                        System.out.println("Введите имя");
                        String name = inputService.getInputString();
                        System.out.println("Введите отчество");
                        String patronimic = inputService.getInputString();
                        personsService.addNewPersons(surname, name, patronimic);
                        personsService.printAllPersonsData();
                        break;
                    case "2":
                        System.out.println("Введите название организации");
                        String name_org = inputService.getInputString();
                        System.out.println("Введите УНП (9 цифр)");
                        int utn = inputService.getInputInt();
                        System.out.println("Введите дату регистрации в формате ГГГГ-ММ-ДД");
                        String start_date = inputService.getInputString();
                        organizationsService.addNewOrganizations(name_org, utn, start_date);
                        organizationsService.printAllOrganizationsData();
                        break;
                    case "3":
                        personsService.printAllPersonsData();
                        break;
                    case "4":
                        organizationsService.printAllOrganizationsData();
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
