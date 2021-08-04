module com.quimodotcom.voicemeeter
{
    requires com.stream_pi.action_api;
    requires org.kordamp.ikonli.javafx;
    
    requires com.sun.jna;

    provides com.stream_pi.action_api.externalplugin.ExternalPlugin with com.quimodotcom.voicemeeter.VoicemeeterVolume;
}