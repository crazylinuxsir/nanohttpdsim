package com.sina.weibo.utils;


import java.util.*;

/**
 * Created by linuxsir on 15/7/29.
 */
public class Simpleserver extends com.sina.weibo.utils.weibohttpd.NanoHTTPD  {



    List<IMiniPlugin> list=new ArrayList<IMiniPlugin>();



    private String path;

    private String back;


    public Simpleserver() {

        // 端口是8088，也就是说要通过http://127.0.0.1:8088来访当问

        super(8088);

        
    }

    public Response serve(String uri, Method method,
                          Map<String, String> header,
                          Map<String, String> parameters,
                          Map<String, String> files)
    {

        //判断连接ip是否为本地
        String client=header.get("http-client-ip");
        if(!client.equals("127.0.0.1"))
            return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");



        //判断跳转页Referer
        String referer=header.get("referer");
        if(referer==null){
            //添加所需逻辑
        }




       /**
        * START
        */
        path = uri.substring(1);

        for(IMiniPlugin im : list){
            if(im.isMatch(path,referer)){
                back=im.dealRequest(path,parameters);
                if(back!=null)
                    return new com.sina.weibo.utils.weibohttpd.NanoHTTPD.Response(back);
                return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");
            }

        }

        //没有所匹配的接口返回404
        return new Response(Response.Status.NOT_FOUND, MIME_PLAINTEXT, "Not Found");

        /**
         * END
         */



    }


    //接口
    public interface IMiniPlugin {
         boolean isMatch( String path , String referer);

         String dealRequest( String path, Map<String, String> param );
    }





    //添加不同的接口实现类
    public void AddIMiniPlugin(IMiniPlugin iMiniPlugin){

        list.add(iMiniPlugin);

    }




}



