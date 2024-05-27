package org.example;

/**
 * 共享礼品区
 */
public class SharedGifts {
    //初始总礼物数为100
    private int gifts = 100;

    public int getXm() {
        return xm;
    }

    public void setXm(int xm) {
        this.xm = xm;
    }

    public void setXh(int xh) {
        this.xh = xh;
    }

    public int getXh() {
        return xh;
    }

    private int xm = 0;
    private int xh = 0;
    public void giveGifts(){
        if(gifts >= 10){
            synchronized (this) {
                if(gifts >= 10) {
                    System.out.println(Thread.currentThread().getName() + "送出一份礼品!");
                    gifts--;
                }
            }
        }
    }

    public SharedGifts() {
    }

    public SharedGifts(int gifts, int xm, int xh) {
        this.gifts = gifts;
        this.xm = xm;
        this.xh = xh;
    }

    /**
     * 获取
     * @return gifts
     */
    public int getGifts() {
        return gifts;
    }

    /**
     * 设置
     * @param gifts
     */
    public void setGifts(int gifts) {
        this.gifts = gifts;
    }

    public String toString() {
        return "SharedGifts{gifts = " + gifts + "}";
    }
}
