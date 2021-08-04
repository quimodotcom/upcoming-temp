package com.quimodotcom.stopwatchaction;


import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;

public class StopwatchAction extends NormalAction
{
    public StopwatchAction()
    {
        setName("Stopwatch Action");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-clock");
        setCategory("System");
    }
    
    private boolean status = false;
    private StopWatch s = new StopWatch();


    @Override
    public void onActionClicked() throws MinorException
    {
        if(status != true)
        {
            start();
        }
        else
        {
            stop();
        }
    }
    
    private void start() throws MinorException
    {
        status = true;
        s.start();
        while(status)
        {
            try
            {
                long time = s.getTime() / 1000;
                setDisplayText(Long.toString(time));
                saveClientAction();
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception ex){
                throw new MinorException(ex.getMessage());
            }
        }
    }
    
    private void stop()
    {
        status = false;
        s.stop();
    }
}