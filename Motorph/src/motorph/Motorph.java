/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package motorph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Motorph {

    public static void main(String[] args) {
        String Path = "C:\\Users\\User\\Documents\\NetBeansProjects\\Motorph\\src\\motorph\\Employee Data.xlsx - Employee Details.csv";

        try {
            BufferedReader br = new BufferedReader(new FileReader(Path));
            boolean pastFirstLine = false;
            String row;
            ArrayList<Employee> employees = new ArrayList<>();

            while ((row = br.readLine()) != null) {
                if (!pastFirstLine) {
                    pastFirstLine = true;
                    continue;
                }

                System.out.println("Row: " + row);

                String[] rowData = row.split(",", -1); // Split row line by commas

                ArrayList<String> processedRow = new ArrayList<>();

                String concatenator = "";
                boolean concatOpen = false;

                for (int index = 0; index < rowData.length; index++) {
                    if (!rowData[index].contains("\"") && !concatOpen) {
                        processedRow.add(rowData[index]);
                    } else {
                        if (rowData[index].charAt(0) == '\"' && !concatOpen) {
                            concatOpen = true;
                        } else if (rowData[index].charAt(rowData[index].length() - 1) == '\"' && concatOpen) {
                            concatOpen = false;
                            concatenator += rowData[index].replace("\"", "");
                            processedRow.add(concatenator);
                            concatenator = "";
                        } else {
                            concatenator += rowData[index];
                        }
                    }
                }

                String employeeNumber = processedRow.get(0);
                String lastName = processedRow.get(1);
                String firstName = processedRow.get(2);

                for (int index2 = 0; index2 < processedRow.size(); index2++) {
                    System.out.println("Column data " + index2 + ": " + processedRow.get(index2));
                }

                Employee newEmployee = new Employee(employeeNumber, lastName, firstName, Float.parseFloat(processedRow.get(18)));
                employees.add(newEmployee);
            }

            if (!employees.isEmpty()) {
                Employee firstEmployee = employees.get(0);
                System.out.println("First employee: " + firstEmployee.getFirst_name()+ " " + firstEmployee.getLast_name());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No file found");
        } catch (IOException ex) {
            System.out.println("Cannot read lines from CSV file");
        }
    }
}
