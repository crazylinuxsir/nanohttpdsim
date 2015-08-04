package com.example.linuxsir.nanosimple;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.linuxsir.nanosimple.test2.Nanoo;

import org.apache.http.conn.util.InetAddressUtils;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;


public class MainActivity extends Activity {

    private Simpleserver server;

    private TextView textView;


//    Nanoo nanoHTTPD;
//    int port = 8080;
//    File wwwroot;
//    String hostaddres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        server = new Simpleserver();
        try {

            // 因为程序模拟的是html放置在asset目录下，
            // 所以在这里存储一下AssetManager的指针。
//            server.asset_mgr = this.getAssets();

            // 启动web服务
            server.start();

            Log.i("Httpd", "The server started.");
        } catch(IOException ioe) {
            Log.w("Httpd", "The server could not start.");
        }

        textView = (TextView)findViewById(R.id.text);


//        try {
//            nanoHTTPD = new Nanoo(port, wwwroot);
//            hostaddres=nanoHTTPD.getLocalIpAddress();
//            Log.i("HttpdDDDDDDDDDDDDDDDDDD", hostaddres);
//        } catch (IOException ioe) {
//
//        }

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
//        if (nanoHTTPD != null)
//            nanoHTTPD.stop();
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
