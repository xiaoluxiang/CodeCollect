package com.lushixiang.deadClock;

import java.util.List;
import java.util.Map;

public class testGetInfer {
    public List<Map<Integer,String>>  list;

    public List<Map<Integer,String>> getList(){
        return this.list;
    }
    public void setList(List<Map<Integer,String>> list){
        this.list = list;
    }

    public testGetInfer(List<Map<Integer,String>> list){
        this.list = list;
    }

}
