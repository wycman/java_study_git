package test.myintetface;

public class BankPaymentImpl implements payment{
    public void pay(double money){
        System.out.println("银行卡支付" + money + "元!");
    }
}
