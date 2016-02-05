package mrm;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class AncestorDemo {

    public static void main(String args[]) {

  final JFrame jFrame = new JFrame();

  Container cPane = jFrame.getContentPane();

  JButton jButton = new JButton("Hide for 5 seconds!");

  ActionListener actListener = new ActionListener() {

@Override

public void actionPerformed(ActionEvent event) {

    jFrame.setVisible(false);

    TimerTask schedule = new TimerTask() {

  @Override

  public void run() {

jFrame.setVisible(true);

  }

    };

    Timer timer = new Timer();

    timer.schedule(schedule, 5000);

}

  };

  jButton.addActionListener(actListener);

  AncestorListener ancestorListener = new AncestorListener() {

@Override

public void ancestorAdded(AncestorEvent event) {

    System.out.println("Added");

    dumpInfo(event);

}

@Override

public void ancestorMoved(AncestorEvent event) {

    System.out.println("Moved");

    dumpInfo(event);

}

@Override

public void ancestorRemoved(AncestorEvent event ){

    System.out.println("Removed");

    dumpInfo(event);

}

private void dumpInfo(AncestorEvent event) {

    System.out.println("   Ancestor: " + name(event.getAncestor()));

    System.out.println("   AncestorParent: "

+ name(event.getAncestorParent()));

    System.out.println("   Component: " + name(event.getComponent()));

}

private String name(Container container) {

    return (container == null) ? null : container.getName();

}

  };

  jButton.addAncestorListener(ancestorListener);

  cPane.add(jButton, BorderLayout.NORTH);

  jFrame.setSize(500, 400);

  jFrame.setVisible(true);
    }
}
