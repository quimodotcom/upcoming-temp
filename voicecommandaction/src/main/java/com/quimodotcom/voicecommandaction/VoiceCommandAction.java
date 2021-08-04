package com.quimodotcom.voicecommandaction;


import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import edu.cmu.sphinx.api.Configuration;

public class VoiceCommandAction extends NormalAction
{
    public VoiceCommandAction()
    {
        setName("Voice Command Action");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-microphone");
        setCategory("System");
    }
    
    public static Configuration config = new Configuration();
    
    @Override
    public void onActionClicked() throws MinorException
    {
        try
        {
            VoiceAssistant a = new VoiceAssistant();
            a.main();
        } catch (Exception ex)
        {
            throw new MinorException(ex.getMessage());
        }
		
    }
}