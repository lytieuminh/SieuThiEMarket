package Template;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Config.Actions;
import Controller.PurchaseHistoryController;
import Model.Custumer;

public class PurchaseHistoryUI {
    private Custumer custumer;
    private Actions command;
    private static Scanner input = new Scanner(System.in);

    PurchaseHistoryController purchaseHistoryController = new PurchaseHistoryController(custumer);

    public PurchaseHistoryUI(PurchaseHistoryController purchaseHistoryController){
        this.purchaseHistoryController = purchaseHistoryController;
        this.command = null;
    }

    public List<String> showPHistoryInput(){
        List<String> listPHistory = new ArrayList<>();

        System.out.print("[TEMPORARY] Insert name: ");
        String name = input.next();

        listPHistory = purchaseHistoryController.getPHistory(name);
        
        listPHistory.add(name);

        return listPHistory;
    }

    public String handleCommand(String reply){
        String cmd = reply.toUpperCase();

        this.command = Actions.valueOf(cmd);
        if(this.command.equals(Actions.LSMH)){
            return "[SYSTEM] Enter name";
        } else {
            return "[SYSTEM] Unknown command";
        }
    }

    public String handleInput(){
        List<String> listPHistory = new ArrayList<>();

        listPHistory = showPHistoryInput();

        if(listPHistory.get(0).equals("NO PRODUCT FOUND")){
            return "[SYSTEM] " + listPHistory.get(1).toString() +  "'s Purchased History is empty";
        } else if(listPHistory.get(0) == "NO CUSTUMER FOUND"){
            return "[SYSTEM] " + listPHistory.get(1).toString() + " is not on the system";
        } else {
            return listPHistory.get(0).toString();
        }
    }
}
