package com.lushixiang.testSpi;

import java.util.ServiceLoader;

public class SpiApplication {
    public static void main(String[] args) {
        ServiceLoader<com.lushixiang.testSpi.SearchFacade> load = ServiceLoader.load(SearchFacade.class);
        for(com.lushixiang.testSpi.SearchFacade item:load){
            item.searchData();
        }
    }
}
