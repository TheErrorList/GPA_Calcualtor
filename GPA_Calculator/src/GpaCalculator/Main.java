package GpaCalculator;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scan = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/GPA_Calculator", "se2019015", "SE015@pavi");

        String name;
        int durationYear;
        int menuChoice;
        System.out.println("----GPA Calculator----\n");
        System.out.println("Enter your name: ");
        name = scan.nextLine();
        System.out.println("Course duration(in years): ");
        durationYear = scan.nextInt();
        System.out.println("\nCongratulation! Registration was completed.");

        System.out.println("\n\n----GPA Calculator----\n");
        System.out.println("Hello " + name + ", welcome back!\n");
        System.out.println("----Menu----");
        System.out.println("1. view results");
        System.out.println("2. Add results");
        System.out.println("3. Export results");
        System.out.println("4. Clear results");
        System.out.println("5. Exit\n");
        System.out.println("Enter your choice: ");
        menuChoice = scan.nextInt();

        switch (menuChoice) {
            case 1: {
                double finalGpa;

                System.out.println("----View Result----");
                System.out.println("Current Gpa: ");

                System.out.print("No. of subjects: ");
                Statement statement1 = connection.createStatement();
                String query = "select distinct count(*) from Result_Table;";
                ResultSet resultSet1 = statement1.executeQuery(query);
                while (resultSet1.next()) {
                    System.out.println(resultSet1.getInt(1));
                }
                statement1.close();

                System.out.print("Total credits: ");
                Statement statement2 = connection.createStatement();
                String query2 = "select sum(Credits) from Result_Table;";
                ResultSet resultSet2 = statement2.executeQuery(query2);
                while (resultSet2.next()) {
                    System.out.println(resultSet2.getInt(1));
                }
                statement2.close();


                int yearChoice;
                System.out.println("\nTo view records: ");
                for (int j = 1; j <= durationYear; j++) {
                    System.out.println(j + ". Year " + j);
                }

                System.out.println("\n0. Back\n");
                System.out.println("Enter your choice: ");
                yearChoice = scan.nextInt();

                switch (yearChoice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("error choice");
                }

                System.out.println("----Year " + yearChoice + "----");
                int i = 0, creTot = 0;
                char press;
                System.out.println(i + "\tCourse code - ");
                System.out.println("\tGrade - ");
                System.out.println("\tcredits - ");
                //creTot += credits;

                System.out.println("No of subjects: " + i);
                System.out.println("Total Credits: " + creTot);
                System.out.println("GPA for year: " + yearChoice + "\n");
                System.out.println("To delete records press d");
                System.out.println("To go back press 0\n");

                System.out.println("Enter your choice: ");
                press = scan.next().charAt(0);
                switch (press) {
                    case 'd':
                        System.out.println("delete ");
                        break;
                    case '0':
                        break;

                }

            }
            break;
            case 2: {
                int academicYear, credits;
                String grade, courseCode;
                char confirmKey;
                System.out.println("----Add Result----");
                System.out.println("Year(1,2,3,4): ");
                academicYear = scan.nextInt();
                scan.nextLine();
                System.out.println("Course code: ");
                courseCode = scan.nextLine();
                System.out.println("Grade: ");
                grade = scan.nextLine();
                System.out.println("Credits: ");
                credits = scan.nextInt();
                scan.nextLine();
                System.out.println("\nConfirm (y/n): ");
                confirmKey = scan.next().charAt(0);

                switch (confirmKey) {
                    case 'y': {
                        String query1 = "insert into Result_Table values(?,?,?,?);";
                        PreparedStatement preparedStatement = connection.prepareStatement(query1);
                        preparedStatement.setString(1, courseCode);
                        preparedStatement.setInt(2, academicYear);
                        preparedStatement.setString(3, grade);
                        preparedStatement.setInt(4, credits);

                        int count = preparedStatement.executeUpdate();
                        if (count == 1)
                            System.out.println("\nRecord was added!");
                        preparedStatement.close();
                    }

                    break;
                    case 'n':
                        System.exit(0);
                        break;

                }}
                break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:{
                    System.out.println("----clear data----");
                    char clearCho;
                    System.out.println("clear all data(y/n)");clearCho=scan.next().charAt(0);


                    switch(clearCho){
                        case 'y':
                            break;
                        case 'n':
                            break;}
                    char noCho;
                    System.out.println("confirm (y/n)");noCho=scan.next().charAt(0);


                    switch(noCho){
                        case 'y':
                            break;
                        case 'n':
                            break;}

                    }
                    break;

        }
    }
}