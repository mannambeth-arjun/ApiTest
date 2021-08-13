package com.arjun.test;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    Properties configs = new Properties();

    {
        try {
            configs.load(BaseTest.class.getResourceAsStream("/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
