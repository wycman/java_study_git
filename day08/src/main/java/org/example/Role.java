package org.example;

import java.util.Random;

public class Role {
    private String name;
    private int hp;
    String face;
    String gender;
    String[] male_face = {"清秀可爱","俊秀无双","平平无奇","油腻猥琐"};
    String[] female_face = {"倾国倾城", "闭月羞花", "妩媚绝美", "清秀可爱"};
    public Role() {
    }

    public Role(String name, String gender, int hp) {
        this.name = name;
        this.hp = hp;
        this.gender = gender;
        this.setFace(gender);
    }


    public void setFace(String gender){
        Random random = new Random();
        if(gender == "男")
        {
            this.face = male_face[random.nextInt(male_face.length)];
        }else if(gender == "女"){
            this.face = female_face[random.nextInt(female_face.length)];
        }else{
            //不设置性别的话则默认设置为丑陋无比
            this.face = "丑陋无比";
        }
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return hp
     */
    public int getHp() {
        return hp;
    }

    /**
     * 获取长相并返回
     */
    public String getFace(){
        return this.face;
    }

    /**
     * 设置
     * @param hp
     */
    public void setHp(int hp) {
        this.hp = hp;
    }
    /**
     * attack攻击操作，传入参数为敌人的对象
     *
     */
    public void attack(Role r2){
        Random random = new Random();
        int attack_value = random.nextInt(16) + 20;
        //判断敌人对象r2当前血量，如果大于等于本次的攻击值就可以直接修改
        //否则直接归为0
        int current_r2_hp = r2.getHp();
        int real_attack_value = (current_r2_hp >= attack_value)
                ? attack_value : current_r2_hp;
        System.out.printf("长相%s的%s肘击了%s, 造成了%d点的伤害, %s还剩%d点血量",
                this.face, this.name, r2.getName(), real_attack_value, r2.getName(),
                current_r2_hp - real_attack_value);
        System.out.println();
        r2.setHp(current_r2_hp - real_attack_value);
    }
}
