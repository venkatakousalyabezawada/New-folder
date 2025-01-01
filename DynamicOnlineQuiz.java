import java.util.*;

public class DynamicOnlineQuiz {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Question> questions = new ArrayList<>();
        questions.add(new Question("What is the capital of France?", new String[]{"Berlin", "Madrid", "Paris", "Rome"}, "3"));
        questions.add(new Question("Who wrote 'Hamlet'?", new String[]{"Charles Dickens", "William Shakespeare", "J.K. Rowling", "Jane Austen"}, "2"));
        questions.add(new Question("What is 5 + 3?", new String[]{"5", "8", "10", "15"}, "2"));

        int score = 0;

        System.out.println("Welcome to the Dynamic Quiz!");
        System.out.println("Answer the following questions:\n");

        for (Question q : questions) {
            System.out.println(q.getQuestion());
            String[] options = q.getOptions();
            for (int i = 0; i < options.length; i++) {
                System.out.println((i + 1) + ". " + options[i]);
            }

            System.out.print("Enter your answer (1-4): ");
            String answer = scanner.nextLine();

            if (answer.equals(q.getCorrectAnswer())) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong! The correct answer is " + q.getCorrectAnswer());
            }
            System.out.println();
        }

        System.out.println("Quiz Finished! Your score: " + score + "/" + questions.size());
        scanner.close();
    }
    static class Question {
        private String question;
        private String[] options;
        private String correctAnswer;

        public Question(String question, String[] options, String correctAnswer) {
            this.question = question;
            this.options = options;
            this.correctAnswer = correctAnswer;
        }

        public String getQuestion() {
            return question;
        }

        public String[] getOptions() {
            return options;
        }

        public String getCorrectAnswer() {
            return correctAnswer;
        }
    }
}
