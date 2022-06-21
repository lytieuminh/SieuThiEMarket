
package Template;
import java.util.Scanner;

public class menuClient {
    public void renderUI (Scanner a) {
        int key;
        do {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. thêm sửa xóa hàng hóa                               ");
            System.out.println(">>2. xác nhận mua hàng cho khách                         ");
            System.out.println(">>3. xác nhận đăng ký khách hàng thân thiết cho khách    ");
            System.out.println(">>4. thống kê                                            ");
            System.out.println(">>5. Đăng xuất                                           ");
            System.out.println("=========================================================");
            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch(key){
                case 1: 
                    break;
                case 2:
                    break;
                case 3: 
                    break;
                case 4: 
                    break;
                case 5: 
                    break;
            }
        } while (key != 5);
        System.out.println(" kết thúc");
    }
}
