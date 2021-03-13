package application;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.WorkerLevel;
import entity.Department;
import entity.HourContract;
import entity.Worker;

public class Program {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter department's name: ");
        String depName = input.nextLine();
        System.out.println("Enter worker data: ");
        System.out.println("Name: ");
        String workerName = input.nextLine();
        System.out.println("Level: ");
        String workerLevel = input.nextLine();
        System.out.println("Base salary: ");
        Double base_Salary = input.nextDouble();
        Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), base_Salary, new Department(depName));

        System.out.println("How many contracts does the worker have? ");
        int contract = input.nextInt();

        for(int i = 1; i <= contract; i++){
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            Date contractDate = sdf.parse(input.next());
            System.out.println("Value per hour: ");
            double valuePerHour2 = input.nextDouble();
            System.out.println("Worked hours: ");
            int hour = input.nextInt();
            HourContract contract2 = new HourContract(contractDate, valuePerHour2, hour);
            worker.addContract(contract2);
        }
        System.out.println();
        System.out.print("Enter the month and year to calculate income: (mm/yyyy) ");
        String monthAndYear = input.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for "+ monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));




        input.close();
    }
}
