package com.sina.weibo.utils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;


import java.io.IOException;
import java.util.Iterator;
import java.util.Map;


public class MainActivity extends Activity {

    private Simpleserver server;

    private String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        server = new Simpleserver();



        //实现类(只举了一个例子)
        class Query implements Simpleserver.IMiniPlugin{
            @Override
            public boolean isMatch(String path, String referer) {

                return (path.equals("query"));

            }

            @Override
            public String dealRequest(String path, Map<String, String> param) {
                if (string!=null)
                    string="";

                for (Iterator iter = param.entrySet().iterator(); iter.hasNext(); ) {

                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

                    if (entry.getKey() != "NanoHttpd.QUERY_STRING") {

                        if(string==null)
                            string="key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                        else
                            string=string+"key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                    }
                }
                return string+ " path: " + path;
            }
        }


        //增加接口
        server.AddIMiniPlugin(new Query());


        try {

            // 启动web服务
            server.start();

            Log.i("Httpd", "The server started.");
        } catch(IOException ioe) {
            Log.w("Httpd", "The server could not start.");
        }




    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();

        if (server != null){
            // 在程序退出时关闭web服务器
            server.stop();
        }
        Log.w("Httpd", "The server stopped.");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
