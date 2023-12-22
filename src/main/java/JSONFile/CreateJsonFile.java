package JSONFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.poi.ss.formula.functions.T;
import org.example.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public final class CreateJsonFile {

    public static void createJsonFile(Student[] students, Teacher[] teachers) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Map<String, List<?>> informForJson = new HashMap<>();
        informForJson.put("students", new ArrayList<>(Arrays.asList(students)));
        informForJson.put("teachers",  new ArrayList<>(Arrays.asList(teachers)));

        String result = gson.toJson(informForJson);

        String outputFileName = "src/main/file.json";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            writer.write(result);
        } catch (IOException e) {
            System.out.println("Вывод в файл некорректный");
        }
    }
}
