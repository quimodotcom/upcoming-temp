module com.quimodotcom.counteraction
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.counteraction.CounterAction;
}
