package test.myintetface;

public class VisaPaymentImpl implements payment{
    public void pay(double money){
        System.out.println("信用卡支付" + money + "元!");
    }
}
