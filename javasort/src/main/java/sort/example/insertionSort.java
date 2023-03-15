package sort.example;
import java.io.FileReader;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class insertionSort {
    public static void main(String[] args) {
        // Read and parse JSON file
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("C:/Users/felix/Desktop/sortJava/javasort/src/main/java/sort/example/cupcake_test_10.json"));
            JSONArray cupcakes = (JSONArray) obj;

            // Print unsorted cupcakes
            System.out.println("Unsorted cupcakes:");
            System.out.printf("%-10s%-20s\n", "number", "Name");
            for (int i = 0; i < cupcakes.size(); i++) {
                JSONObject cupcake = (JSONObject) cupcakes.get(i);
                long id = (long) cupcake.get("id");
                String name = (String) cupcake.get("name");
                System.out.printf("%-10d%-20s\n", id, name);
            }

            // Sort cupcakes based on name using insertion sort
            for (int i = 1; i < cupcakes.size(); i++) {
                JSONObject currentCupcake = (JSONObject) cupcakes.get(i);
                String currentName = (String) currentCupcake.get("name");
                int j = i - 1;
                while (j >= 0 && ((String) ((JSONObject) cupcakes.get(j)).get("name")).compareTo(currentName) > 0) {
                    cupcakes.set(j+1, cupcakes.get(j));
                    j--;
                }
                cupcakes.set(j+1, currentCupcake);
            }

            // Print sorted cupcakes
            System.out.println("\nSorted cupcakes:");
            System.out.printf("%-10s%-20s\n", "number", "Name");
            for (int i = 0; i < cupcakes.size(); i++) {
                JSONObject cupcake = (JSONObject) cupcakes.get(i);
                long id = (long) cupcake.get("id");
                String name = (String) cupcake.get("name");
                System.out.printf("%-10d%-20s\n", id, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
