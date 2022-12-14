package com.spiachieve.spi;


import com.spi.commoninterface.spifacade.SearchFacade;

public class DBSearch implements SearchFacade {

    @Override
    public String searchData() {
        System.out.println("DB date searching ...");
        return null;
    }
}
