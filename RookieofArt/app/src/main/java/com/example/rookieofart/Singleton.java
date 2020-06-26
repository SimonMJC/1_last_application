package com.example.rookieofart;

import java.util.ArrayList;

public class Singleton {
    private static Singleton instance;
    private Singleton(){

    }
    //artInfo의 정보를 담는 곳(데이터관리)
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance;
    }
    ArrayList<ArtInfo> artInfos;

}
