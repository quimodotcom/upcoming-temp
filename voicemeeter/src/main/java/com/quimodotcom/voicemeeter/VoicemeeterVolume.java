package com.quimodotcom.voicemeeter;

import java.util.ArrayList;
import java.util.Arrays;

import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;



public class VoicemeeterVolume extends NormalAction
{
    private final float strip0GainDefault = 0.1f;
    
    public VoicemeeterVolume()
    {
        setName("Voicemeeter - ChangeVolume");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-file-audio");
        setCategory("Voicemeeter");
        
        new VoicemeeterVolume().init();
        
        states1 = new ArrayList<>();
        states1.addAll(Arrays.asList(
                new ListValue("+"),
                new ListValue("-")
        ));
        
        states2 = new ArrayList<>();
        states2.addAll(Arrays.asList(
                new ListValue("Input"),
                new ListValue("Output")
        ));
    }

    private final ArrayList<ListValue> states1;
    private final ArrayList<ListValue> states2;
    
    @Override
    public void initProperties() throws MinorException
    {
        Property status1 = new Property("status", Type.LIST);
        status1.setListValue(states1);
        status1.setDisplayName("Volume State");
        
        Property status2 = new Property("stripName", Type.LIST);
        status2.setListValue(states2);
        status2.setDisplayName("Hardware State");
        
        addClientProperties(status1, status2);
    }
    
    private void init()
    {
        Voicemeeter.init(true);
    }

    @Override
    public void onActionClicked() throws MinorException
    {
        String status1 = getClientProperties().getSingleProperty("status").getListValue().toString();
        String status2 = getClientProperties().getSingleProperty("stripName").getListValue().toString();
        try{
            if(status1 == "+")
        {
            if(status2 == "Input")
            {
                Voicemeeter.setParameterFloat("Strip[0].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[1].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[2].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[3].gain", strip0GainDefault);
                throw new MinorException("+, Input");
            }
            else if(status2 == "Output")
            {
                Voicemeeter.setParameterFloat("Bus[0].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[1].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[2].gain", strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[3].gain", strip0GainDefault);
                throw new MinorException("+, Output");
            }
        } 
        else if (status1 == "-")
        {
            if(status2 == "Input")
            {
                Voicemeeter.setParameterFloat("Strip[0].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[1].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[2].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Strip[3].gain", -strip0GainDefault);
                throw new MinorException("-, Input");
            }
            else if(status2 == "Output")
            {
                Voicemeeter.setParameterFloat("Bus[0].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[1].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[2].gain", -strip0GainDefault);
                Voicemeeter.setParameterFloat("Bus[3].gain", -strip0GainDefault);
                throw new MinorException("-, Output");
            }
        }
        } catch (Exception ex){
            throw new MinorException(ex.getMessage());
        }
    }
        
    public void volumeChange(String str, String str2) throws MinorException
    {
        
    }
}
