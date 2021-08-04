module com.quimodotcom.stopwatchaction
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires org.apache.commons.lang3;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.stopwatchaction.StopwatchAction;
}
