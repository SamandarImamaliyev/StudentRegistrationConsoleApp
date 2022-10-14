package util;

import beans.Student;
import main.Config;

public class StudentUtil {
    public static Student fillStudent() {
        String name = MenuUtil.requiredName();
        String surname = MenuUtil.requiredSurname();
        int age = MenuUtil.requiredAge();
        String className = MenuUtil.requiredClassname();

        Student student = new Student(name, surname, age, className);
        return student;
    }

    public static void printAllRegisteredStudents() {
        if (Config.students == null) {
            System.out.println("There is no registered student.");
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requiredNumber("How many students do you want to register?");
        Config.students = new Student[count];
        for (int i = 0; i < count; i++) {
            System.out.println("Registration of student " + (i + 1));
            Config.students[i] = StudentUtil.fillStudent();
        }
        MenuUtil.showSuccessOperationMessage();
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requiredText("Type name, surname or class name");
        Student[] result = findStudents(text);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text) || st.getSurname().contains(text) || st.getClassName().contains(text)) {
                result[found] = st;
                found++;
            }
        }
        return result;
    }

    public static void updateStudentWithNewObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requiredNumber("Which student do you want to update?");
        System.out.println("Insert the new information");
        Student st = StudentUtil.fillStudent();
        Config.students[i - 1] = st;//burda yeni obyekt menimsedirik..
    }

    //    burda ise eyni obyektin ozunde deyisiklik edirik...
    public static void updateStudentWithSameObject() {
        StudentUtil.printAllRegisteredStudents();
        int i = InputUtil.requiredNumber("Which student do you want to update?");
        Student selectedStudent = Config.students[i - 1];
        String changedParams = InputUtil.requiredText("Which params do you want change? ( for example: 'name','classname' etc. )");
        if (changedParams.contains("'name'")) {
            selectedStudent.setName(MenuUtil.requiredName());
        }
        if (changedParams.contains("'surname'")) {
            selectedStudent.setSurname(MenuUtil.requiredSurname());
        }
        if (changedParams.contains("'classname'")) {
            selectedStudent.setClassName(MenuUtil.requiredClassname());
        }
        if (changedParams.contains("'age'")) {
            selectedStudent.setAge(MenuUtil.requiredAge());
        }
    }

    public static void updateStudentWithSplit() {
        StudentUtil.printAllRegisteredStudents();
        int index = InputUtil.requiredNumber("Which student do you want to update?");
        Student selectedStudent = Config.students[index - 1];
        String changedParams = InputUtil.requiredText("Which params do you want change? ( for example: name,classname etc. )");
        String[] parameters = changedParams.split(",");
        for (int i = 0; i < parameters.length; i++) {
            String param = parameters[i];
            if (param.equalsIgnoreCase("name")) {
                selectedStudent.setName(MenuUtil.requiredName());
            } else if (param.equalsIgnoreCase("surname")) {
                selectedStudent.setSurname(MenuUtil.requiredSurname());
            } else if (param.equalsIgnoreCase("classname")) {
                selectedStudent.setClassName(MenuUtil.requiredClassname());
            } else if (param.equalsIgnoreCase("age")) {
                selectedStudent.setAge(MenuUtil.requiredAge());
            }
        }
    }


}
