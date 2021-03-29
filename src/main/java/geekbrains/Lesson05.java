package geekbrains;

import java.util.EnumMap;

public class Lesson05 {
    public static void main(String[] args){
        Employee a = new Employee("James Evans","Chief Technology Officer","james@company_a.com","81111111",80000,46);
        //a.printInfo();
        Employee[] hrBase = new Employee[5];
        hrBase[0] = a;
        hrBase[1] = new Employee("Hakim Henderson","Financier","hakim@apple.com","+7344530298", 12000, 27);
        hrBase[2] = new Employee("Joann Dark","Accountant","Joann87@yahoo.com","8(495)3377661", 50000,31);
        hrBase[3] = new Employee("Peter Johnes","Engineer","pjones@google.com","+3113 84839 3344993", 43000,34);
        hrBase[4] = new Employee("Elisa Woods", "Director","eWoods@mail.com", "none",20000,42);

        for (Employee b : hrBase){
            if (b.age > 40) {b.printInfo();}
        }
    }
}

class Employee {
    private String fullName;
    private String position;
    private String eMail;
    private String phoneNumber;
    int salary;
    int age;

    public Employee(String fullName, String position, String eMail, String phoneNumber, int salary, int age){
        this.fullName = fullName;
        this.position = position;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo (){
         String output = "Full name is: " + fullName +
                "\nPosition is: " + position +
                "\nEmail is: " + eMail +
                "\nPhone number is: " + phoneNumber +
                "\nSalary is: " + salary +
                "\nAge is: " + age;
        System.out.println(output);
        System.out.println();
    }
}
