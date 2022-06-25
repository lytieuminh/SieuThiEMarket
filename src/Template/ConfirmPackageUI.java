package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Config.Actions;
import Controller.ConfirmPackageController;
import Model.Custumer;
import Model.Order;

public class ConfirmPackageUI {
    private Custumer custumer;
    private Order order;
    private Actions command;

    private static Scanner input = new Scanner(System.in);

    private ConfirmPackageController confirmPackageController = new ConfirmPackageController(custumer, order);

    public ConfirmPackageUI(ConfirmPackageController confirmPackageController){
        this.confirmPackageController = confirmPackageController;
        this.command = null;
    }

    public List<Object> ConfirmPackage(){
        List<Object> list = new ArrayList<>();

        confirmPackageController.displayOrderInfo();

        System.out.print("[SYSTEM] Choose ID order: ");
        int orderID = input.nextInt();

        String cmd = null;

        if(confirmPackageController.checkCustumer(orderID)){
            System.out.print("\n[SYSTEM] Confirm you received the package: ");
            cmd = input.next();
        } else {
            System.out.println("[SYSTEM] Name or ID Order do not exist.");
        }

        list.add(orderID);
        list.add(cmd);

        return list;
    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);

        if(this.command.equals(Actions.XNDG)){
            return "[SYSTEM] Choose YES or No";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(){

        String returnStr = null;

        List<Object> list = new ArrayList<>();

        list = ConfirmPackage();

        int orderID = (Integer) list.get(0);

        String cmd = String.valueOf(list.get(1));

        if(cmd.equalsIgnoreCase("YES")) {
            confirmPackageController.ConfirmOrder(orderID);

            returnStr = "[SYSTEM] You confirmed package";

            System.out.println(confirmType(orderID));
        } else if(cmd.equalsIgnoreCase("NO")) {
            returnStr = "[SYSTEM] You chosen NO";
        } else {
            returnStr = "[SYSTEM] Unknown your answer";
        }

        return returnStr;
    }

    public String confirmType(int orderID){
        String cmd = null;

        cmd = confirmType_Command(orderID);

        if(cmd == null){
            return "[SYSTEM] Thank you for using our services";
        }

        //Lay thong tin Custumer tu dong 88
        if(cmd.toUpperCase().equals("YES")){
            if(confirmPackageController.confirmType_KH("Hao")){
                return "[SYSTEM] Thanks you for register."; 
            } else {
                return "[SYSTEM] Thank you for using our services";
            }
        } else {
            return "[SYSTEM] Thank you for using our services";
        }
    }

    public String confirmType_Command(int orderID){
        String cmd = null;
        Double amount = Double.valueOf(Order.getOrder().searchStr("Price", orderID));

        if(checkValidAmount(amount)){
            System.out.println("[SYSTEM] Do you want to be our Premium Custumer? YES - NO");
            System.out.print("[SYSTEM] Your answer: ");
            cmd = input.next();
        }

        return cmd;
    }

    public boolean checkValidAmount(Double amount){
        if(amount >= 100000.0){
            return true;
        } else {
            return false;
        }
    }
}
