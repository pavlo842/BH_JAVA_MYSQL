package rights_db.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputService {

    private static final String MENU =
            "1. add persons\n"
                    + "2. show all persons\n"
                    + "exit\n";

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
