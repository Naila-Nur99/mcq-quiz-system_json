package quizSystem;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Student {
    public void startStudentsWork() throws IOException, ParseException {
        String filePath = "./src/main/resources/quiz.json";
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(filePath));
        Random random = new Random();
        int marks = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the quiz! We will throw you 10 questions. Each MCQ mark is 1 and no negative marking. Are you ready? Press 's' to start or 'q' to quit.");
        String ready = scanner.next();
        if (!ready.equalsIgnoreCase("s")) {
            System.out.println("Quiz aborted.");
            return;
        }

        for (int i = 0; i < 10; i++) {
            int randomIndex = random.nextInt(jsonArray.size());
            JSONObject questionObj = (JSONObject) jsonArray.get(randomIndex);

            System.out.println("\n[Question " + (i + 1) + "] " + questionObj.get("question"));
            System.out.println("1. " + questionObj.get("option 1"));
            System.out.println("2. " + questionObj.get("option 2"));
            System.out.println("3. " + questionObj.get("option 3"));
            System.out.println("4. " + questionObj.get("option 4"));
            System.out.print("Your Answer: ");
            int answer = scanner.nextInt();

            int actualAnswer = ((Long) questionObj.get("answerkey")).intValue();
            if (answer == actualAnswer) {
                marks++;
            }
        }

        System.out.println("\nYour Score: " + marks + " out of 10");

        if (marks >= 8) {
            System.out.println("Excellent! You have got " + marks + " out of 10");
        } else if (marks >= 5) {
            System.out.println("Good. You have got " + marks + " out of 10");
        } else if (marks >= 2) {
            System.out.println("Very poor! You have got " + marks + " out of 10");
        } else {
            System.out.println("Very sorry you are failed. You have got " + marks + " out of 10");
        }

        System.out.println("\nWould you like to start again? Press 's' for start or 'q' for quit.");
        String again = scanner.next();
        if (again.equalsIgnoreCase("s")) {
            startStudentsWork();
        } else {
            System.out.println("Thank you for participating!");
        }
    }
}
