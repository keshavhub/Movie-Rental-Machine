
import java.awt.*;
import java.applet.Applet;

import mrm.MRM;
import mrm.codeOperation.Operations;

 
public class MRMApplet extends Applet
{
    public void init()
    {
      
        
        MRM theMRM = new MRM(1, "CSULB", "Movies Rental Machine", null );
        Operations theSimulation = new Operations(theMRM);
        
        new Thread(theMRM).start();
        
     
        Panel gui = theSimulation.getGUI();
        setBackground(gui.getBackground());
        add(gui);
    }
}
    