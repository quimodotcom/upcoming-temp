package com.quimodotcom.screenshotaction;

import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import java.io.File;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.Robot;
import java.awt.Toolkit;
import javax.imageio.ImageIO;

public class ScreenshotAction extends NormalAction
{
    public ScreenshotAction()
    {
        setName("Screenshot");
        setAuthor("quimodotcom");
        setHelpLink("https://github.com/quimodotcom/essential-actions");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-folder-open");
        setCategory("System");
    }
    
    @Override
    public void onActionClicked() throws MinorException
    {
        try
        {
            screenshotnow();
        } catch (Exception e)
        {
            throw new MinorException(e.getMessage());
        }
    }
    
    public void screenshotnow() throws Exception {
        Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage capture = new Robot().createScreenCapture(screenRect);

        File imageFile = new File("single-screen.bmp");
        ImageIO.write(capture, "bmp", imageFile );
        imageFile.renameTo(new File(System.getProperty("user.dir") + "/Stream-Pi/image.bmp"));
    }
}
