package com.example.linuxsir.nanosimple;

import java.util.Map;

/**
 * Created by linuxsir on 15/7/30.
 */
public interface Server {

    boolean serverismatch(String path);

    String servercontent(String path,Map parms);
}
