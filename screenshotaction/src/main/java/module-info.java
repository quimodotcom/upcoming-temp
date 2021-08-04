module com.quimodotcom.screenshot
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires java.desktop;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.screenshotaction.ScreenshotAction;
}