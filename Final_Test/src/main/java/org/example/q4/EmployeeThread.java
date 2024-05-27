package org.example.q4;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeThread implements Runnable{
    private Employee employee;
    private List<Integer> hongbao;
    public EmployeeThread(List<Integer> hongbao) {
        this.hongbao = hongbao;
    }

    public EmployeeThread(Employee employee, List<Integer> hongbao) {
        this.employee = employee;
        this.hongbao = hongbao;
    }

    public void run(){

            while (hongbao.size() != 0){
                synchronized (hongbao) {
                    if(hongbao.size() == 0)
                        break;
                    System.out.println("*****当前线程为:" + Thread.currentThread().getName());
                    int random_idx = ThreadLocalRandom.current().nextInt(hongbao.size());
                    int money = hongbao.get(random_idx);
                    hongbao.remove(random_idx);
                    this.employee.setSum_money(this.employee.getSum_money() + money);
                    System.out.println("当前员工id:" + this.employee.getId() + "抢到了红包:" + money + "元!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    }
}
