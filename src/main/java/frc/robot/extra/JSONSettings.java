package frc.robot.extra;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.*;

import edu.wpi.first.wpilibj.Filesystem;

public class JSONSettings {
    private static Gson gson;

    public JSONSettings() {
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    // TODO: Test writing and reading to path.
    // If it doesn't work try adding '/home/lvuser/' in front.
    // ex. /home/lvuser/Output.txt.
    public static void Write(String path, String json) {
        FileWriter writer;
        try {
            writer = new FileWriter(new File(path)); 
            writer.write(json);
            writer.flush();
            writer.close();
        }
        catch(Exception e) { System.out.println("Can't write to file path. (" + path + ") \n exeption:" + e.getMessage()); }
    }

    public static String Read(String path) {
        List<String> jsons = new ArrayList<String>();
        try { jsons = Files.readAllLines(Paths.get(path)); }
        catch(Exception e) { System.out.println("Can't read file of path. (" + path + ") \n exeption:" + e.getMessage()); }
        
        String json = "";

        if(jsons != null) {
            for(int i = 0; i <= jsons.size()-1; i++) {
                json += jsons.get(i);
            }
        }

        return json;
    }

    public static void Serialize(String path, Object object) {
        String json = gson.toJson(object);

        // JSONSettings.Write("/home/lvuser/" + path, json);
        // JSONSettings.Write(Filesystem.getDeployDirectory() + "/" + path + ".json", json);        
        JSONSettings.Write("C:/Users/Nobody/Desktop/" + path + ".json", json);
    }

    public static <T> Object DeSerialize(String path, Class<T> type) {
        String json = JSONSettings.Read("C:/Users/Nobody/Desktop/" + path + ".json");

        return gson.fromJson(json, type);
    }
}