package Template;

import java.util.Scanner;

import Controller.LogginAccountController;



public class menuCustomer {
    public void renderUI(LogginAccountController logginAccountController, Scanner a) {
    
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);
        ChangePasswordUI changePasswordUI = new ChangePasswordUI(logginAccountController);

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
                    //trash
                    break;
                case 5: {
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
                case 6: {
                    changePasswordUI.handleCPInputs(logginAccountController, key);
                    break;
                }
                case 0: {
                    return;
                }
            }
        } while (key != 5);

    }

    public void displayOptions(LogginAccountController logginAccountController) {
        if (logginAccountController.getCustomer().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. mua hàng                                            ");
            System.out.println(">>2. xem lịch sử mua hàng                                ");
            System.out.println(">>3. theo dõi - xác nhận hàng hóa                        ");
            System.out.println(">>4. Tra cứu hàng hóa                                    ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println(">>6. Đổi mật khẩu                                        ");
            System.out.println("=========================================================");
        } 
    }
}
