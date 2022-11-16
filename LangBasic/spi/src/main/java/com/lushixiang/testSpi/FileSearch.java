package com.lushixiang.testSpi;

public class FileSearch implements SearchFacade{


    @Override
    public String searchData() {
        System.out.println("file date searching ...");
        return null;
    }
}
