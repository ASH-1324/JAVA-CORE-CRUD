package com.ash.dao;

import java.util.Scanner;

public interface EmployeeDao {

    void insertEmployee(Scanner scanner);

    void getAllEmployeeDetails();

    void getEmployeeById(Scanner scanner);

    void updateEmployeeDetailById(Scanner scanner);

    void removeEmployee(Scanner scanner);
}
