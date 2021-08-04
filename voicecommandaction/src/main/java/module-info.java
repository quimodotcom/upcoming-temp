module com.quimodotcom.voicecommandaction {
    
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires java.desktop;
    
    requires sphinx4.core;
    requires sphinx4.data;
    
    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.voicecommandaction.VoiceCommandAction;
}
