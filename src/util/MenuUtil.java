package util;

public class MenuUtil {

    public static void processMenu(int selectedMenu) {
        switch (selectedMenu) {
            case 1:
                StudentUtil.registerStudents();
                break;
            case 2:
                StudentUtil.printAllRegisteredStudents();
                break;
            case 3:
                StudentUtil.findStudentsAndPrint();
                break;
            case 4:
                StudentUtil.updateStudentWithNewObject();
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    public static String requiredName() {
        return InputUtil.requiredText("Enter name");
    }

    public static String requiredSurname() {
        return InputUtil.requiredText("Enter surname");
    }

    public static int requiredAge() {
        return InputUtil.requiredNumber("Enter age");
    }

    public static String requiredClassname() {
        return InputUtil.requiredText("Enter className");
    }

    public static void showSuccessOperationMessage() {
        System.out.println("Operation successfully finished!");
    }
}
