import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1 is client 2 is customer
        int role = 1;
        // -------------------------
        Scanner a = new Scanner(System.in);
        int key;
        do { 
            System.out.println("=========================MENU============================");
            System.out.println(">>0. Kết thúc                                            ");
            System.out.println(">>1. Đăng nhập                                           ");
            System.out.println(">>2. Đăng kí                                             ");
            System.out.println(">>3. Tra cứu hàng hóa                                    ");
            System.out.println("=========================================================");
            System.out.print("Chọn chức năng: ");
            key = a.nextInt();
            a.nextLine();
            switch(key){
                case 1: 
                    // Day la vi du ve role
                    if (role == 1) {
                        menuClient(a);
                    } else if (role == 2) {
                        menuCustomer(a);
                    }
                    // --------------------
                    break;
                case 2:
                    break;
                case 3: 
                    break;
            }
    }while(key != 0);
        System.out.println(" kết thúc");
        a.close();
    }
    

    public static void menuCustomer(Scanner a) {
        int key;
        do {
            System.out.println("=========================MENU============================");
            System.out.println(">>1. mua hàng                                            ");
            System.out.println(">>2. xem lịch sử mua hàng                                ");
            System.out.println(">>3. theo dõi tiến trình hàng hóa                        ");
            System.out.println(">>4. Tra cứu hàng hóa                                    ");
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

    public static void menuClient(Scanner a) {
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

