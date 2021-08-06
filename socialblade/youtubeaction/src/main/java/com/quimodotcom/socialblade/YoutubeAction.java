package com.quimodotcom.socialblade;

import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import java.util.ArrayList;
import java.util.Arrays;
import java.net.URISyntaxException;

import me.vinceh121.socialbladeapi.youtube.*;
import me.vinceh121.socialbladeapi.*;

public class YoutubeAction extends NormalAction
{
    public YoutubeAction() throws URISyntaxException
    {
        setName("YouTube Stats");
        setAuthor("quimodotcom");
        setHelpLink("https://www.twitch.tv/bigquimo");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-user-friends");
        setCategory("SocialBlade");
        
        list = new ArrayList<>();
        list.addAll(Arrays.asList(
                new ListValue("Daily Subscribers"),
                new ListValue("Daily Views"),
                new ListValue("Total Subscribers"),
                new ListValue("Total Views"),
                new ListValue("Total Uploads")
        ));
    }
    
    private final ArrayList<ListValue> list;
    
    @Override
    public void initProperties() throws MinorException
    {
        Property u = new StringProperty("user");
        u.setDisplayName("Socialblade Email");
        
        Property p = new StringProperty("pass");
        p.setDisplayName("Socialblade Password");
        
        Property c = new StringProperty("channel");
        c.setDisplayName("YouTube Channel");
        
        Property s = new Property("status", Type.LIST);
        s.setListValue(list);
        s.setDisplayName("Statistic Type");

        addClientProperties(u, p, c, s);
    }
    
    
    
    @Override
    public void onActionClicked() throws MinorException
    {
        try
        {
            SocialBlade sb = new SocialBlade();
            sb.login(getClientProperties().getSingleProperty("user").getStringValue(), getClientProperties().getSingleProperty("pass").getStringValue());
            
            YTStats stats = sb.statsYoutube(getClientProperties().getSingleProperty("channel").getStringValue());
            switch(getClientProperties().getSingleProperty("status").getListValue().toString())
            {
                case "Daily Subscribers":
                    setDisplayText(String.valueOf(stats.getAverageDailySubs()));
                    break;
                case "Daily Views":
                    setDisplayText(String.valueOf(stats.getAverageDailyViews()));
                    saveClientAction();
                    break;
                case "Total Subscribers":
                    setDisplayText(String.valueOf(stats.getSubs()));
                    saveClientAction();
                    break;
                case "Total Views":
                    setDisplayText(String.valueOf(stats.getViews()));
                    saveClientAction();
                    break;
                case "Total Uploads":
                    setDisplayText(String.valueOf(stats.getUploads()));
                    saveClientAction();
                    break;
                default:
                    throw new MinorException("Unknown Option/n Please refer to developer of plugin to fix this error!");
            }
        } catch (Exception e)
        {
            throw new MinorException(e.getMessage());
        }
    }
}