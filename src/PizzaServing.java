
/**
 *
 * @author harsh
 */

package pizza.servings.calculator;

import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class PizzaServing extends JFrame {

    private final JPanel line2;
    private final JTextField textF;
    private final JLabel promptLabel;
    private final JLabel titleLabel;
    private final JLabel servingsFormula;
    private final JButton button;

    public PizzaServing() {

        super("Pizza Servings Calculator");

        setLayout(new GridLayout(4,1));

        titleLabel = new JLabel("Pizza Servings Calculator");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.RED);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

        promptLabel = new JLabel("Enter the size of the pizza in inches:");
        promptLabel.setFont(new Font("Arial", Font.BOLD, 11));
        promptLabel.setHorizontalAlignment(SwingConstants.CENTER);

        textF = new JTextField(4);

        line2 = new JPanel();
        line2.add(promptLabel);
        line2.add(textF);
        add(line2);

        button = new JButton("Calculate Servings");
        add(button);

        ButtonHandler handler = new ButtonHandler();
        button.addActionListener(handler);
        
        servingsFormula = new JLabel();
        servingsFormula.setFont(new Font("Arial", Font.BOLD, 11));
        servingsFormula.setHorizontalAlignment(SwingConstants.CENTER);
        add(servingsFormula);
        
        setSize(350, 300);
        setVisible(true);
        
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if (button.isEnabled()) {
                double size = Double.parseDouble(textF.getText());
                double servings = 0.0;
                servings = Math.pow(size / 8, 2);
                servingsFormula.setText(String.format("A %.0f inch pizza will serve %.2f people.", size, servings));
            }
        }
    }
}