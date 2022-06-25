package Controller;

import Model.HangHoa;
import Model.Order;

public class CreateOrderController {
    private HangHoa hanghoaObj;

    public CreateOrderController(HangHoa hanghoaObj) {
        this.hanghoaObj = hanghoaObj;
    }

    public void CreateNewOrder(Order order){

        //Function dang nhap (Check dang nhap) if/else

        Order.getOrder().update(order.getID(), order.getName(), order.getPrice(), order.getOwner(), order.getDeliveryAddress(), order.getStateDelivery());
        Order.getOrder().write();
        
    }

    public int getSize(){
        return HangHoa.getHanghoas().getMemorySize();
    }
    
    public String getValue(String key, int index){
        return HangHoa.getHanghoas().searchStr(key, index);
    }
}
