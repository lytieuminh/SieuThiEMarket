package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Config.Actions;
import Controller.TrackOrderController;
import Model.Order;

public class TrackOrderUI {
    private Order orderObj;
    private Actions command;

    private Scanner input = new Scanner(System.in);

    TrackOrderController trackOrderController = new TrackOrderController(orderObj);

    public TrackOrderUI(TrackOrderController trackOrderController){
        this.trackOrderController = trackOrderController;
        this.command = null;
    }
    
    public List<String> TrackOrderInput(){
        String owner = null;
        //Kiem tra Custumer - Sau do lay Order dang giao hang theo Owner (username)

        System.out.print("[TEMPORARY] Insert name: ");
        owner = input.next();

        //Phan tim kiem theo ten duoc nhap - Sau nay them Custumer vao thi lay Owner tu dong
        
        return Order.getOrder().searchIndexList("Name", owner);
    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.TDDH)){
            return "[SYSTEM] Type a name";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(){
        List<String> listIndex = new ArrayList<>();

        List<Object> listOrder = new ArrayList<>();

        String returnValue = null;

        listIndex = TrackOrderInput();

        for (int i = 0; i <= listIndex.size(); i++) {
            listOrder.add(trackOrderController.displayOrder(i));
        }

        if(this.command.equals(Actions.TDDH)){
            System.out.println(listOrder);
            
            returnValue = "[SYSTEM] YOUR ORDER IS PRINTED";
        } else {
            returnValue = "[SYSTEM] YOU DONT HAVE ANY ORDER";
        }

        return returnValue;
    }
}
