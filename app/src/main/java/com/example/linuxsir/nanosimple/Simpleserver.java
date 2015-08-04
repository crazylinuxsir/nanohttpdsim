package com.example.linuxsir.nanosimple;

import android.content.res.AssetManager;
import android.util.Log;


import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Created by linuxsir on 15/7/29.
 */
public class Simpleserver extends com.example.linuxsir.nanosimple.test.NanoHTTPD  {


    private Inface inface;

    private String path;

    private String back;


    public Simpleserver() {

        // 端口是8088，也就是说要通过http://127.0.0.1:8088来访当问

        super(8088);

        inface = new Inface();
        
    }

    public Response serve(String uri, Method method,
                          Map<String, String> header,
                          Map<String, String> parameters,
                          Map<String, String> files)
    {
        String s=header.get("http-client-ip");
        if(!s.equals("127.0.0.1"))
            return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");

       /**
        * START
        */

        path = uri.substring(1);

        int i=1;


        switch (i)
        {
            case 1:
                if(inface.queryismatch(path)) {
                    back=inface.querycontent(path,parameters);
                    if(back!=null)
                        return new com.example.linuxsir.nanosimple.test.NanoHTTPD.Response(back);
                    return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
                }
            case 2:
                if(inface.serverismatch(path)) {
                    back=inface.querycontent(path,parameters);
                    if(back!=null)
                        return new com.example.linuxsir.nanosimple.test.NanoHTTPD.Response(back);
                    return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
                }
            case 3:
                if(inface.setismatch(path)) {
                    back=inface.querycontent(path,parameters);
                    if(back!=null)
                        return new com.example.linuxsir.nanosimple.test.NanoHTTPD.Response(back);
                    return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
                }
            case 4:
                if(inface.startActivityismatch(path)) {
                    back=inface.querycontent(path,parameters);
                    if(back!=null)
                        return new com.example.linuxsir.nanosimple.test.NanoHTTPD.Response(back);
                    return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
                }
            default:
                return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
        }
        /**
         * END
         */



    }

}
