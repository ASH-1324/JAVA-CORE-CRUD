package com.ash.controller;

import com.ash.dao.EmployeeDao;
import com.ash.services.EmployeeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {

        int input = 0;

        EmployeeDao employeeDao = new EmployeeService();

        Scanner scanner = new Scanner(System.in);

        System.out.println("WELCOME TO ASH'S CONSOLE BASE CRUD APPLICATION");

        while (true) {
            System.out.println("===========================================");
            System.out.println("press 1 for insert Employee details: ");
            System.out.println("press 2 for display all Employee details: ");
            System.out.println("press 3 for display employee detail by id: ");
            System.out.println("press 4 for update employee detail: ");
            System.out.println("press 5 for remove employee: ");
            System.out.println("press 6 for exit: ");
            System.out.println("===========================================");

            System.out.print("choose an option : ");
            try {

                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid option to perform operation.");
                scanner.nextLine(); // Clear the invalid input
            }

            switch (input) {
                case 1:
                    employeeDao.insertEmployee(scanner);
                    break;
                case 2:
                    employeeDao.getAllEmployeeDetails();
                    break;
                case 3:
                    employeeDao.getEmployeeById(scanner);
                    break;
                case 4:
                    employeeDao.updateEmployeeDetailById(scanner);
                    break;
                case 5:
                    employeeDao.removeEmployee(scanner);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("plz select a valid option!");
            }
        }
    }
}
