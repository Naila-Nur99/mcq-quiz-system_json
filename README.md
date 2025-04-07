# MCQ Quiz System- JSON

## Project Overview

This is a simple Java-based quiz system where an **admin** can add MCQ questions to a quiz bank, and a **student** can log in to take a quiz of 10 random questions. The system evaluates answers and provides a final score with feedback.

## Technology Used

- **Java (JDK 17)**
- **IntelliJ IDEA**
- **Gradle**

## Features

- **Admin Panel:**
  - Admin can log in with predefined credentials.
  - Admin can add multiple MCQs with 4 options and an answer key into the quiz bank (`quiz.json`).
  - Admin can continuously add questions until they choose to quit by pressing 'q'.
  
- **Student Panel:**
  - Students can log in with predefined credentials.
  - The system generates 10 random questions from the quiz bank for the student to answer.
  - After attempting all the questions, the student receives a score based on correct answers.
  - Score is categorized as follows:
    - **Excellent:** 8 or more marks
    - **Good:** 5 to 7 marks
    - **Very Poor:** 2 to 4 marks
    - **Failed:** Less than 2 marks

## How to Run

- Clone this repository.
- Load the project in IntelliJ IDEA.
- Make sure JDK 17 and Gradle are properly configured.
- Execute the project.
## Projects execution video:
- **Video of Login As Admin:** https://drive.google.com/file/d/1f3rTBZEhhEb3QgoMFd5UR_AUApc-BTm0/view?usp=sharing
- **Video of Login As Student:** https://drive.google.com/file/d/1hBg8QsiF_eWgDYpPr1iMSxdWcnfNk0zV/view?usp=sharing
  
  

