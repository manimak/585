import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

class ReadDialog extends JInternalFrame {

    private static ReadDialog instance = null;

    int lines = 0;
    private JLabel lbl, lbl2,lb3;
    private JTextField tf;
    private JTextField tf1;
    private String word;
    private JButton fileBtn, readBtn;
    private JFileChooser fc;
    private String fileName;   
    private Task task;
    private JProgressBar progressBar;
    private JFrame frame; // to properly center JDialogFrame
    private int numOfTimeProcessGotCalled;

    public static ReadDialog getInstance(JFrame frame) {
        if(instance == null) {
            instance = new ReadDialog(frame);
        }
        return instance;   
    }


    class Task extends SwingWorker<Void, String> {
        /*
        * Main task. Executed in background thread.
        */
        @Override
        public Void doInBackground() {
            if(fileName.equals("")) {
                JOptionPane.showMessageDialog(frame, "Choose a folder!");
                return null;
            }
            progressBar.setIndeterminate(true);
            lbl2.setText("");
            try {
                word = tf1.getText();
                String fileLine = "";
                FileReader data = new FileReader(fileName);
                BufferedReader br = new BufferedReader(data);
                while((fileLine = br.readLine()) != null) {
                    if(fileLine.contains(word)) {
                    //System.out.println("Number of lines: " + String.valueOf(lines));
                    //System.out.println("Number of lines: " + word);
                    lbl2.setText(String.valueOf(lines));
                    publish(String.valueOf(lines));
                    lines++;
                   }
                }
                lbl2.setText(String.valueOf(lines));
                // close the file
                br.close();
            }
            catch(FileNotFoundException ex) {
                JOptionPane.showMessageDialog(frame, "File not found!");
            }
            catch(IOException ex) {
                JOptionPane.showMessageDialog(frame, "An error occured");
            }
            return null;
        }

        @Override
        protected void process(List<String> chunks) {
            // Messages received from the doInBackground() (when invoking the publish() method)
            //System.out.println("in process (called by doInBackground), setting label to: " + String.valueOf(chunks.get(chunks.size()-1)));
            //lbl2.setText(String.valueOf(chunks.get(chunks.size()-1)));
            //System.out.println("in process (called by doInBackground): numOfTimeProcessGotCalled = " + numOfTimeProcessGotCalled);
        }

        /*
        * Executed in event dispatch thread
        */
        @Override
        public void done() {
            progressBar.setIndeterminate(false);
            readBtn.setEnabled(true);
            System.out.println("numOfTimeProcessGotCalled: " + numOfTimeProcessGotCalled);

        }
    }

    private void chooseFile() {
        lbl2.setText("");
        fileName = "";
        fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        int returnVal = fc.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            tf.setText(file.getAbsolutePath());
            fileName = file.getAbsolutePath();

        } else {
            JOptionPane.showMessageDialog(this, "Open command cancelled by user.");
        }   
    }
    public void walk(String absolutePath) {
        File root = new File( absolutePath);
        File[] list = root.listFiles();

        if (list == null) return;
        for ( File f : list ) {
            if ( f.isDirectory() ) {
                walk( f.getAbsolutePath() );
               // System.out.println(absolutePath);

            }
            else {

                fileName = f.getAbsolutePath();
                //System.out.println(fileName);
                if(fileName.endsWith(".txt")){
                    //System.out.println(fileName);
                    progressBar.setIndeterminate(true);
                    readBtn.setEnabled(false);
                    task = new Task();
                    task.execute();
                }

            }
        }
    }

    private ReadDialog(JFrame frame) {

        super("Folder Info", false, true, false, false);
        this.frame = frame;
        // init
        tf1 = new JTextField(45);
        tf = new JTextField(50);
        tf.setEditable(false);
        fileBtn = new JButton("...");
        readBtn = new JButton("Read");
        lb3 = new JLabel("Word: ");
        lbl = new JLabel("Number of words: ");
        lbl2 = new JLabel();
        fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        //fc.addChoosableFileFilter(new FileNameExtensionFilter("Text Files", "txt"));
        progressBar = new JProgressBar(0, 100);
        //Call setStringPainted now so that the progress bar height
        //stays the same whether or not the string is shown.
        progressBar.setStringPainted(false);      
        fileName = "";    
        
        fileBtn.setPreferredSize(new Dimension(20, 20));
        readBtn.setPreferredSize(new Dimension(80, 20));
        
        JPanel upperPanel = new JPanel();
        JPanel midPanel = new JPanel();
        JPanel lowerPanel = new JPanel();
        
        upperPanel.setLayout(new FlowLayout());
        midPanel.setLayout(new FlowLayout());
        lowerPanel.setLayout(new FlowLayout());

        upperPanel.add(tf);
        upperPanel.add(fileBtn);
        upperPanel.add(readBtn);
        midPanel.add(lb3);
        midPanel.add(tf1);
        midPanel.add(progressBar);
        
        lowerPanel.add(lbl);
        lowerPanel.add(lbl2);
        
        add(upperPanel, BorderLayout.NORTH);
        add(midPanel, BorderLayout.CENTER);
        add(lowerPanel, BorderLayout.SOUTH);  

        // add button listener
        fileBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) { 
                chooseFile();
            } 
        });   

        // add button listener
        readBtn.addActionListener(new ActionListener() { 
            public void actionPerformed(ActionEvent e) {

               // readBtn.setEnabled(false);
                walk(fileName);
                //task = new Task();
                //task.addPropertyChangeListener(this);
                //task.execute();

            } 
        });      
        
        pack();
        setBounds(25, 25, 700, 150);
        setLocation(50, 50);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
}
