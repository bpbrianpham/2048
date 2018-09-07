import javax.swing.JFrame; //imports JFrame library
import javax.swing.JButton; //imports JButton library
import java.awt.GridLayout;
import javax.swing.*; //imports GridLayout library
import java.awt.*; 
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.JTextArea;
import java.lang.Object;
import java.awt.Component;
import java.awt.Container;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
public class Block extends JPanel
{
    public Block(Integer e)
    {
        super();
        Color color;
     if(e != 0)// for blocks with value creates them with appropriate color and number
     {
         switch (e)// assign colors 
         {
            case 2:     color = Color.WHITE;
            setBackground(color);
                        break;
            case 4:     color = Color.LIGHT_GRAY;
            setBackground(color);
                        break;
            case 8:     color = Color.CYAN;
            setBackground(color);
                        break;
            case 16:    color = Color.RED;
            setBackground(color);
                        break;
            case 32:    color = Color.BLUE;
            setBackground(color);
                        break;
            case 64:    color = Color.ORANGE;
            setBackground(color);
                        break;
            case 128:   color = Color.GREEN;
            setBackground(color);
                        break;
            case 256:   color = Color.MAGENTA;
            setBackground(color);
                        break;
            case 512:   color = Color.PINK;
            setBackground(color);
                        break;
            case 1024:  color = new Color(0,222,222);
            setBackground(color);
                        break;
            case 2048:  color = Color.YELLOW;
            setBackground(color);
                        break;
            default:    color = Color.GRAY;
            setBackground(color);
                        break;
                        
        
      }// ens switch
      //assign label to block
      JLabel label = new JLabel(e.toString());
       label.setFont(label.getFont().deriveFont(62.0f));
      this.add(label);
     }
     else  //sets blank blocks (0) color gray
     {
        color = Color.GRAY;
            
            setBackground(color); 
     }// end else
    
  } // end Block()
}// end class Block