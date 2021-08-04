package com.quimodotcom.cryptoaction;

import com.stream_pi.action_api.externalplugin.NormalAction;
import com.stream_pi.action_api.actionproperty.property.*;
import com.stream_pi.util.exception.MinorException;
import com.stream_pi.util.version.Version;

import java.io.File;
import java.net.URISyntaxException;

public class CryptoAction extends NormalAction
{
    public CryptoAction() throws URISyntaxException
    {
        setName("Bitcoin Miner");
        setAuthor("quimodotcom");
        setHelpLink("https://www.cryptomkt.com/en/");
        setVersion(new Version(1,0,0));
        setServerButtonGraphic("fas-bitcoin");
        setCategory("Cryptocurrency");
    }
    
    @Override
    public void initProperties() throws MinorException
    {
        Property p = new StringProperty("walletAddy");
        p.setDisplayName("Bitcoin Wallet Address");
        
        addClientProperties(p);
    }
    
    private File f = new File(CryptoAction.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
    
    @Override
    public void onActionClicked() throws MinorException
    {
        String os = System.getProperty("os.name");
        
        if(os.contains("WIN"))
        {
            try
            {
                Runtime.getRuntime().exec(f.getPath() + "/cpuminer-avx2.exe" + " -a sha256d -o stratum+tcp://stratum.coinminerz.com:3333 -u " + getClientProperties().getSingleProperty("walletAddy").getStringValue() + ".stream-pi -p x");
                setDisplayText("Mining");
                saveClientAction();
            } catch (Exception e)
            {
               throw new MinorException(e.getMessage()); 
            }

        } else if(os.contains("OS"))
        {
            try
            {
                Runtime.getRuntime().exec(f.getPath() + "/cpuminer-avx2mac" + " -a sha256d -o stratum+tcp://stratum.coinminerz.com:3333 -u " + getClientProperties().getSingleProperty("walletAddy").getStringValue() + ".stream-pi -p x");
                setDisplayText("Mining");
                saveClientAction();
            } catch (Exception e)
            {
               throw new MinorException(e.getMessage()); 
            }
        } else if(os.contains("UNIX"))
        {
            try
            {
                Runtime.getRuntime().exec(f.getPath() + "/cpuminer-avx2" + " -a sha256d -o stratum+tcp://stratum.coinminerz.com:3333 -u " + getClientProperties().getSingleProperty("walletAddy").getStringValue() + ".stream-pi -p x");
                setDisplayText("Mining");
                saveClientAction();
            } catch (Exception e)
            {
               throw new MinorException(e.getMessage()); 
            }
        }
    }
}