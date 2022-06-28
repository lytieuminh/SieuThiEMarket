package Template;

import java.util.Scanner;


import Controller.LogginAccountController;

public class menuEmployee {

    public void renderUI(LogginAccountController logginAccountController, Scanner a) {
       
    
        menuThongKe menuThongKe = new menuThongKe();
        LoggedInAccountUI loggedInAccountUI = new LoggedInAccountUI(logginAccountController);


        int key;
        String rep = null;

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
                    menuThongKe.renderUI(a);
                    break;
                case 5: {
                    loggedInAccountUI.handleInputLI(key);
                    break;
                }
            }
        } while (key != 5);
        System.out.println(" kết thúc");
    }

    public void displayOptions(LogginAccountController logginAccountController) {
        if (logginAccountController.getEmployee().checkLoggedIn()) {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. thêm sửa xóa hàng hóa                               ");
            System.out.println(">>2. xác nhận đơn hàng cho khách                         ");
            System.out.println(">>3. xác nhận đăng ký khách hàng thân thiết cho khách    ");
            System.out.println(">>4. thống kê                                            ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println("=========================================================");
        } else {
        }

    }

}
