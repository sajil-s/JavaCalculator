
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*; //import swing package


public class calc {

    public static void main(String[] str) {

        // Create Backend object (to call C code)

    Backend backend =new Backend();

        JFrame frame = new JFrame("My calculator");

        frame.setSize(227, 491);
        frame.setTitle("my calculator");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // add background

        ImageIcon bgImage = new ImageIcon("images/background.jpg.png");

        // Scale image to frame size (500x650)
        Image scaledImg = bgImage.getImage().getScaledInstance(500, 650, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImg);

        JLabel background = new JLabel(scaledIcon);
        background.setBounds(0, 0, 227, 491);

        frame.setContentPane(background);
        frame.setLayout(null);


         // Labels

        JLabel label1 = new JLabel("enter number:1");
        label1.setBounds(56, 25, 150, 30);
        label1.setFont(new Font("Arial", Font.BOLD, 14));
        label1.setForeground(Color.RED);
        frame.add(label1);

        JLabel label2 = new JLabel("enter number:2");
        label2.setBounds(56, 75, 150, 30);
        label2.setFont(new Font("Arial", Font.BOLD, 14));
        label2.setForeground(Color.RED);
        frame.add(label2);

        JLabel label3 = new JLabel("The result is:");
        label3.setBounds(30, 215, 150, 30);
        label3.setFont(new Font("Arial", Font.BOLD, 14));
        label3.setForeground(Color.BLUE);
        frame.add(label3);


        // Text Fields

        JTextField textField1 = new JTextField();
        textField1.setBounds(56, 50, 113, 30);
        frame.add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setBounds(56, 100, 113, 30);
        frame.add(textField2);


          // Operations ComboBox

        String[] operations = { "+", "-", "*", "/" };
        JComboBox<String> operatiBox = new JComboBox<>(operations);
        operatiBox.setBounds(83, 150, 60, 30);
        frame.add(operatiBox);


                // Button

        JButton button = new JButton("Answer");
        button.setBounds(63, 185, 100, 30);
        frame.add(button);

  // Button Click Event → Call C code
  button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e){
        try{
            int a=Integer.parseInt(textField1.getText());
            int b=Integer.parseInt(textField2.getText());
            char op=operatiBox.getSelectedItem().toString().charAt(0);
            int result=backend.calculate(a,b,op);//Call to C backend
            label3.setText("The result is: "+result);
        }catch(Exception ex){
            label3.setText("ERROR: "+ex.getMessage());
        }
    }
  });

        frame.setVisible(true);

    }
}