package test.myintetface;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.println("请输入您的支付方式!1.平台软件，2.银行卡支付，3.VISA支付!");
        Scanner scanner = new Scanner(System.in);
        int choose = scanner.nextInt();
        payment p = null;
        switch (choose){
            case 1->{
                p = new SoftwarePaymentImpl();
                break;
            }
            case 2->{
                p = new BankPaymentImpl();
                break;
            }
            case 3->{
                p = new VisaPaymentImpl();
                break;
            }
            default -> {break;}
        }
        //输入支付金额
        System.out.println("请输入支付金额!");
        int money = scanner.nextInt();
        p.pay(money);
    }
}
