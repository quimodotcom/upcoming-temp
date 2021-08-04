module com.quimodotcom.discord.sendmessage
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires discord.webhooks;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.discord.sendmessage.SendMessageAction;
}
