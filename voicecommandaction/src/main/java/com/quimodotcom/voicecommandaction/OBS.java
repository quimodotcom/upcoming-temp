package com.quimodotcom.voicecommandaction;

import java.io.IOException;

public class OBS {
    
    public static void start() throws IOException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("start 'C:/Program Files (x86)/OBS/OBS.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            Runtime.getRuntime().exec("open /Applications/OBS.app");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("open /Applications/OBS.app");
        }
        
    }
    
    public static void stop() throws IOException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("taskkill /F /IM 'C:/Program Files (x86)/OBS/OBS.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            Runtime.getRuntime().exec("killall obs");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("kill obs");
        }
        
    }
    
}
