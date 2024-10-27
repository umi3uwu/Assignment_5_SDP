import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController {

    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view  = view;

        // Регистрация слушателей для кнопок
        this.view.addOperationListener(new OperationListener());
    }

    class OperationListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            double firstNumber;
            double secondNumber;
            double result = 0;

            try {
                firstNumber  = view.getFirstNumber();
                secondNumber = view.getSecondNumber();

                if (e.getSource() == view.getAddButton()) {
                    result = model.add(firstNumber, secondNumber);
                } else if (e.getSource() == view.getSubButton()) {
                    result = model.subtract(firstNumber, secondNumber);
                } else if (e.getSource() == view.getMulButton()) {
                    result = model.multiply(firstNumber, secondNumber);
                } else if (e.getSource() == view.getDivButton()) {
                    result = model.divide(firstNumber, secondNumber);
                }

                view.setResult(String.valueOf(result));

            } catch (NumberFormatException ex) {
                view.showError("Ошибка: введите корректные числа.");
            } catch (ArithmeticException ex) {
                view.showError("Ошибка: " + ex.getMessage());
            }
        }
    }
}
