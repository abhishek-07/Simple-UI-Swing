import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements ActionListener {
    JFrame frame;
    JTextField firstField, secondField, resultField;
    JRadioButton add, subtract, multiply, divide;

    Main() {
        frame = new JFrame("Calculator");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(650, 300);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.PINK);
        mainPanel.setLayout(new FlowLayout());

        firstField = new JTextField(15);
        secondField = new JTextField(15);

        JPanel calculatePanel = new JPanel();
        calculatePanel.setLayout(new GridLayout(4,1));

        add = new JRadioButton("+");
        subtract = new JRadioButton("-");
        multiply = new JRadioButton("*");
        divide = new JRadioButton("/");
        ButtonGroup group = new ButtonGroup();
        group.add(add);
        group.add(subtract);
        group.add(multiply);
        group.add(divide);
        calculatePanel.add(add);
        calculatePanel.add(subtract);
        calculatePanel.add(multiply);
        calculatePanel.add(divide);

        JLabel equalsLabel = new JLabel("=");
        resultField = new JTextField(15);

        mainPanel.add(firstField);
        mainPanel.add(calculatePanel);
        mainPanel.add(secondField);
        mainPanel.add(equalsLabel);
        mainPanel.add(resultField);

        frame.add(mainPanel);

        frame.setVisible(true);

        add.addActionListener(this);
        subtract.addActionListener(this);
        multiply.addActionListener(this);
        divide.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            int firstNum = Integer.parseInt(firstField.getText());
            int secondNum = Integer.parseInt(secondField.getText());
            double result = 0;
            if (e.getSource() == add) {
                result = firstNum + secondNum;
            } else if (e.getSource() == subtract) {
                result = firstNum - secondNum;
            } else if (e.getSource() == multiply) {
                result = firstNum * secondNum;
            } else if (e.getSource() == divide) {
                if (secondNum == 0) {
                    throw new ArithmeticException();
                }
                result = (double) firstNum / secondNum;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter valid integer values in both text fields.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ArithmeticException ex) {
            JOptionPane.showMessageDialog(null, "Cannot divide by zero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        Main m = new Main();
    }
}
