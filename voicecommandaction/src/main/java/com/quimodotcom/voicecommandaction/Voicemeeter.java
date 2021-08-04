package com.quimodotcom.voicecommandaction;

import java.io.IOException;
import com.stream_pi.util.exception.MinorException;

public class Voicemeeter {
    
    public static void start() throws IOException, MinorException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("start 'C:/Program Files (x86)/VB/voicemeeter.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            throw new MinorException("Voicemeeter is not supported on macOS");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("Voicemeeter is not supported on Linux");
        }
        
    }
    
    public static void stop() throws IOException
    {
        if(System.getProperty("os.name").contains("WINDOWS"))
        {
            Runtime.getRuntime().exec("taskkill /F /IM 'C:/Program Files (x86)/VB/voicemeeter.exe'");
        } else if(System.getProperty("os.name").contains("OSX"))
        {
            Runtime.getRuntime().exec("Voicemeeter is not supported on macOS");
        } else if(System.getProperty("os.name").contains("UNIX"))
        {
            Runtime.getRuntime().exec("Voicemeeter is not supported on Linux");
        }
        
    }
    
}
