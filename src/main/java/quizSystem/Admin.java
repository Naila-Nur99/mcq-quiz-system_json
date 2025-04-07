package quizSystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Admin {

    public static void main(String[] args) throws IOException, ParseException {
        Admin admin = new Admin();
        admin.startAdminWork();
    }

    public void startAdminWork() throws IOException, ParseException {
        String filePath = "./src/main/resources/quiz.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray;

        try {
            jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));
        } catch (Exception e) {
            jsonArray = new JSONArray();
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome admin! Please create new questions in the question bank.");

        while (true) {
            JSONObject questionObj = new JSONObject();

            System.out.println("System:> Input your question " + (jsonArray.size() + 1));
            String question = scanner.nextLine();
            questionObj.put("question", question);

            for (int i = 1; i <= 4; i++) {
                System.out.print("Input option " + i + ": ");
                String option = scanner.nextLine();
                questionObj.put("option " + i, option);
            }

            int answerKey = 0;
            while (true) {
                System.out.print("What is the answer key? (Enter 1-4): ");
                try {
                    answerKey = Integer.parseInt(scanner.nextLine());
                    if (answerKey >= 1 && answerKey <= 4) break;
                    else System.out.println("Please enter a valid option between 1-4.");
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Try again.");
                }
            }
            questionObj.put("answerkey", answerKey);
            jsonArray.add(questionObj);

            FileWriter writer = new FileWriter(filePath);
            writer.write(jsonArray.toJSONString());
            writer.flush();
            writer.close();

            System.out.println("System:> Saved successfully! Do you want to add more questions? (press s for start and q for quit)");
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase("q")) break;
        }
    }
}
