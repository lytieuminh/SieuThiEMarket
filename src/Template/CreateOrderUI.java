package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Config.Actions;
import Controller.CreateOrderController;
import Controller.HangHoaController;
import Model.HangHoa;
import Model.Order;

public class CreateOrderUI {
    private static Scanner input = new Scanner(System.in);
    private CreateOrderController orderController;
    private Actions command;
    private HangHoa hanghoa;

    private HangHoaController hangHoaController = new HangHoaController(hanghoa);
    
    public CreateOrderUI(CreateOrderController orderController) {
        this.orderController = orderController;
        this.command = null;
    }

    private int datHangInput(){

        System.out.print("[SYSTEM] Item's ID: ");
        int purchaseID = input.nextInt();

        if(checkMemorySize(purchaseID)){
            System.out.println("[SYSTEM] YES or NO");
            System.out.print("[SYSTEM] Please confirm your order: ");
            String resCmd = input.next();
    
            if(!resCmd.equalsIgnoreCase("YES")){
                purchaseID = -1;
            }
        } else {
            purchaseID = -1;
            System.out.println("[SYSTEM] WRONG ID");
        }

        return purchaseID;
    }

    public boolean checkMemorySize(int index){
        if(index <= orderController.getSize()){
            return true;
        } else {
            return false;
        }
    }

    public String handleCommands(String reply){
        String cmd = reply.toUpperCase();

        hangHoaController.getAllHangHoa();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.MH)){
            return "[SYSTEM] | Please enter your choice |";
        } else {
            return "[SYSTEM] | Unknown command |";
        }
    }

    public String handleInputs(){
        List<Object> list = new ArrayList<>();

        int purchaseID = datHangInput();

        int idHangHoa = -1;
        String nameHangHoa = null;
        Double priceHangHoa = -1.0;

        String returnValue = null;

        if(purchaseID == -1){
            return "[SYSTEM] BACK TO MENU";
        }

        list.add(orderController.getValue("ID", purchaseID));
        list.add(orderController.getValue("Name", purchaseID));
        list.add(orderController.getValue("Price", purchaseID));
        
        try {
            String parseStringID = String.valueOf(list.get(0));
            idHangHoa = Integer.valueOf(parseStringID);
    
            nameHangHoa = String.valueOf(list.get(1));
    
            String parseStringHH = String.valueOf(list.get(2));
            priceHangHoa = Double.valueOf(parseStringHH);
        } catch (Exception e) {

        }

        if(this.command.equals(Actions.MH)){
            if(idHangHoa != -1 || nameHangHoa != null || priceHangHoa != -1.0){
                Order newOrder = new Order(idHangHoa, nameHangHoa, priceHangHoa, "Hao", "XXX Quan 6");
            //Them bien Owner - deliveryAddress của Custumer
                orderController.CreateNewOrder(newOrder);

                returnValue = "[SYSTEM] | Your order have been created |";
            } else {
                returnValue = "[SYSTEM] | ITEM DOES NOT EXIST |";
            }
            
        }

        return returnValue;
    }

}
