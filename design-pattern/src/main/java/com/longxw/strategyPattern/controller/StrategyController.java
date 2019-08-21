package com.longxw.strategyPattern.controller;

import com.longxw.strategyPattern.api.IStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.net.JarURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

@RestController
@RequestMapping("/strategy")
public class StrategyController {

    @Autowired
    IStrategy iStrategy;

    @GetMapping("/test")
    public String test(String type){
        return iStrategy.readContext(type);
    }

    @GetMapping("/demo")
    public void demo(){
        String defaultPath = "classpath:script/sql";
        try {
            URL url = ResourceUtils.getURL(defaultPath);
            File[] sqlDir;
            if(ResourceUtils.isJarURL(url)){
                readJarFile(url);
                sqlDir = null;
            }else{
                sqlDir = new File(url.getPath()).getCanonicalFile().listFiles();
            }

            /*for(File item : sqlDir){
                System.out.println(item.getName()+":"+item.isDirectory());
            }*/
            System.out.println(url);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readJarFile(URL url){
        JarFile jar;
        try {
            jar = ((JarURLConnection) url.openConnection()).getJarFile();
            Enumeration<JarEntry> entries = jar.entries();
            while (entries.hasMoreElements()){
                JarEntry entry = entries.nextElement();
                String name = entry.getName();
                System.out.println(name);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
