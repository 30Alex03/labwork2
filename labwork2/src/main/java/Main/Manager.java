package Main;

import java.io.File;
import java.io.IOException;

public class Manager {

    private Storage storage = new Storage();

    public void Export(String fileName) throws IOException {
        storage.loadResults(fileName);
        System.out.println("Экспорт завершен!");
    }

    public void Import(String fileName, String sheetNameOrIndex, boolean isIndex) throws IOException {
        storage.loadData(fileName, sheetNameOrIndex, isIndex);
        System.out.println("Импорт завершен!");
    }

    public Storage getStorage() {
        return storage;
    }


}
