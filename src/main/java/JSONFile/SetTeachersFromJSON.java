package JSONFile;

import com.google.gson.reflect.TypeToken;
import org.example.Teacher;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class SetTeachersFromJSON extends DownLoadJSONFile{
    public Teacher[] setTeachersList(){
        String jsonFormat = this.downloadInformFromJSONFile();

        Type type = new TypeToken<Map<String, List<Object>>>(){}.getType();
        Map<String, List<Object>> informFromJson = gson.fromJson(jsonFormat, type);

        List<Object> teacherList =  informFromJson.get("teachers");
        int countOfTeachers = teacherList.size();

        Teacher[] teachers = new Teacher[countOfTeachers];

        for (int i = 0; i < countOfTeachers; i++){
            teachers[i] = gson.fromJson(teacherList.get(i).toString(), Teacher.class);
        }

        return teachers;
    }
}
