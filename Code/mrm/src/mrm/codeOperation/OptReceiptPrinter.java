package mrm.codeOperation;import java.awt.*;import java.awt.event.*;class OptReceiptPrinter extends Panel{        OptReceiptPrinter()    {        setLayout(new BorderLayout(2, 2));                               printArea =             new TextArea("", MRMPanel.PRINTABLE_LINES, MRMPanel.PRINTABLE_CHARS,                         TextArea.SCROLLBARS_VERTICAL_ONLY);        printArea.setBackground(Color.white);        printArea.setForeground(Color.black);        printArea.setFont(new Font("Monospaced", Font.PLAIN, 12));        printArea.setEditable(true);        add(printArea, BorderLayout.NORTH);                           Panel buttonPanel = new Panel();        buttonPanel.setLayout(new GridLayout(1,1));        take = new Button("Take receipt");        buttonPanel.add(take);        add(buttonPanel, BorderLayout.SOUTH);        take.addActionListener(new ActionListener() {            public void actionPerformed(ActionEvent e)            {                printArea.setText("");                take.setVisible(true);            }        });                take.setVisible(true);    }           void println(String text)    {        printArea.append(text + '\n');        try        {             Thread.sleep(1 * 100);        }        catch (InterruptedException e)        { }       take.setVisible(true);    }             private TextArea printArea;            private Button take;}                                       