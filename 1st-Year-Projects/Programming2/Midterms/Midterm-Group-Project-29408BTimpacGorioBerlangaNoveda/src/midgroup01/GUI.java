package midgroup01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.Frame.NORMAL;

public class GUI implements ActionListener {
    MixedFraction mixedFrac2 = new MixedFraction();
    MixedFraction mixedFrac1 = new MixedFraction();
    private JFrame calc;
    private JPanel panel;
    private JTextField whole1, num1, denom1, whole2, num2, denom2;
    private JTextArea results;
    private JLabel frac1, frac2, result;
    private JLabel whole, num, denom;
    private JButton add, subtract, multiply, divide, simplify, clear;

    GUI() {
        panel = new JPanel();
        panel.setBounds(0, 110, 600, 470);
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        whole = new JLabel("Whole: ");
        whole.setFont(new Font("Verdana", NORMAL, 13));
        whole.setBounds(150, 20, 100, 30);
        panel.add(whole);

        num = new JLabel("Numerator: ");
        num.setFont(new Font("Verdana", NORMAL, 13));
        num.setBounds(300, 20, 100, 30);
        panel.add(num);

        denom = new JLabel("Denominator: ");
        denom.setFont(new Font("Verdana", NORMAL, 13));
        denom.setBounds(450, 20, 100, 30);
        panel.add(denom);

        frac1 = new JLabel("First Fraction: ");
        frac1.setFont(new Font("Verdana", NORMAL, 13));
        frac1.setBounds(20, 60, 100, 30);
        panel.add(frac1);
        whole1 = new JTextField(20);
        whole1.setFont(new Font("Verdana", NORMAL, 15));
        whole1.setBounds(150, 60, 100, 30);
        panel.add(whole1);
        num1 = new JTextField(20);
        num1.setFont(new Font("Verdana", NORMAL, 15));
        num1.setBounds(300, 60, 100, 30);
        panel.add(num1);
        denom1 = new JTextField(20);
        denom1.setFont(new Font("Verdana", NORMAL, 15));
        denom1.setBounds(450, 60, 100, 30);
        panel.add(denom1);

        frac2 = new JLabel("Second Fraction: ");
        frac2.setFont(new Font("Verdana", NORMAL, 13));
        frac2.setBounds(20, 100, 150, 30);
        panel.add(frac2);
        whole2 = new JTextField(20);
        whole2.setFont(new Font("Verdana", NORMAL, 15));
        whole2.setBounds(150, 100, 100, 30);
        panel.add(whole2);
        num2 = new JTextField(20);
        num2.setFont(new Font("Verdana", NORMAL, 15));
        num2.setBounds(300, 100, 100, 30);
        panel.add(num2);
        denom2 = new JTextField(20);
        denom2.setFont(new Font("Verdana", NORMAL, 15));
        denom2.setBounds(450, 100, 100, 30);
        panel.add(denom2);

        result = new JLabel("Result: ");
        result.setFont(new Font("Verdana", NORMAL, 15));
        result.setBounds(50, 140, 100, 30);
        panel.add(result);
        results = new JTextArea();
        results.setFont(new Font("Verdana", NORMAL, 15));
        results.setSize(200, 110);
        results.setLocation(50, 180);
        results.setLineWrap(true);
        results.setEditable(false);

        panel.add(results);

        add = new JButton("Add");
        add.setFont(new Font("Verdana", NORMAL, 15));
        add.setBounds(300, 180, 100, 30);
        add.addActionListener(this);
        panel.add(add);
        subtract = new JButton("Subtract");
        subtract.setFont(new Font("Verdana", NORMAL, 15));
        subtract.setBounds(450, 180, 100, 30);
        subtract.addActionListener(this);
        panel.add(subtract);
        multiply = new JButton("Multiply");
        multiply.setFont(new Font("Verdana", NORMAL, 15));
        multiply.setBounds(300, 220, 100, 30);
        multiply.addActionListener(this);
        panel.add(multiply);
        divide = new JButton("Divide");
        divide.setFont(new Font("Verdana", NORMAL, 15));
        divide.setBounds(450, 220, 100, 30);
        divide.addActionListener(this);
        panel.add(divide);
        simplify = new JButton("Simplify");
        simplify.setFont(new Font("Verdana", NORMAL, 15));
        simplify.setBounds(300, 260, 100, 30);
        simplify.addActionListener(this);
        panel.add(simplify);
        clear = new JButton("Clear");
        clear.setFont(new Font("Verdana", NORMAL, 15));
        clear.setBounds(450, 260, 100, 30);
        clear.addActionListener(this);
        panel.add(clear);

        calc = new JFrame("Fraction Calculator");
        calc.setLayout(null);
        calc.setSize(600, 470);
        calc.setResizable(false);
        calc.setLocationRelativeTo(null);
        calc.add(panel);

        calc.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        Fraction f1 = enterFraction1();
        Fraction f2 = enterFraction2();
        mixedFrac1 = (MixedFraction) f1;
        mixedFrac2 = (MixedFraction) f2;
        try {
            if (e.getSource() == add) {
                mixedFrac1.toFraction();
                MixedFraction sum = mixedFrac1.add(mixedFrac2);
                sum.reduce();
                results.setText(sum.toString());
            }
        } catch (NumberFormatException eexc) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == subtract) {
                mixedFrac1.toFraction();
                MixedFraction diff = mixedFrac1.subtract(mixedFrac2);
                diff.reduce();
                results.setText(diff.toString());
            }
        } catch (NumberFormatException eexc1) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == multiply) {
                mixedFrac1.toFraction();
                MixedFraction product = mixedFrac1.multiply(mixedFrac2);
                product.reduce();
                results.setText(product.toString());
            }
        } catch (NumberFormatException eexc2) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == divide) {
                mixedFrac1.toFraction();
                MixedFraction quotient = mixedFrac1.divide(mixedFrac2);
                quotient.reduce();
                results.setText(quotient.toString());
            }
        } catch (NumberFormatException eexc3) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == simplify) {
                mixedFrac1.reduce();
                mixedFrac2.reduce();
                results.setText("Fraction 1: " + mixedFrac1 + "\n" + "Fraction 2: " + mixedFrac2);
            }
        } catch (NumberFormatException eexc4) {
            JOptionPane.showMessageDialog(null, "Fields cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        try {
            if (e.getSource() == clear) {
                whole1.setText("");
                num1.setText("");
                denom1.setText("");
                whole2.setText("");
                num2.setText("");
                denom2.setText("");
                results.setText("");
            }
        } catch (NumberFormatException eexc5) {
            JOptionPane.showMessageDialog(null, "Fields are empty.");
        }
    }
    
    private Fraction enterFraction1() {
        Fraction fraction1 = null;
        try {
            int numerator, denominator, whole;
            boolean ch = false;

            whole = Integer.parseInt(whole1.getText());
            numerator = Integer.parseInt(num1.getText());
            do {
                denominator = Integer.parseInt(denom1.getText());
                if (denominator == 0) {
                    JOptionPane.showMessageDialog(null, "Denominator cannot be zero.", "Error", JOptionPane.ERROR_MESSAGE);
                } else ch = true;
            } while (!ch);
            fraction1 = new MixedFraction(whole, numerator, denominator);
        } catch (NumberFormatException exc1) {
            JOptionPane.showMessageDialog(null, "Fields are empty.");
        }
        return fraction1;
    }

    private Fraction enterFraction2() {
        Fraction fraction2 = null;
        try {
            int numerator, denominator, whole;
            boolean ch = false;
            whole = Integer.parseInt(whole2.getText());
            numerator = Integer.parseInt(num2.getText());
            do {
                denominator = Integer.parseInt(denom2.getText());
                if (denominator == 0) {
                    JOptionPane.showMessageDialog(null, "Denominator cannot be zero.", "Error", JOptionPane.ERROR_MESSAGE);
                } else ch = true;
            } while (!ch);
            fraction2 = new MixedFraction(whole, numerator, denominator);
        }catch (NumberFormatException exc1) {
            JOptionPane.showMessageDialog(null, "Fields are empty.");
        }
        return fraction2;
    }
}
