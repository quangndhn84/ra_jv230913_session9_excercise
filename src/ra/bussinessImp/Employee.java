package ra.bussinessImp;

import ra.bussiness.IEmployee;

import java.util.Scanner;

public class Employee implements IEmployee, Comparable<Employee> {
    private String id;
    private String name;
    private int year;
    private float rate;
    private float commission;
    private float salary;
    private boolean status;

    public Employee() {
    }

    public Employee(String id, String name, int year, float rate, float commission, float salary, boolean status) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.rate = rate;
        this.commission = commission;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getCommission() {
        return commission;
    }

    public void setCommission(float commission) {
        this.commission = commission;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên:");
        this.id = scanner.nextLine();
        System.out.println("Nhập vào tên nhân viên:");
        this.name = scanner.nextLine();
        System.out.println("Nhập vào năm sinh của nhân viên:");
        this.year = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào hệ số lương của nhân viên:");
        this.rate = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào hoa hồng của nhân viên:");
        this.commission = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập vào trạng thái nhân viên:");
        this.status = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("Mã NV: %s - Tên NV: %S - Năm sinh: %d\n", this.id, this.name, this.year);
        System.out.printf("Hệ số lương: %f - Hoa hồng: %f - Lương: %f - Trạng thái: %s\n",
                this.rate, this.commission, this.salary, this.status ? "Đang làm việc" : "Nghỉ việc");

    }

    public void calSalary() {
        this.salary = this.rate * BASIC_SALARY + this.commission;
    }

    @Override
    public int compareTo(Employee employee) {
        return (int) Math.ceil(this.salary - employee.getSalary());
    }
}
