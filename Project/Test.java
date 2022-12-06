package Project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

public class Test {

    /**
     *  Printing menu with options to choose by user
     * @param options Array with options
     */

    public static void printMenu(String[] options){
        for (String option : options){
            System.out.println(option);
        }
        System.out.print("Виберіть опцію : ");
    }


    /**
     * Options of controller to choose
     */
    private static final String[] options = {"1- Do query",
            "2 - Show user's permissions",
            "3 - Exit"
    };


    /**
     * Represents tests for remote sql tool
     * with options to manual input and from file.
     * For file input output  was directed to file and print to console
     * For manual only to console
     * @param  fileName Path of file of test data
     */

    public static void testSQL(String fileName) throws Exception {
        String query;
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the mode of providing data: ");
        System.out.println("1 - for manual input");
        System.out.println("2 - for file input");
        int mode = sc.nextInt();
        while(mode != 1 && mode != 2){
            System.out.println("Choose the correct mode of providing data: ");
            System.out.println("1 - for manual input");
            System.out.println("2 - for file input");
            mode = sc.nextInt();
        }
        PrintStream standard = System.out;
        if(mode == 2){
            try{
                Path path = Paths.get(fileName);
                List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
                RemoteDBConnection remoteDBConnection = new RemoteDBConnection(allLines.get(0), allLines.get(1),
                        allLines.get(2), allLines.get(3));
                PrintStream out = new PrintStream(new FileOutputStream("src/Project/output.txt"));
                System.setOut(out);
                for(int i = 4; i < allLines.size() - 1; i++){
                    query = allLines.get(i);
                    System.setOut(out);
                    if(query.split("\\s+")[0].equalsIgnoreCase("select") ||
                        query.split("\\s+")[0].equalsIgnoreCase("show")){
                    ResultSet resultSet = remoteDBConnection.executeSelectQuery(query);
                    TablePrinter.printResultSet(resultSet);
                    }else{
                        remoteDBConnection.executeUpdateStatement(query);
                    }
                }
                System.setOut(standard);
                Path pathOutput = Paths.get("src/Project/output.txt");
                List<String> output = Files.readAllLines(pathOutput, StandardCharsets.UTF_8);
                for(String line : output){
                    System.out.println(line);
                }
                remoteDBConnection.getConnection().close();

            }catch (IOException e){
                System.out.println(e.getMessage());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        if(mode == 1){
            String host, port, username, password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть хост: ");
        host = scanner.nextLine();
        System.out.println("Введіть порт: ");
        port = scanner.nextLine();
        System.out.println("Введіть нікнейм користувача: ");
        username = scanner.nextLine();
        System.out.println("Введіть пароль користувача");
        password = scanner.nextLine();
        RemoteDBConnection remoteDBConnection = new RemoteDBConnection(host, port, username, password);
        if(remoteDBConnection.getConnection() != null){
            int option = 1;
            while (option != 3){
                printMenu(options);
                option = Integer.parseInt(scanner.nextLine());
                switch (option){
                    case 1: System.out.println("Введіть запит");
                            query = scanner.nextLine();
                            if(query.split("\\s+")[0].equalsIgnoreCase("select") ||
                            query.split("\\s+")[0].equalsIgnoreCase("show")){
                                ResultSet resultSet = remoteDBConnection.executeSelectQuery(query);
                                TablePrinter.printResultSet(resultSet);
                            }else{
                                remoteDBConnection.executeUpdateStatement(query);
                            };
                            break;
                    case 2:  remoteDBConnection.showGrants();
                            break;
                    case 3:
                        break;
                    }
                 }

            }
        }
    }

    /**
     * Represents tests for report generator using sql tool
     * with options to  input from file.
     * For file input output  was directed to file and print to console
     * @param  fileName Path of file of test data
     */
    public static void testReport(String fileName){
        PrintStream standard = System.out;
        try{
            Path path = Paths.get(fileName);
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            RemoteDBConnection remoteDBConnection = new RemoteDBConnection(allLines.get(0), allLines.get(1),
                    allLines.get(2), allLines.get(3));
            PrintStream out = new PrintStream(new FileOutputStream("src/Project/output2.txt"));
            System.setOut(out);
            GeneratorReport.generateReport(allLines.get(0), allLines.get(1), allLines.get(2), allLines.get(3));
            System.setOut(standard);
            Path pathOutput = Paths.get("src/Project/output2.txt");
            List<String> output = Files.readAllLines(pathOutput, StandardCharsets.UTF_8);
            for(String line : output){
                System.out.println(line);
            }
            remoteDBConnection.getConnection().close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Represents tests for restricted actions of user in sql tool
     * with options to  input from file.
     * For file input output  was directed to file and print to console
     * NOTE: User's permission was restricted in sql server
     * @param  fileName Path of file of test data
     */
    public static void testAdmin(String fileName){
        String query;
        PrintStream standard = System.out;
        try{
            Path path = Paths.get(fileName);
            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            RemoteDBConnection remoteDBConnection = new RemoteDBConnection(allLines.get(0), allLines.get(1),
                    allLines.get(2), allLines.get(3));
            PrintStream out = new PrintStream(new FileOutputStream("src/Project/output3.txt"));
            System.setOut(out);
            for(int i = 4; i < allLines.size(); i++){
            query = allLines.get(i);
            System.setOut(out);
            if(query.split("\\s+")[0].equalsIgnoreCase("select") ||
                    query.split("\\s+")[0].equalsIgnoreCase("show")){
                ResultSet resultSet = remoteDBConnection.executeSelectQuery(query);
                TablePrinter.printResultSet(resultSet);
            }else{
                remoteDBConnection.executeUpdateStatement(query);
            }}
            System.setOut(standard);
            Path pathOutput = Paths.get("src/Project/output3.txt");
            List<String> output = Files.readAllLines(pathOutput, StandardCharsets.UTF_8);
            for(String line : output){
                System.out.println(line);
            }
            remoteDBConnection.getConnection().close();

        }catch (IOException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
