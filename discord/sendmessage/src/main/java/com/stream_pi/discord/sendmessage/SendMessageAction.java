package com.quimodotcom.discord.sendmessage;

import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import club.minnced.discord.webhook.send.*;
import club.minnced.discord.webhook.*;

public class SendMessageAction extends NormalAction
{
    public SendMessageAction()
    {
        setName("Webhook - Send Message");
        setAuthor("quimodotcom");
        setHelpLink("https://discord.com/developers/applications");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-discord");
        setCategory("Discord");
    }
    
    @Override
    public void initProperties() throws MinorException 
    {
        Property p = new StringProperty("webhookURL");
        p.setDisplayName("Webhook URL");
        
        Property m = new StringProperty("message");
        m.setDisplayName("Message");
        
        addClientProperties(p, m);
    }
    
    @Override
    public void onActionClicked() throws MinorException
    {
        WebhookClient client = WebhookClient.withUrl(getClientProperties().getSingleProperty("webhookURL").getStringValue());
        
        // Send and log (using embed)
        WebhookEmbed embed = new WebhookEmbedBuilder()
            .setColor(0xFF00EE)
            .setDescription(getClientProperties().getSingleProperty("message").getStringValue())
            .build();
        client.send(embed);
    }
}