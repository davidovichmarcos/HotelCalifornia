package app;

import app.helpers.FileHelper;

import java.io.IOException;
import java.util.TreeSet;
import java.util.UUID;

public class Main {

    public static void main(String[] args) throws IOException {
      // System.out.println("Hello");
      // Login login = new Login(500, 200, "Login", true);

        TreeSet<Employee> set = new TreeSet<>();
        Employee employee = new Employee("asd","asd",39966545,UUID.randomUUID(),"asd");
        Employee employee1 = new Employee("ahre","ahre",39966575,UUID.randomUUID(),"ahre");
        set.add(employee);
        set.add(employee1);
        FileHelper fileHelper = new FileHelper();
        fileHelper.employeesToJsonFile(set);

    }
}
