import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {

    private static JFrame frame;
    private static JLabel label;
    private static JLabel proceed;
    private static JLabel higher;
    private static JLabel lower;
    private static JLabel won;
    private static JLabel lose;
    private static JPanel panel;
    private static JButton button;
    private static JTextField number;
    private static int randomNumber = (int)(Math.random()*100)+1;
    String str;
    int guess;
    private int count=11;
    

    public void GUI () {
        frame = new JFrame();
        
        frame.setSize(400,500);

        
        panel = new JPanel();
        panel.setLayout(null);
       

        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Number Guessing Game");

        label = new JLabel("Enter your guess(1-100): ");
        label.setBounds(10,20,200,30);
        panel.add(label);

        number = new JTextField(10);
        number.setBounds(200,20,160,30);
        panel.add(number);

        button = new JButton("Go");
        button.setBounds(10,50,100,30);
        panel.add(button);

        proceed = new JLabel();
        proceed.setBounds(10,100,400,30);
        panel.add(proceed);

        higher = new JLabel();
        higher.setBounds(10,130,400,30);
        panel.add(higher);

        lower = new JLabel();
        lower.setBounds(10,160,400,30);
        panel.add(lower);

        won = new JLabel();
        won.setBounds(10,190,400,30);
        panel.add(won);

        lose = new JLabel();
        lose.setBounds(10,220,400,30);
        panel.add(lose);

        frame.setVisible(true);

        button.addActionListener(new ButtonListener());

    }

    private class ButtonListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e) {
            String actionCommand = e.getActionCommand();
            str = number.getText();
            {
            count--;
            //System.out.println("ramdon number "+ randomNumber );
            if (count>0){
                proceed.setText("You have "+ count +" guess(es) left.");
                working();
            }
            else{
                lose.setText("SORRY!! You lose :( The number was "+randomNumber);
                //break;
            }
            }
        }
    }
    public void working(){
        guess = Integer.parseInt(str);                
        
        if(randomNumber<guess){
            lower.setText("It's smaller than        "+guess);
        }
        else if(randomNumber>guess){
            higher.setText("It's larger than          "+guess);
        }
        else if(randomNumber==guess){
            won.setText("CORRECT..!! YOU WON...!!!");
            //break;
        }
    }
    
    
    /*
    public static void name(String[] args) {
        new GUI();
    }*/
}   