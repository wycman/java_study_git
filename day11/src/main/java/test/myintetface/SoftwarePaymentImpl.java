package test.myintetface;

public class SoftwarePaymentImpl implements payment{
    public void pay(double money){
        System.out.println("支付平台支付" + money + "元!");
    }
}
