package com.hzw.e_set_map.a_bstset;

import com.sun.xml.internal.ws.message.source.PayloadSourceMessage;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        String pa = ClassLoader.getSystemResource("pride-and-prejudice.txt").getPath();
        ArrayList<String> list = new ArrayList<String>();
        if (FileOperation.readFile(pa,list)) {
            System.out.println("傲慢与偏见，总单词数："+list.size());
            BSTSet<String> bstSet = new BSTSet<String>();
            for (String s : list) {
                bstSet.add(s);
            }
            System.out.println("傲慢与偏见，不同单词数："+bstSet.getSize());
        }


    }
}
