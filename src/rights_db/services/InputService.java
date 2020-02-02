package rights_db.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {

    private static final String MENU =
            "1. Добавить физическое лицо\n"
                    + "2. Добавить организацию\n"
                    + "3. Вывести на экран всех физических лиц\n"
                    + "4. Вывести на экран все организации\n"
                    + "5. Удалить физическое лицо\n"
                    + "6. Удалить организацию\n"
                    + "'e' Выйти из программы!\n";

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void printMainMenu() {
        System.out.println(MENU);
    }

    public String getInputString() throws IOException {
        return reader.readLine();
    }

    public int getInputInt() throws IOException, NumberFormatException {
        return Integer.parseInt(getInputString());
    }

}
