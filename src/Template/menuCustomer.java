package Template;

import java.util.Scanner;

import Controller.LogginAccountController;

public class menuCustomer {
    public void renderUI(LogginAccountController logginAccountController, Scanner a) {
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);

        int key;
        do {
            displayOptions(logginAccountController);

            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch (key) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5: {
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
            }
        } while (key != 5);

    }

    public void displayOptions(LogginAccountController logginAccountController) {
        if (logginAccountController.getCustomer().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. mua hàng                                            ");
            System.out.println(">>2. xem lịch sử mua hàng                                ");
            System.out.println(">>3. theo dõi tiến trình hàng hóa                        ");
            System.out.println(">>4. Tra cứu hàng hóa                                    ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println("=========================================================");
        } else {
            BootStrap.chooseOptions();
        }

    }
}
