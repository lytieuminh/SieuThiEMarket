package Controller;

import java.util.Scanner;

import Model.Order;

public class TrackOrderController {
    private Order orderObj;

    private Scanner input = new Scanner(System.in);

    public TrackOrderController(Order orderObj){
        this.orderObj = orderObj;
    }

    public String displayOrder(int index){
        String returnStr = null;

        try {
            returnStr = String.valueOf(Order.getOrder().searchStr(index));
        } catch (Exception e) {

        }

        return returnStr;
    }


}