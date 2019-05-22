package com.styd.config;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class ApiName {
    public static Properties prop = null;

    public static void main(String args[]){

        if(prop == null){
            prop = new Properties();
            try {
                ClassPathResource classPathResource = new ClassPathResource("resource/ApiName.properties");
                prop.load(new InputStreamReader(classPathResource.getInputStream(),"gbk"));
            }catch (IOException e){
                e.printStackTrace();
            }
}
