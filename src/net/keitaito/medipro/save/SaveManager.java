package net.keitaito.medipro.save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;

public final class SaveManager {

    private static final String fileName = Paths.get("").toAbsolutePath().normalize().toString() + "/saves/risapro.dat";

    public static void save(SaveData data) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(data);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SaveData load() {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            SaveData data = (SaveData) ois.readObject();
            return data;
        } catch (IOException | ClassNotFoundException e) {
            SaveData data = new SaveData();
            return data;
        }
    }

}
