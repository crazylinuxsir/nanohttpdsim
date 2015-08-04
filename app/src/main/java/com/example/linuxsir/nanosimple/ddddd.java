package com.example.linuxsir.nanosimple;

import com.example.linuxsir.nanosimple.test.NanoHTTPD;

import java.util.Map;

/**
 * Created by linuxsir on 15/7/30.
 */
public class ddddd extends com.example.linuxsir.nanosimple.test.NanoHTTPD{
    public ddddd(int port) {
        super(port);
    }

    @Override
    public Response serve(String uri, Method method, Map<String, String> headers, Map<String, String> parms, Map<String, String> files) {
        return super.serve(uri, method, headers, parms, files);
    }
}
