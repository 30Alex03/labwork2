package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxReader {

    public Map<String, double[]> read(String fileName, String sheetNameorIndex, boolean isIndex) throws FileNotFoundException, IOException {
        Map<String, double[]> excelData = new HashMap<>();
        Map<String, List<Double>> data = new HashMap<>();
        XSSFWorkbook myBook = new XSSFWorkbook(new FileInputStream(fileName));
        XSSFSheet sheet;
        if (isIndex == true) {
            int index = Integer.parseInt(sheetNameorIndex.trim()) - 1; 
            int numberOfSheets = myBook.getNumberOfSheets();
            if (index  <= numberOfSheets && index >= 0) {
                sheet = myBook.getSheetAt(index);
            } else {
                throw new IllegalArgumentException();
            }
        } else {
            sheet = myBook.getSheet(sheetNameorIndex.trim());
        }
        Row headerRow = sheet.getRow(0);
        for (Cell cell : headerRow) {
            data.put(cell.getStringCellValue(), new ArrayList<>());
        }
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            int columnindex = 0;
            for (String key : data.keySet()) {
                Cell cell = row.getCell(columnindex);
                data.get(key).add(cell.getNumericCellValue());
                columnindex++;
            }
        }
        for (Map.Entry<String, List<Double>> entry : data.entrySet()) {
            double[] values = new double[entry.getValue().size()];
            for (int i = 0; i < entry.getValue().size(); i++) {
                values[i] = entry.getValue().get(i);
            }
            excelData.put(entry.getKey(), values);
        }
        return excelData;
    }
}