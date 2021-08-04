package com.quimodotcom.voicecommandaction;

import com.stream_pi.util.exception.MinorException;
import edu.cmu.sphinx.api.LiveSpeechRecognizer;
import edu.cmu.sphinx.api.SpeechResult;
import edu.cmu.sphinx.api.Configuration;
import java.awt.Desktop;
import java.net.URI;
import java.io.IOException;

public class VoiceAssistant
{
    public void main() throws MinorException, IOException
    {
        Configuration config = VoiceCommandAction.config;
	config.setDictionaryPath(getClass().getClassLoader().getResource("0277.dic").getFile());
	config.setLanguageModelPath(getClass().getClassLoader().getResource("0277.lm").getFile());
        
        LiveSpeechRecognizer speech = new LiveSpeechRecognizer(config);
        speech.startRecognition(true);
        SpeechResult speechResult = null;
			
        while ((speechResult = speech.getResult()) != null) {
        String voiceCommand = speechResult.getHypothesis();

        if (voiceCommand.equalsIgnoreCase("Open Browser")) {
            try{
                Desktop.getDesktop().browse(new URI("http://www.google.com"));
            } catch(Exception e){
                throw new MinorException(e.getMessage());
            }
        } else if (voiceCommand.equalsIgnoreCase("Open OBS")) {
            OBS.start();
        } else if(voiceCommand.equalsIgnoreCase("Close OBS")) {
            OBS.stop();
        } else if(voiceCommand.equalsIgnoreCase("Open Voicemeter")) {
            Voicemeeter.start();
        } else if(voiceCommand.equalsIgnoreCase("Close Voicemeter")) {
            Voicemeeter.stop();
        } else if(voiceCommand.equalsIgnoreCase("Open Youtube")) {
            try{
                Desktop.getDesktop().browse(new URI("http://www.youtube.com"));
            } catch(Exception e){
                throw new MinorException(e.getMessage());
            }
        } else if(voiceCommand.equalsIgnoreCase("Open Steam")) {
            Steam.start();
        } else if(voiceCommand.equalsIgnoreCase("Close Steam")) {
            Steam.stop();
        }
        speech.startRecognition(false);
        }
    }
}
