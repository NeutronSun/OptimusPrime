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
    
    public GuiData(BigInteger start, BigInteger n)
    {
        myF = new JFrame();
        myC = myF.getContentPane();
        nElement = new BigDecimal(n);
        cont = 0;
        list = new ArrayList<JPanel>();
        myP = new JPanel();
        firsRun = true;
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

    

    public void updateLoadingBar(BigInteger n){
        BigDecimal p = new BigDecimal(n);
        MathContext mc = new MathContext(10, RoundingMode.HALF_UP);
        BigDecimal s = p.divide(nElement,mc).multiply(BigDecimal.valueOf(100)).stripTrailingZeros();
        if(s.scale() == 0){
            System.out.println("update");
            list.get(p.divide(nElement,mc).multiply(BigDecimal.valueOf(100)).intValue()).setBackground(Color.green);
            if(firsRun){
                for(int i = 0; i <= p.divide(nElement,mc).multiply(BigDecimal.valueOf(100)).intValue(); i++)
                 list.get(i).setBackground(Color.green);
            }
            myC.removeAll();
            updateScreen();
        }


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