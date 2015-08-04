package com.example.linuxsir.nanosimple;

import android.util.Log;

import java.util.Iterator;
import java.util.Map;

/**
 * Created by linuxsir on 15/7/30.
 */
public class Inface implements Finder {

    String string;

    @Override
    public boolean queryismatch(String path) {
        return (path.equals("query"));
    }

    @Override
    public String querycontent(String path, Map parms) {

        if (string!=null)
            string="";

        for (Iterator iter = parms.entrySet().iterator(); iter.hasNext(); ) {

                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

                if (entry.getKey() != "NanoHttpd.QUERY_STRING") {

                    if(string==null)
                        string="key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                    else
                        string=string+"key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                    //return "key: " + entry.getKey() + " value: " + entry.getValue() + " path: " + path;
                   // System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
                }
            }
        return string+ " path: " + path;
    }

    @Override
    public boolean setismatch(String path) {
        return (path.equals("set"));
    }

    @Override
    public String setcontent(String path, Map parms) {

        if (string!=null)
            string="";

        for (Iterator iter = parms.entrySet().iterator(); iter.hasNext(); ) {

            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

            if (entry.getKey() != "NanoHttpd.QUERY_STRING") {

                if(string==null)
                    string="key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                else
                    string=string+"key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                //return "key: " + entry.getKey() + " value: " + entry.getValue() + " path: " + path;
                // System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }
        return string+ " path: " + path;
    }

    @Override
    public boolean serverismatch(String path) {
        return (path.equals("server"));
    }

    @Override
    public String servercontent(String path, Map parms) {

        if (string!=null)
            string="";

        for (Iterator iter = parms.entrySet().iterator(); iter.hasNext(); ) {

            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

            if (entry.getKey() != "NanoHttpd.QUERY_STRING") {

                if(string==null)
                    string="key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                else
                    string=string+"key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                //return "key: " + entry.getKey() + " value: " + entry.getValue() + " path: " + path;
                // System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }
        return string+ " path: " + path;
    }

    @Override
    public boolean startActivityismatch(String path) {
        return (path.equals("startActivity"));
    }

    @Override
    public String startActivitycontent(String path, Map parms) {

        if (string!=null)
            string="";

        for (Iterator iter = parms.entrySet().iterator(); iter.hasNext(); ) {

            Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();

            if (entry.getKey() != "NanoHttpd.QUERY_STRING") {

                if(string==null)
                    string="key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                else
                    string=string+"key: " + entry.getKey() + " value: " + entry.getValue()+" ";
                //return "key: " + entry.getKey() + " value: " + entry.getValue() + " path: " + path;
                // System.out.println("key: " + entry.getKey() + " value: " + entry.getValue());
            }
        }
        return string+ " path: " + path;


        /*

         */
    }

    //private Query dd;
}
