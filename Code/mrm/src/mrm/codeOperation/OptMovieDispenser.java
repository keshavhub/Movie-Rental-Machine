package mrm.codeOperation;import java.awt.*;import java.awt.event.*;import store.Movies;class OptMovieDispenser extends Panel{       OptMovieDispenser()    {        setLayout(new GridLayout(1,1));        Button button= new Button("Renting");        button.setFont(new Font("SansSerif", Font.PLAIN, 12));        button.setForeground(new Color(0, 64, 0));        add(button);        button.setVisible(true);    }       public void animateDispensingCash(Movies amount)    {            button.setVisible(true);            try            {                 Thread.sleep(500);            }            catch (InterruptedException e)            { }            button.setVisible(false);            try            {                 Thread.sleep(500);            }            catch (InterruptedException e)            { }            button.setVisible(true);                    }           private Button button;}                                       