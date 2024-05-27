package org.example;

public class Student {
    private String name;
    private int age;
    private int chn_score;
    private int math_score;
    private int eng_score;

    public Student() {
    }

    public Student(String name, int age, int chn_score, int math_score, int eng_score) throws scoreException, ageException{
        this.name = name;
        this.setAge(age);
        this.setChn_score(chn_score);
        this.setMath_score(math_score);
        this.setEng_score(eng_score);
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
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) throws ageException{
        if(age > 0 && age < 120)
            this.age = age;
        else
            throw new ageException("年龄应该在0到120岁之间!");
    }

    /**
     * 获取
     * @return chn_score
     */
    public int getChn_score() {
        return chn_score;
    }

    /**
     * 设置
     * @param chn_score
     */
    public void setChn_score(int chn_score) throws scoreException{
        if(chn_score >= 0 && chn_score <= 100)
            this.chn_score = chn_score;
        else
            throw new scoreException("成绩应当在0到100分之间!");
    }

    /**
     * 获取
     * @return math_score
     */
    public int getMath_score(){
            return math_score;
    }

    /**
     * 设置
     * @param math_score
     */
    public void setMath_score(int math_score) throws scoreException{
        if(math_score >= 0 && math_score <= 100)
            this.math_score = math_score;
        else
            throw new scoreException("成绩应当在0到100分之间!");
    }

    /**
     * 获取
     * @return eng_score
     */
    public int getEng_score() {
        return eng_score;
    }

    /**
     * 设置
     * @param eng_score
     */
    public void setEng_score(int eng_score) throws scoreException{
        if(eng_score >= 0 && eng_score <= 100)
            this.eng_score = eng_score;
        else
            throw new scoreException("成绩应当在0到100分之间!");
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + ", chn_score = " + chn_score + ", math_score = " + math_score + ", eng_score = " + eng_score + "}";
    }
}
