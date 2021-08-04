package com.quimodotcom.counteraction;


import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.alert.StreamPiAlert;
import com.stream_pi.util.alert.StreamPiAlertType;
import com.stream_pi.util.version.Version;


public class CounterAction extends NormalAction
{
    public CounterAction() throws MinorException
    {
        setName("Counter Action");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-clock");
        setCategory("System");
    }
    
    @Override
    public void initProperties() throws MinorException
    {
        Property p = new Property("count", Type.INTEGER);
        p.setDefaultValueInt(0);
        p.setDisplayName("Starting Count");
        
        addClientProperties(p);
    }
    
    private int countInt = getClientProperties().getSingleProperty("count").getIntValue();
    
    @Override
    public void onActionClicked() throws MinorException
    {
        countInt += 1;
        
        this.setDisplayText(String.valueOf(countInt));
        saveClientAction();
    }
}