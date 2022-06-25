package Controller;

import Model.Custumer;
import Model.Order;
import Model.PremiumCustumer;

public class ConfirmPackageController {
    private Custumer custumer;
    private Order order;

    public ConfirmPackageController(Custumer custumer, Order order){
        this.custumer = custumer;
        this.order = order;
    }

    public String displayOrder(int index){
        String returnStr = null;

        try {
            returnStr = String.valueOf(Order.getOrder().searchStr(index));
        } catch (Exception e) {

        }
        
        return returnStr;
    }

    public void displayOrderInfo(){
        Order.getOrder().toArray();
    }

    public boolean checkCustumer(int orderID){

        int index = Order.getOrder().searchIndex("ID", orderID);

        String custumerName = Order.getOrder().searchStr("Owner", index);

        //Lay ten Custumer trong Order o day thay vi "Hao"
        if(custumerName.equalsIgnoreCase("Dung")){
            return true;
        } else {
            return false;
        }

    }

    public void ConfirmOrder(int idOrder){

        Order.getOrder().setValue("State", "Da giao thanh cong", idOrder);
        Order.getOrder().write();

    }

    public boolean confirmType_KH(String nameCustumer){

        int index = Custumer.getCustumers().searchIndex("Name", nameCustumer);

        String name = Custumer.getCustumers().searchStr("Name", index);

        String address = Custumer.getCustumers().searchStr("Address", index);

        int amount = (Integer) Custumer.getCustumers().searchInt("Money", index);

        String type = Custumer.getCustumers().searchStr("Type", index);

        String purchasedProduct = Custumer.getCustumers().searchStr("Purchased Product", index);



        if(index == -1){
            return false;
        } else {
            PremiumCustumer.getPreCustumer().update(name, address, amount, type, purchasedProduct);
            PremiumCustumer.getPreCustumer().write();
            return true;
        }
    }
}
