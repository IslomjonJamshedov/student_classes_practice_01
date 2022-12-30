import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        //COMPLETE THIS CLASS AFTER ALL THE OTHER CLASSES

        /*
        Write a code that asks user to if they would like join your classes
        If the answer is "Yes" from user,then ask user information; firstName, lastName, age, gender, class to join
        ***If user is age is not more than 20, do not allow them to join
        ***If user wants to join any other class except Math and Science, do not allow them to join

        REMEMBER - checkAge and checkClassName methods may throw exceptions. You have to handle them

        Keep asking users the question they would to like join until you have got 3 students overall
        Create MathStudent or ScienceStudent objects based on user's answer for the class they want to join
        Print a "Congratulations! You are registered for {className} class."

        Store all these 3 objects in a collection and print them

        EXPECTED OUTPUT OF THE PROGRAM:
        Print information of all 3 students
        Print how many students are MathStudent with message -> "Math students = {numberOfMathStudents}"
        Print how many students are ScienceStudent with message -> "Science students = {numberOfScienceStudents}"
         */

        ArrayList<Student> students = new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        int math = 0, science = 0;
        String join;
        do {
            System.out.println("\n" + UserQuestions.askToJoin);
            join = scan.next();

            if (join.toLowerCase().startsWith("y")) {
                System.out.println(UserQuestions.askFirstName);
                String firstName = scan.next();

                System.out.println(UserQuestions.askLastName);
                String lastName = scan.next();

                System.out.println(UserQuestions.askAge);
                int age = scan.nextInt();

                try {
                    Permission.checkAge(age);
                } catch (Exception e) {
                    System.out.println(age + " is not allowed!");
                    continue;


                }

                System.out.println(UserQuestions.askGender);
                String gender = scan.next();

                System.out.println(UserQuestions.askClassName);
                String classToJoin = scan.next();

                try {
                    Permission.checkClassName(classToJoin);

                } catch (Exception e) {
                    System.out.println(classToJoin + " is not allowed!");
                    continue;
                }

                System.out.println("Congratulations! You are registered for " + classToJoin + "class!");

                if (classToJoin.equalsIgnoreCase("math")) {
                    students.add(new MathStudent(firstName, lastName, age, gender, classToJoin));
                    math++;
                }
                else if (classToJoin.equalsIgnoreCase("science"))
                    students.add(new ScienceStudent(firstName, lastName, age, gender, classToJoin));
                science++;
            }


        } while (students.size() < 3);


        for (Student elements : students) {
            System.out.println( elements);

        }
        if (students.size() == 3) {
            System.out.println("Math students  " + math);
            System.out.println("Science students  " + science);

        }

        System.out.println("Added a change");

    }

}

