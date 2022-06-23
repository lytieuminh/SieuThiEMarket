package Template;

import java.io.FileWriter;
// import java.io.FileWriter;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import Template.CreateAccountController;
import Template.CreateAccountUI;
import Template.LoggedInAccountUI;
import Template.LogginAccountController;
import Template.menuCustomer;
import Template.menuEmployee;

public class BootStrap {

    static JsonArray list = new JsonArray();

    public static void main(String[] args) {
        chooseOptions();
    }

    public static void chooseOptions() {
        Scanner scanner = new Scanner(System.in);

        CreateAccountController createAccountController = new CreateAccountController();
        CreateAccountUI createAccountUI = new CreateAccountUI(createAccountController);

        LogginAccountController logginAccountController = new LogginAccountController();
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);

        System.out.println("Welcome to the eMarket System!!\n(To exit type 'esc')");

        int key;
        do {
            System.out.println(getPrompt(logginAccountController)); // show loggin account name
            displayOptions(logginAccountController, scanner); // show menu options

            System.out.print("Chọn chức năng: ");
            key = scanner.nextInt();
            // scanner.nextLine();

            String requireMsg; // user guide

            switch (key) {
                case 1: {// login or logout
                    requireMsg = loggedInAccountUI.handleCommands(key);
                    System.out.println(requireMsg);
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
                case 2: {// create account
                    requireMsg = createAccountUI.handleCommands(key);
                    System.out.println(requireMsg);
                    createAccountUI.handleCAInputs();
                    break;
                }
                case 0: {
                    System.out.println("kết thúc");
                    break;
                }
                default:
                    break;
            }
        } while (key != 0);
    }

    public static void displayOptions(LogginAccountController logginAccountController, Scanner scanner) {
        menuCustomer menuCustomer = new menuCustomer();
        menuEmployee menuEmployee = new menuEmployee();

        // check login
        if (!logginAccountController.getCustomer().checkLoggedIn()
                && !logginAccountController.getEmployee().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>0. Kết thúc                                            ");
            System.out.println(">>1. Đăng nhập                                           ");
            System.out.println(">>2. Đăng kí                                             ");
            System.out.println(">>3. Tra cứu hàng hóa                                    ");
            System.out.println("=========================================================");
        } else if (logginAccountController.getCustomer().checkLoggedIn()
                && logginAccountController.getAccountRole().equals("KH")) {
            menuCustomer.renderUI(logginAccountController, scanner);
        } else {
            menuEmployee.renderUI(logginAccountController, scanner);
        }

    }

    public static String getPrompt(LogginAccountController logginAccountController) {
        if (logginAccountController.getAccountRole() == null) {
            return "";
        }
        if (logginAccountController.getAccountRole().equals("KH")) {
            if (!logginAccountController.getCustomer().checkLoggedIn()) {
                return "";
            }
            return "WELCOME #" + logginAccountController.getCustomer().getUserName();

        } else {
            if (!logginAccountController.getEmployee().checkLoggedIn()) {
                return "";
            }
            return "WELCOME #" + logginAccountController.getEmployee().getUserName();
        }
    }

}
