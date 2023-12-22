package JSONFile.DeserializerFiles;

import com.google.gson.*;
import org.example.Mark;
import org.example.RatingReference;

import java.lang.reflect.Type;

public class MarkDeserializer implements JsonDeserializer<Mark> {
    /** Constructor */
    public MarkDeserializer() {}

    @Override
    public Mark deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject jObject = json.getAsJsonObject();
        final String mark = jObject.get("ratingReference").getAsString();

        switch (mark){
            case "GREATE" -> {
                return new Mark(RatingReference.GREATE);
            } case "GOOD" -> {
                return new Mark(RatingReference.GOOD);
            } case "SATISFACTORY" -> {
                return new Mark(RatingReference.SATISFACTORY);
            } case "UNSATISFACTORY" -> {
                return new Mark(RatingReference.UNSATISFACTORY);
            } default -> {
                return new Mark(RatingReference.ABSENCE);
            }
        }
    }
}
