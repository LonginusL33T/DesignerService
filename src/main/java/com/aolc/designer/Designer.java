package com.aolc.designer;

import com.aolc.designer.auto._Designer;

public class Designer extends _Designer {

    private static Designer instance;

    private Designer() {}

    public static Designer getInstance() {
        if(instance == null) {
            instance = new Designer();
        }

        return instance;
    }
}
