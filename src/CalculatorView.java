import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CalculatorView extends JFrame {

    private JTextField firstNumber  = new JTextField(10);
    private JTextField secondNumber = new JTextField(10);

    private JButton addButton       = new JButton("+");
    private JButton subButton       = new JButton("-");
    private JButton mulButton       = new JButton("*");
    private JButton divButton       = new JButton("/");

    private JTextField resultField  = new JTextField(15);

    public CalculatorView() {
        // Настройка интерфейса
        JPanel panel = new JPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(350, 150);

        panel.add(new JLabel("Число 1:"));
        panel.add(firstNumber);
        panel.add(new JLabel("Число 2:"));
        panel.add(secondNumber);

        panel.add(addButton);
        panel.add(subButton);
        panel.add(mulButton);
        panel.add(divButton);

        panel.add(new JLabel("Результат:"));
        resultField.setEditable(false);
        panel.add(resultField);

        this.add(panel);
    }

    public double getFirstNumber() throws NumberFormatException {
        return Double.parseDouble(firstNumber.getText());
    }

    public double getSecondNumber() throws NumberFormatException {
        return Double.parseDouble(secondNumber.getText());
    }

    public void setResult(String result) {
        resultField.setText(result);
    }

    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void addOperationListener(ActionListener listener) {
        addButton.addActionListener(listener);
        subButton.addActionListener(listener);
        mulButton.addActionListener(listener);
        divButton.addActionListener(listener);
    }

    // Методы для получения кнопок
    public JButton getAddButton() {
        return addButton;
    }

    public JButton getSubButton() {
        return subButton;
    }

    public JButton getMulButton() {
        return mulButton;
    }

    public JButton getDivButton() {
        return divButton;
    }
}
