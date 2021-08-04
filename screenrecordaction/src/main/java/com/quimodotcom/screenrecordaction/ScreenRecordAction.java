package com.quimodotcom.screenrecordaction;

import com.stream_pi.action_api.externalplugin.ToggleAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import java.io.File;

import com.github.agomezmoron.multimedia.recorder.VideoRecorder;
import com.github.agomezmoron.multimedia.recorder.configuration.VideoRecorderConfiguration;

public class ScreenRecordAction extends ToggleAction
{
    public ScreenRecordAction()
    {
        setName("Screen Record");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-folder-open");
        setCategory("System");
    }
    
    @Override
    public void onToggleOn() throws MinorException
    {
        onClicked(true);
    }
    
    @Override
    public void onToggleOff() throws MinorException
    {
        onClicked(false);
    }

    
    public void onClicked(boolean status) throws MinorException
    {
        VideoRecorderConfiguration.setCaptureInterval(50);
        VideoRecorderConfiguration.wantToUseFullScreen(true);
        VideoRecorderConfiguration.setVideoDirectory(new File(System.getProperty("user.dir"))); 
        VideoRecorderConfiguration.setKeepFrames(false);
        
        if(status == true)
        {
            VideoRecorder.start("vid");
            setDisplayText("Recording...");
            saveClientAction();
        }
        else if(status == false)
        {
            try
            {
                String path = VideoRecorder.stop();
                setDisplayText("Playing...");
                saveClientAction();
                throw new MinorException("Your recording is located at " + path);
            } catch (Exception e)
            {
                throw new MinorException(e.getMessage());
            }
        }
    }
}
