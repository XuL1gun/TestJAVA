package JSONFile;

import com.google.gson.reflect.TypeToken;
import org.example.Student;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class SetStudentsFromJSON extends DownLoadJSONFile{
    public Student[] setStudentsList(){
        String jsonFormat = this.downloadInformFromJSONFile();

        Type type = new TypeToken<Map<String, List<Object>>>(){}.getType();
        Map<String, List<Object>> informFromJson = gson.fromJson(jsonFormat, type);

        List<Object> studentList =  informFromJson.get("students");
        int countOfStudents = studentList.size();

        Student[] students = new Student[countOfStudents];

        for (int i = 0; i < countOfStudents; i++){
            students[i] = gson.fromJson(studentList.get(i).toString(), Student.class);
        }

        return students;
    }
}
