package ra.ra.presentation;

import ra.bussinessImp.Employee;

import java.util.*;

public class EmployeeManagement {
    static List<Employee> listEmps = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("**************MENU*******************");
            System.out.println("1. Nhập thông tin cho các nhân viên");
            System.out.println("2. Hiển thị thông tin nhân viên");
            System.out.println("3. Tính lương cho các nhân viên");
            System.out.println("4. Tìm kiếm nhân viên theo tên nhân viên");
            System.out.println("5. Cập nhật thông tin nhân viên");
            System.out.println("6. Xóa nhân viên theo mã nhân viên");
            System.out.println("7. Sắp xếp nhân viên theo lương tăng dần");
            System.out.println("8. Sắp xếp nhân viên theo tên giảm dần");
            System.out.println("9. Sắp xếp nhân viên theo năm sinh tăng dần");
            System.out.println("10. Thoát");
            System.out.print("Lưa chọn của bạn:");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    EmployeeManagement.inputListEmp(scanner);
                    break;
                case 2:
                    EmployeeManagement.dislayListEmp();
                    break;
                case 3:
                    EmployeeManagement.calListSalaryOfEmp();
                    break;
                case 4:
                    EmployeeManagement.findEmpByName(scanner);
                    break;
                case 5:
                    EmployeeManagement.updateEmployee(scanner);
                    break;
                case 6:
                    EmployeeManagement.deleteEmployee(scanner);
                    break;
                case 7:
                    Collections.sort(listEmps);
                    break;
                case 8:
                    EmployeeManagement.sortEmpByNameDESC();
                    break;
                case 9:
                    EmployeeManagement.sortEmpByYearASC();
                    break;
                case 10:
                    System.exit(0);
                default:
                    System.err.println("Vui lòng chọn từ 1-10");
            }
        } while (true);
    }

    public static void inputListEmp(Scanner scanner) {
        System.out.println("Nhập số nhân viên cần nhập thông tin:");
        int numberOfEmps = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEmps; i++) {
            //1. Khởi tạo đối tượng Emp cần nhập thông tin
            Employee empNew = new Employee();
            //2. Nhập thông tin nhân viên
            empNew.inputData(scanner);
            //3. add vào danh sách nhân viên
            listEmps.add(empNew);
        }
    }

    public static void dislayListEmp() {
        listEmps.forEach(employee -> employee.displayData());
    }

    public static void calListSalaryOfEmp() {
        listEmps.forEach(employee -> employee.calSalary());
    }

    public static void findEmpByName(Scanner scanner) {
        int cntEmp = 0;
        System.out.println("Nhập vào tên nhân viên cần tìm:");
        String nameSearch = scanner.nextLine();
        for (Employee employee : listEmps) {
            if (employee.getName().toLowerCase().contains(nameSearch.toLowerCase())) {
                employee.displayData();
                cntEmp++;
            }
        }
        if (cntEmp == 0) {
            System.err.println("Không có kết quả nào phù hợp với thông tin tìm kiếm");
        } else {
            System.out.printf("Có %d kết quả phù hợp với thông tin tìm kiếm\n", cntEmp);
        }
    }

    public static void updateEmployee(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên cần nhập thông tin:");
        String idUpdate = scanner.nextLine();
        int indexUpdate = findIndexEmpOfList(idUpdate);
        if (indexUpdate >= 0) {
            boolean isExist = true;
            do {
                System.out.println("1. Cập nhật tên nhân viên");
                System.out.println("2. Cập nhật năm sinh");
                System.out.println("3. Cập nhật hệ số lương");
                System.out.println("4. Cập nhật hoa hồng");
                System.out.println("5. Cập nhật trạng thái");
                System.out.println("6. Kết thúc cập nhật");
                System.out.print("Lựa chọn của bạn");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập vào tên nhân viên cần cập nhật:");
                        listEmps.get(indexUpdate).setName(scanner.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập vào năm sinh nhân viên cần cập nhật:");
                        listEmps.get(indexUpdate).setYear(Integer.parseInt(scanner.nextLine()));
                        break;
                    case 3:
                        System.out.println("Nhập vào hệ số lương cần cập nhật:");
                        listEmps.get(indexUpdate).setRate(Float.parseFloat(scanner.nextLine()));
                        listEmps.get(indexUpdate).calSalary();
                        break;
                    case 4:
                        System.out.println("Nhập vào hoa hồng cần cập nhật:");
                        listEmps.get(indexUpdate).setCommission(Float.parseFloat(scanner.nextLine()));
                        listEmps.get(indexUpdate).calSalary();
                        break;
                    case 5:
                        System.out.println("Nhập vào trạng thái cập nhật của nhân viên:");
                        listEmps.get(indexUpdate).setStatus(Boolean.parseBoolean(scanner.nextLine()));
                        break;
                    case 6:
                        isExist = false;
                        break;
                    default:
                        System.err.println("Vui lòng chọn từ 1-6");

                }
            } while (isExist);
        } else {
            System.err.println("Mã nhân viên không tồn tại");
        }
    }

    public static int findIndexEmpOfList(String id) {
        for (int i = 0; i < listEmps.size(); i++) {
            if (listEmps.get(i).getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public static void deleteEmployee(Scanner scanner) {
        System.out.println("Nhập vào mã nhân viên cần xóa:");
        String idDelete = scanner.nextLine();
        int indexDelete = findIndexEmpOfList(idDelete);
        if (indexDelete >= 0) {
            listEmps.remove(indexDelete);
            System.out.println("Đã xóa xong nhân viên có mã là " + idDelete);
        } else {
            System.err.println("Mã nhân viên không tồn tại");
        }
    }

    public static void sortEmpByNameDESC() {
        Collections.sort(listEmps, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return -employee.getName().compareTo(t1.getName());
            }
        });
    }

    public static void sortEmpByYearASC() {
        Collections.sort(listEmps, new Comparator<Employee>() {
            @Override
            public int compare(Employee employee, Employee t1) {
                return employee.getYear() - t1.getYear();
            }
        });
    }

}
