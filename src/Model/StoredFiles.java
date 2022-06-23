package Model;

import java.io.FileReader;
import java.io.FileWriter;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class StoredFiles {
    private JsonArray memory;
    private String storedFile;

    // constructor
    public StoredFiles(String storedFile) {
        this.storedFile = storedFile;
        this.memory = read();
    }

    // methods
    public JsonArray read() {
        JsonArray jsonArray = null;

        try (FileReader reader = new FileReader(storedFile)) {
            jsonArray = (JsonArray) JsonParser.parseReader(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }

    public int search(String key, String value) {
        // search by username
        // key = un|ps|email; value = "mrteo"
        int index = -1;
        String username = null;
        for (int i = 0; i < memory.size(); i++) {
            // lấy tt tài khoản dưới dạng object
            JsonObject jsonObject = memory.get(i).getAsJsonObject();
            username = jsonObject.get(key).getAsString();

            if (value.equals(username)) {
                index = i;
                break;
            }
        }
        return index;
    }

    // add to memory
    public void update(String username, Integer password, String tel, String role, String address) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("un", username);
        jsonObject.addProperty("ps", password);
        jsonObject.addProperty("tel", tel);
        jsonObject.addProperty("role", role);
        jsonObject.addProperty("address", address);

        memory.add(jsonObject);
    }

    public void write() {
        Gson gson = new Gson();
        try (FileWriter writer = new FileWriter(storedFile)) {
            gson.toJson(memory, writer);
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public JsonArray getAll() {
        return this.memory;
    }
}
