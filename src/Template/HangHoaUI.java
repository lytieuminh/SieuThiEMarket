package Template;

import Controller.HangHoaController;

public class HangHoaUI {
    private HangHoaController hangHoaController;

    public HangHoaUI(HangHoaController hangHoaController){
        this.hangHoaController = hangHoaController;
    }

    public void displayHanghoa(){
        hangHoaController.getAllHangHoa();
    }
}
