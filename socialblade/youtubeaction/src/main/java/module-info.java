module com.quimodotcom.socialblade
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires socialblade.api;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.socialblade.YoutubeAction;
}
