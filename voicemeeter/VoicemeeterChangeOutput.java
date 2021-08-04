package com.stream_pi.voicemeeter;

import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.alert.StreamPiAlert;
import com.stream_pi.util.alert.StreamPiAlertType;
import com.stream_pi.util.version.Version;



public class VoicemeeterChangeOutput extends NormalAction
{
    
    public VoicemeeterChangeOutput()
    {
        setName("Voicemeeter - Change Output");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-file-audio");
        setCategory("Voicemeeter");
    }

    
    @Override
    public void initProperties() throws MinorException
    {
        Property hardware = new StringProperty("hardware");
        hardware.setDisplayName("Hardware Device Name");
        
        addClientProperties(hardware);
    }

    @Override
    public void onActionClicked() throws MinorException
    {
        String hardware = getClientProperties().getSingleProperty("hardware").getStringValue();
        try{
            Voicemeeter.setParametersW("Bus[0].device.wdm= " + hardware);
        } catch (Exception ex){
            throw new MinorException(ex.getMessage());
        }
    }
}
