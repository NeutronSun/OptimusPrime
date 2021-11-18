import javax.swing.JFrame;
import java.awt.*;
import java.math.*;
import java.util.*;

import javax.swing.*;
public class GuiData{

    public static JFrame myF;
    public static Container myC;
    public static BigDecimal nElement;
    public static boolean firsRun;
    public static int cont;
    public static ArrayList<JPanel> list;
    public static JPanel myP;
    public static int lastNum;
    
    public GuiData(int cont)
    {
        myF = new JFrame();
        myC = myF.getContentPane();
        this.cont = cont;
        list = new ArrayList<JPanel>();
        myP = new JPanel();
        firsRun = true;
        lastNum = 0;
    }

    
    public void inizializeFrame()
    {
        myP.setLayout(new GridLayout(1,100, 0, 0));
        for(int i = 0; i < 100; i++){
            JPanel panel = new JPanel();
            panel.setBackground(Color.red);
            list.add(panel);
            list.get(i).add(new JLabel(String.valueOf(i+1)));
            myP.add(list.get(i));
        }
        myC.add(myP);
        SwingUtilities.updateComponentTreeUI(myF);
        myF.setTitle("OptimusPrime");
        myF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myF.setVisible(true);
        myF.setBounds(0,0,1920,160);
        java.net.URL path = path();
        
        ImageIcon logoicon = new ImageIcon(path);
        Image logo = logoicon.getImage();
        myF.setIconImage(logo);
        
    }

    

    public void updateLoadingBar(int n){
        int blocks = (int)((Double.parseDouble(String.valueOf(n))/Double.parseDouble(String.valueOf(cont)))*100);
        for(int i = lastNum; i < blocks; i++){
           
            list.get(i).setBackground(Color.green);
        }
        
        lastNum = blocks;
        myC.removeAll();
        updateScreen();


    }

    public void updateScreen(){
        for(int i = 0; i < 100; i++)
            myP.add(list.get(i));
        myC.add(myP);
        SwingUtilities.updateComponentTreeUI(myF);
    }

    public java.net.URL path()
    {
    	return this.getClass().getResource("icon.png");
    }
}