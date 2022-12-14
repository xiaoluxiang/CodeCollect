package com.lushixiang.testSpi;

import com.spi.commoninterface.spifacade.SearchFacade;

import java.util.ServiceLoader;

public class SpiApplication {
    public static void main(String[] args) {
        ServiceLoader<SearchFacade> load = ServiceLoader.load(SearchFacade.class);
        load.forEach(System.out::println);
        for(SearchFacade item:load){
            item.searchData();
        }
    }
}
