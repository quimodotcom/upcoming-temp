package com.quimodotcom.voicecommandaction;

import java.io.IOException;
import com.stream_pi.util.exception.MinorException;

public class Steam {
    
    public static void start() throws IOException, MinorException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("start 'C:/Program Files (x86)/Steam/steam.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            Runtime.getRuntime().exec("open /Applications/Steam.app'");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("");
        }
        
    }
    
    public static void stop() throws IOException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("taskkill /F /IM 'C:/Program Files (x86)/Steam/steam.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            Runtime.getRuntime().exec("killall steam");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("kill steam");
        }
        
    }
    
}
