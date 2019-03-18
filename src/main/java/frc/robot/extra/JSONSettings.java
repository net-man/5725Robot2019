package frc.robot.extra;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

import com.google.gson.*;

import edu.wpi.first.wpilibj.Filesystem;

public class JSONSettings {
    public static Gson GetGson() {
        return new GsonBuilder().setPrettyPrinting().enableComplexMapKeySerialization().create();
    }

    // TODO: Test writing and reading to path.
    // If it doesn't work try adding '/home/lvuser/' in front.
    // ex. /home/lvuser/Output.txt.
    public static void Write(String path, String json) throws IOException {
        FileWriter writer;

            File file = new File(path);

            file.setWritable(true);
            file.createNewFile();

            writer = new FileWriter(file); 
            writer.write(json);
            writer.flush();
            writer.close();
    }

    public static String Read(String path) throws IOException {
        List<String> jsons = new ArrayList<String>();
        jsons = Files.readAllLines(Paths.get(path));
        
        String json = "";

        if(jsons != null) {
            for(int i = 0; i <= jsons.size()-1; i++) {
                json += jsons.get(i);
            }
        }

        return json;
    }

    public static void Serialize(String path, Object object) {
        Gson gson = GetGson();
        String json = gson.toJson(object);

        // JSONSettings.Write("/home/lvuser/" + path, json);
        // JSONSettings.Write("C:/Users/Nobody/Desktop/" + path + ".json", json);
        try {
            JSONSettings.Write("C:/work/Robotics/2019/5725Robot2019/deploy/" + path + ".json", json);
        } catch (IOException e) { e.printStackTrace(); }
    }

    public static <T> Object DeSerialize(String path, Class<T> type) {
        Gson gson = GetGson();
        String json = "";
        try {
            json = JSONSettings.Read("C:/work/Robotics/2019/5725Robot2019/deploy/" + path + ".json");
        } catch (IOException e) {e.printStackTrace(); }

        return gson.fromJson(json, type);
    }
}