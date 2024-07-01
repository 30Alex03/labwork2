package Main;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Storage {

    private Map<String, double[]> data = new HashMap<>();
    private Map<String, double[]> processedData = new HashMap<>();

    public void loadData(String filename, String sheetNameorIndex, boolean isIndex) throws IOException {
        XlsxReader reader = new XlsxReader();
        data = reader.read(filename, sheetNameorIndex, isIndex);
    }

    public void loadResults(String fileName) throws IOException {
        XlsxWriter writer = new XlsxWriter();
        processedData = Calculator.getCalculations(data);
        writer.write(processedData, Calculator.CovMatrix(data), fileName);
        
    }

    public Map<String, double[]> getData() {
        return data;
    }
}

