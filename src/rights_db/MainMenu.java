package rights_db;

import rights_db.services.InputService;
import rights_db.services.OrganizationsService;
import rights_db.services.PersonsService;
import rights_db.services.RightsService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.NoSuchElementException;

public class MainMenu {

    private final InputService inputService;
    private final PersonsService personsService;
    private final OrganizationsService organizationsService;
    private final RightsService rightsService;

    public MainMenu() {
        this.inputService = new InputService();
        this.personsService = new PersonsService();
        this.organizationsService = new OrganizationsService();
        this.rightsService = new RightsService();
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
                        System.out.println("Введите право из списка");
                        rightsService.printAllRightsData();
                        String right_type = inputService.getInputString();
                        int right_id = rightsService.getIdByRights(right_type);
                        personsService.addNewPersons(surname, name, patronimic, right_id);
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
                    case "5":
                        personsService.printAllPersonsData();
                        System.out.println("Введите id-номер физического лица");
                        int persons_id = inputService.getInputInt();
                        personsService.deletePersons(persons_id);
                        personsService.printAllPersonsData();
                        break;
                    case "6":
                        organizationsService.printAllOrganizationsData();
                        System.out.println("Введите id-номер организации");
                        int org_id = inputService.getInputInt();
                        organizationsService.deleteOrganizations(org_id);
                        organizationsService.printAllOrganizationsData();
                        break;
                    case "7":
                        System.out.println("Введите наименование права");
                        right_type = inputService.getInputString();
                        System.out.println("Введите дату начала права в формате ГГГГ-ММ-ДД");
                        start_date = inputService.getInputString();
                        if (start_date.equals("")) {
                            start_date = "2021-01-01";
                        }
                        System.out.println("Введите дату окончания права в формате ГГГГ-ММ-ДД");
                        String end_date = inputService.getInputString();
                        if (end_date.equals("")) {
                            end_date = "2021-01-01";
                            rightsService.addNewRights(right_type, start_date, end_date);
                        } else {
                            rightsService.addNewRights(right_type, start_date, end_date);
                        }
                        rightsService.printAllRightsData();
                        break;
                    case "8":
                        rightsService.printAllRightsData();
                        System.out.println("Введите id-номер записи права");
                        right_id = inputService.getInputInt();
                        rightsService.deleteRights(right_id);
                        rightsService.printAllRightsData();
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
