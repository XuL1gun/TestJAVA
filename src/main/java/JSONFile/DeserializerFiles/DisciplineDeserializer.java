package JSONFile.DeserializerFiles;

import com.google.gson.*;
import org.example.Discipline;

import java.lang.reflect.Type;

public class DisciplineDeserializer implements JsonDeserializer<Discipline> {
    /** Constructor */
    public DisciplineDeserializer() {}

    @Override
    public Discipline deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jObject = json.getAsJsonObject();
        final String name = jObject.get("name").getAsString();
        final int semester = jObject.get("semester").getAsInt();

        return new Discipline(name, semester);
    }
}
