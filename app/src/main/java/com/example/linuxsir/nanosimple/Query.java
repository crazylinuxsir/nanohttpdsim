package com.example.linuxsir.nanosimple;

import java.util.Map;

/**
 * Created by linuxsir on 15/7/30.
 */
public interface Query {

    boolean queryismatch(String path);

    String querycontent(String path,Map parms);
}
