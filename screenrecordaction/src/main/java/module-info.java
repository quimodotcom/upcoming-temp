module com.quimodotcom.screenrecordaction
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires screen.recorder;
    
    requires java.desktop;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.screenrecordaction.ScreenRecordAction;
}