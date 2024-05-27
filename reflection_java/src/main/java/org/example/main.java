package org.example;

import java.io.FileNotFoundException;

public class main {
    public static void main(String[] args) throws FileNotFoundException, IllegalAccessException {
        Member yz = new Member("乃木园子", 15, "勇者部");
        Member member2 = new Member("wassi", 16, "勇者部");
        ObjectSaveFrame.SaveObject(yz);
        ObjectSaveFrame.SaveObject(member2);
    }
}
