package Controller;

import Model.Order;

public class ConfirmOrderController {
    private Order orderObj;

    public ConfirmOrderController(Order orderObj){
        this.orderObj = orderObj;
    }

    public void ConfirmOrder(int idOrder){


        //Check dang nhap (Nhan vien) if/else

        Order.getOrder().setValue("State", "Dang giao", idOrder);
        Order.getOrder().write();
    }

    public void displayOrders(){
        Order.getOrder().toArray();
    }

    public int getSize(){
        return Order.getOrder().getMemorySize();
    }


}
