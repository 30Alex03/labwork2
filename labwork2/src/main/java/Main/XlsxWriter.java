package Main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlsxWriter {

    public void write(Map<String, double[]> processedData, double[][] covMatrix, String fileName) throws FileNotFoundException, IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Вычисления");
        Row row = sheet.createRow(0);
        int numberOfNames = processedData.keySet().size();
        String[] names = processedData.keySet().toArray(new String[numberOfNames]);
        int numberOfParameters = processedData.get(names[0]).length;
        for (int i = 0; i < numberOfNames; i++) {
            row.createCell(i).setCellValue(names[i]);
        }
        for (int j = 0; j < numberOfParameters; j++) {
            row = sheet.createRow(j + 1);
            for (int i = 0; i < numberOfNames; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(processedData.get(names[i])[j]);
            }
        }
        XSSFSheet sheetForMatrix = workbook.createSheet("Матрица");
        for (int i = 0; i < covMatrix.length; i++) {
            Row roww = sheetForMatrix.createRow(i);
            for (int j = 0; j < covMatrix[i].length; j++) {
                Cell cell = roww.createCell(j);
                cell.setCellValue(covMatrix[i][j]);
            }
        }
        workbook.write(new FileOutputStream(fileName));
        workbook.close();
    }
}
