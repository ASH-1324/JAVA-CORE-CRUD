package com.ash.services;

import com.ash.beans.Employee;
import com.ash.dao.EmployeeDao;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements EmployeeDao {

    List<Employee> list = new ArrayList<>();

    public void insertEmployee(Scanner scanner) {

        int id;
        String name;
        String email;
        double phoneNumber;

        Employee employee = new Employee();

        // Input for ID
        while (true) {
            try {
                System.out.print("Enter your id: ");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume the newline character
                employee.setId(id);
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer for the ID.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        // Input for name
        while (true) {
            System.out.print("Enter your name: ");
            name = scanner.nextLine().trim();
            employee.setName(name);
            if (name.isEmpty()) {
                System.out.println("You have not enter your name!");
                System.out.print("Enter your name: ");
                name = scanner.nextLine().trim();
                employee.setName(name);
                if (!name.isEmpty()) {
                    break;
                }
            } else {
                break;
            }
        }

        // Input for email
        while (true) {
            System.out.print("Enter your email: ");
            email = scanner.nextLine().trim();
            employee.setEmail(email);
            if (email.isEmpty()) {
                System.out.println("You have not enter your name!");
                System.out.print("Enter your email: ");
                email = scanner.nextLine().trim();
                employee.setEmail(email);
                if (!email.isEmpty()) {
                    break;
                }
            } else {
                break;
            }
        }
        // Input for phone number
        while (true) {
            try {
                System.out.print("Enter your phone number: ");
                phoneNumber = scanner.nextDouble();
                employee.setPhoneNumber(phoneNumber);
                break; // Exit loop if input is valid
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number for the phone number.");
                scanner.nextLine(); // Clear the invalid input
            }
        }

        list.add(employee);
        System.out.println("Employee added: " + employee);
    }

    public void getAllEmployeeDetails() {

        if (list.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("Employee Details:");
            for (Employee employee : list) {
                System.out.println("===========================================");
                System.out.println("Employee ID: " + employee.getId());
                System.out.println("Employee Name: " + employee.getName());
                System.out.println("Employee Email: " + employee.getEmail());
                System.out.println("Employee Phone Number: " + employee.getPhoneNumber());
            }
        }
    }

    public void getEmployeeById(Scanner scanner) {

        while (true) {
            System.out.print("Enter the employee ID to get details: ");
            try {
                int id = scanner.nextInt();

                // Search for the employee by ID
                if (list.isEmpty()) {
                    System.out.println("No data in list.");
                    return;
                } else {
                    for (Employee employee : list) {
                        if (employee.getId() == id) {
                            System.out.println("Employee ID: " + employee.getId());
                            System.out.println("Employee Name: " + employee.getName());
                            System.out.println("Employee Email: " + employee.getEmail());
                            System.out.println("Employee Phone Number: " + employee.getPhoneNumber());
                            return;
                        }
                    }
                    System.out.println("Employee with ID " + id + " not found.");
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid Integer for the Employee ID.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }

    public void updateEmployeeDetailById(Scanner scanner) {
        System.out.print("Enter the employee ID to update detail : ");

        try {
            int id = scanner.nextInt();
            scanner.nextLine();
            if (list.isEmpty()) {
                System.out.println("No data in list.");
//                return;
            } else {
                for (Employee employee : list) {
                    if (employee.getId() == id) {
                        while (true) {
                            try {
                                System.out.print("Enter your id: ");
                                id = scanner.nextInt();
                                scanner.nextLine(); // Consume the newline character
                                employee.setId(id);

                                break; // Exit loop if input is valid
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid integer for the ID.");
                                scanner.nextLine(); // Clear the invalid input
                            }
                        }

                        // Input for name
                        System.out.print("Enter your name: ");
                        String name = scanner.nextLine().trim();
                        employee.setName(name);

                        // Input for email
                        System.out.print("Enter your email: ");
                        String email = scanner.nextLine().trim();
                        employee.setEmail(email);

                        // Input for phone number
                        while (true) {
                            try {
                                System.out.print("Enter your phone number: ");
                                double phoneNumber = scanner.nextDouble();
                                employee.setPhoneNumber(phoneNumber);
                                break; // Exit loop if input is valid
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input. Please enter a valid number for the phone number.");
                                scanner.nextLine(); // Clear the invalid input
                            }
                        }

                        System.out.println("Employee details update: " + employee);
                    } else {
                        System.out.println("Employee with ID " + id + " not found.");
                    }
                }
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer for the Employee ID.");
            scanner.nextLine();
        }
    }

    public void removeEmployee(Scanner scanner) {
        while (true) {
            System.out.print("Enter the employee ID to remove employee: ");
            try {
                int id = scanner.nextInt();

                // Search for the employee by ID
                if (list.isEmpty()) {
                    System.out.println("No data in list.");
                    return;
                } else {
                    for (Employee employee : list) {
                        if (employee.getId() == id) {
                            list.remove(employee);
                            return;
                        }
                    }
                }
                System.out.println("Employee is Successfully remove.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid Integer for the Employee ID.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
    }
}
