package net.keitaito.medipro.save;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

public class SaveManager {
    private static final String fileName = Paths.get("").toAbsolutePath().toString() + "/save/saves.txt";

    public static void save(SaveData data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SaveData load(String filePath) {
        try (FileInputStream fis = new FileInputStream(filePath);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            SaveData data = (SaveData) ois.readObject();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
