package OutputToDocuments;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class WriteToExel implements WriteToDocument{
    @Override
    public void writeToDocument(String text) {
        String fileName = "src\\main\\hello.xls";

        try (XSSFWorkbook workbook = new XSSFWorkbook()) {

            XSSFSheet sheet = workbook.createSheet("student Details");

            int rownum = 0;
            String[] str = text.split("\n");
            for (String line : str) {

                Row row = sheet.createRow(rownum++);
                int cellnum = 0;

                String[] colums = line.split("[-|]");
                for (String word: colums){
                    if (word.isEmpty())
                        continue;

                    Cell cell = row.createCell(cellnum++);
                    cell.setCellValue(word);
                }

            }

            try (FileOutputStream out = new FileOutputStream(fileName)) {
                workbook.write(out);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
