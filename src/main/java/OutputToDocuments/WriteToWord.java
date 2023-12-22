package OutputToDocuments;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

public class WriteToWord implements WriteToDocument{

    @Override
    public void writeToDocument(String text) {
        String fileName = "src\\main\\hello.docx";

        try (XWPFDocument doc = new XWPFDocument()) {

            String[] str = text.split("\n");

            for (String answer: str) {
                XWPFParagraph p1 = doc.createParagraph();
                p1.setAlignment(ParagraphAlignment.BOTH);

                XWPFRun r1 = p1.createRun();
                r1.setFontSize(14);
                r1.setFontFamily("New Roman");
                r1.setText(answer);

                try (FileOutputStream out = new FileOutputStream(fileName)) {
                    doc.write(out);
                }

            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
