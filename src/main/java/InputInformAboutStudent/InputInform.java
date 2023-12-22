package InputInformAboutStudent;

import java.util.Scanner;

public final class InputInform {
    public static final Scanner scanner = new Scanner(System.in);

    public static String getInform(){
        return scanner.nextLine();
    }
}
