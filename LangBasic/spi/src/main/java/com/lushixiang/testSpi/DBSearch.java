package com.lushixiang.testSpi;

import com.lushixiang.testSpi.SearchFacade;

public class DBSearch implements SearchFacade {

    @Override
    public String searchData() {
        System.out.println("DB date searching ...");
        return null;
    }
}
