// abstract window toolkit (awt)
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Cursor;

// awt events
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

// swing
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JDesktopPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.JInternalFrame;
import javax.swing.SwingUtilities;

// swing event
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;

// swing tree
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

public class GUIApp {

    private JFrame frame;
    private JPanel panel;
    private JScrollPane scrollPane;
    private JDesktopPane desktop;
    private JSplitPane splitPane;
    private JPanel labelPanel;
    private JLabel statusLabel;
    private JTree tree;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenu helpMenu;
    private JMenuItem exitItem;
    private JMenuItem aboutItem;

    // constructor
    public GUIApp() {
        initComponents();
        statusLabel.setText("Initialization complete.");
    }

    private void exitActionPerformed() {
        frame.dispose();
    }

    private void aboutActionPerformed() {
        JOptionPane.showMessageDialog(null, "Hey, thanks for using my app!");
    }

    private void treeClicked() {
        
        // get the last selected tree node
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)
        tree.getLastSelectedPathComponent();

        // if the node is a leaf (no children, keep going)
        if (node != null && node.isLeaf()) {
            
            statusLabel.setText(node.toString() + " clicked.");
            
            if(node.toString().equals("Odd")) {
                OddDialog od = OddDialog.getInstance();
                if(!od.isVisible()) { 
                    od.setVisible(true);
                    desktop.add(od);               
                }                       
            }
            else if(node.toString().equals("Even")) {
                EvenDialog even = EvenDialog.getInstance();
                if(!even.isVisible()) {
                    even.setVisible(true);
                    desktop.add(even);
                }
            }
            else if(node.toString().equals("Multiplied3")) {
                ThreeDialog M3 = ThreeDialog.getInstance();
                if (!M3.isVisible()) {
                    M3.setVisible(true);
                    desktop.add(M3);
                }
            }
            else if(node.toString().equals("GCD")) {
                GcdDialog gcd = GcdDialog.getInstance();
                if(!gcd.isVisible()) {
                    gcd.setVisible(true);
                    desktop.add(gcd);
                }
            }
            else if(node.toString().equals("Fibonacci")) {
                FebDialog feb = FebDialog.getInstance();
                if(!feb.isVisible()) {
                    feb.setVisible(true);
                    desktop.add(feb);
                }
            }
            else if(node.toString().equals("Factorial")) {
                FacDialog fac = FacDialog.getInstance();
                if(!fac.isVisible()) {
                    fac.setVisible(true);
                    desktop.add(fac);
                }
            }
            else if(node.toString().equals("Cenrigal to decigal")) {
                CTdDialog ctd = CTdDialog.getInstance();
                if(!ctd.isVisible()) {
                    ctd.setVisible(true);
                    desktop.add(ctd);
                }
            }
            else if(node.toString().equals("Decigal to foot")) {
                DTfDialog dtf = DTfDialog.getInstance();
                if(!dtf.isVisible()) {
                    dtf.setVisible(true);
                    desktop.add(dtf);
                }
            }
            else if(node.toString().equals("Foot to gn")) {
                FTgDialog ftg = FTgDialog.getInstance();
                if(!ftg.isVisible()) {
                    ftg.setVisible(true);
                    desktop.add(ftg);
                }
            }
            else if(node.toString().equals("Radian to degree")) {
                RTdDialog rtd = RTdDialog.getInstance();
                if(!rtd.isVisible()) {
                    rtd.setVisible(true);
                    desktop.add(rtd);
                }
            }
            else if(node.toString().equals("Degree to second")) {
                DTsDialog dts = DTsDialog.getInstance();
                if(!dts.isVisible()) {
                    dts.setVisible(true);
                    desktop.add(dts);
                }
            }
            else if(node.toString().equals("Second to full circle")) {
                STfDialog stf = STfDialog.getInstance();
                if(!stf.isVisible()) {
                    stf.setVisible(true);
                    desktop.add(stf);
                }
            }
            else if(node.toString().equals("Cent/Sec to Inch/Sec")) {
                CTiDialog cti = CTiDialog.getInstance();
                if(!cti.isVisible()) {
                    cti.setVisible(true);
                    desktop.add(cti);
                }
            }
            else if(node.toString().equals("Inch/Sec to Mete/Sec")) {
                ITmDialog itm = ITmDialog.getInstance();
                if(!itm.isVisible()) {
                    itm.setVisible(true);
                    desktop.add(itm);
                }
            }
            else if(node.toString().equals("File Info")) {
                ReadDialog rd = ReadDialog.getInstance(frame);
                if(!rd.isVisible()) { 
                    rd.setVisible(true);           
                    desktop.add(rd);
                } 
            }

        } // end if isLeaf

    } // end treeClicked

    private void setLookAndFeel() {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildDesktop() {

        desktop = new JDesktopPane()
        {
            @Override
            protected void paintComponent(Graphics g)
            {
                ImageIcon icon = new ImageIcon("images/csun_logo.png");
                Image image = icon.getImage();

                int x=0, y=0;
                double imageWidth = image.getWidth(null);
                double imageHeight = image.getHeight(null);
                double screenWidth = getWidth();
                double screenHeight = getHeight();

                if(screenWidth != 0) {
                    x = (int)screenWidth  / 2 - (int)imageWidth  / 2;
                }
                
                if(screenHeight != 0) {
                    y = (int)screenHeight / 2 - (int)imageHeight / 2;
                }
                
                g.drawImage(image, x, y, this);
            }  
        };

    } // end buildDesktop

    private void buildTree() {

        // Create data for the tree
        DefaultMutableTreeNode root
        = new DefaultMutableTreeNode("Tools");

        DefaultMutableTreeNode alg
        = new DefaultMutableTreeNode("Algorithms");

        DefaultMutableTreeNode spe
        = new DefaultMutableTreeNode("Speed");
        DefaultMutableTreeNode CTi
        = new DefaultMutableTreeNode("Cent/Sec to Inch/Sec");
        DefaultMutableTreeNode ITm
        = new DefaultMutableTreeNode("Inch/Sec to Mete/Sec");

        DefaultMutableTreeNode itr
        = new DefaultMutableTreeNode("Iterative");
        DefaultMutableTreeNode odd
        = new DefaultMutableTreeNode("Odd");
        DefaultMutableTreeNode even
        = new DefaultMutableTreeNode("Even");
        DefaultMutableTreeNode threeM
        = new DefaultMutableTreeNode("Multiplied3");


        DefaultMutableTreeNode rec
        = new DefaultMutableTreeNode("Recursive");
        DefaultMutableTreeNode gcd
        = new DefaultMutableTreeNode("GCD");
        DefaultMutableTreeNode fib
        = new DefaultMutableTreeNode("Fibonacci");
        DefaultMutableTreeNode fac
        = new DefaultMutableTreeNode("Factorial");

        DefaultMutableTreeNode acc
        = new DefaultMutableTreeNode("Acceleration");
        DefaultMutableTreeNode cTd
        = new DefaultMutableTreeNode("Cenrigal to decigal");
        DefaultMutableTreeNode dTf
        = new DefaultMutableTreeNode("Decigal to foot");
        DefaultMutableTreeNode fTgn
        = new DefaultMutableTreeNode("Foot to gn");

        DefaultMutableTreeNode ang
        = new DefaultMutableTreeNode("Angles");
        DefaultMutableTreeNode rTd
        = new DefaultMutableTreeNode("Radian to degree");
        DefaultMutableTreeNode dTs
        = new DefaultMutableTreeNode("Degree to second");
        DefaultMutableTreeNode sTfc
        = new DefaultMutableTreeNode("Second to full circle");


        DefaultMutableTreeNode io
        = new DefaultMutableTreeNode("IO");
        DefaultMutableTreeNode fileInfo
        = new DefaultMutableTreeNode("File Info");

        spe.add(CTi);
        spe.add(ITm);

        ang.add(rTd);
        ang.add(dTs);
        ang.add(sTfc);

        acc.add(cTd);
        acc.add(dTf);
        acc.add(fTgn);

        itr.add(odd);
        itr.add(even);
        itr.add(threeM);

        rec.add(gcd);
        rec.add(fib);
        rec.add(fac);

        alg.add(itr);
        alg.add(rec);
        alg.add(acc);
        alg.add(ang);
        alg.add(spe);

        io.add(fileInfo);

        root.add(alg);
        root.add(io);

        // create a new tree
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

    } // buildTree

    private void addTreeListeners() {

        tree.addMouseMotionListener(
        new MouseAdapter() {
            
            @Override
            public void mouseExited(MouseEvent e) {
                ((JTree)e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseMoved(MouseEvent e) {              
                TreePath pathForLocation = tree.getPathForLocation(e.getX(), e.getY());
                if(pathForLocation != null) {
                    Object lastPathComponent = pathForLocation.getLastPathComponent();
                    if(lastPathComponent instanceof DefaultMutableTreeNode) {
                        DefaultMutableTreeNode node = (DefaultMutableTreeNode)lastPathComponent;
                        if(node.isLeaf()) {
                            ((JTree)e.getSource()).setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }
                        else {
                            ((JTree)e.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                        }
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //System.out.println("clicked!");               
            }                       
        }
        ); 

        tree.addMouseListener(
        new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int selRow = tree.getRowForLocation(e.getX(), e.getY());
                if(selRow != -1) {
                    treeClicked();
                }          
            }                       
        }
        );
    } // addTreeListeners

    private void buildMenu() {

        // build menu
        menuBar = new JMenuBar();      
        fileMenu = new JMenu("File");
        helpMenu = new JMenu("Help");
        exitItem = new JMenuItem("Exit");
        aboutItem = new JMenuItem("About");
        fileMenu.add(exitItem);
        helpMenu.add(aboutItem);
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);

    } // end buildMenu

    private void addMenuListeners() {

        // add listener for exit menu item
        exitItem.addActionListener(
        new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                exitActionPerformed();
            }
        }
        );
        
        // add listener for about menu item
        aboutItem.addActionListener(
        new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aboutActionPerformed();
            }
        }
        );

    } // end addMenuListeners

    private void buildPanel() {

        panel = new JPanel();
        splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        scrollPane = new JScrollPane();
        labelPanel = new JPanel();      
        statusLabel = new JLabel();

        scrollPane.getViewport().add(tree);

        statusLabel.setBorder(BorderFactory.createLoweredBevelBorder());
        statusLabel.setMinimumSize(new Dimension(0,18));
        statusLabel.setPreferredSize(new Dimension(0,18));
        
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(200);
        splitPane.setContinuousLayout(true);           
        splitPane.add(desktop, JSplitPane.RIGHT);
        splitPane.add(scrollPane, JSplitPane.LEFT);     

        panel.setLayout(new BorderLayout());
        panel.add(splitPane, BorderLayout.CENTER);

        labelPanel.setLayout(new BorderLayout());
        labelPanel.add(statusLabel, BorderLayout.CENTER);

    } // end buildPanel

    private void buildFrame() {

        // create a new frame and show it
        frame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("My GUI Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());      
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("images/csun.gif"));
        // add label panel
        frame.getContentPane().add(labelPanel, BorderLayout.SOUTH);
        // add main panel
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        // add menu bar
        frame.setJMenuBar(menuBar);
        frame.setSize(1280,800);
        frame.setVisible(true);

    }

    // create a GUI and make it visible to user
    private void initComponents() {
        setLookAndFeel();               
        buildDesktop();        
        buildTree();
        addTreeListeners();        
        buildMenu();             
        addMenuListeners();
        buildPanel();
        buildFrame();        
    } // end initComponents

} // end MyFirstGUIApp
