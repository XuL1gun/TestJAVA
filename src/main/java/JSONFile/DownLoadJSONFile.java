package JSONFile;

import JSONFile.DeserializerFiles.DisciplineDeserializer;
import JSONFile.DeserializerFiles.MarkDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.Discipline;
import org.example.Mark;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DownLoadJSONFile {
    private static GsonBuilder gb = new GsonBuilder();
    protected static Gson gson;
    protected String downloadInformFromJSONFile(){
        gb.registerTypeAdapter(Discipline.class, new DisciplineDeserializer());
        gb.registerTypeAdapter(Mark.class, new MarkDeserializer());
        gson = gb.create();


        String inputFileName = "src/main/file.json";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            StringBuilder jsonFormat = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonFormat.append(line).append("\n");
            }

            return jsonFormat.toString();

        } catch (IOException e) {
            System.out.println("Что-то не так с файлом");
        }

        return inputFileName;
    }
}
