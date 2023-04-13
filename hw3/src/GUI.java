import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI for program visualization
 */
public class GUI extends JFrame implements ActionListener {

    private final JTextField lastNameField;
    private final JTextField firstNameField;
    private final JTextField patronymicField;
    private final JTextField birthDateField;
    private final JButton submitButton;
    private final JLabel resultLabel;

    /**
     * constructor of GUI panel
     */
    public GUI() {
        super("Определи свой возраст");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 250);
        setResizable(false);
        setLocationRelativeTo(null);

        JLabel lastNameLabel = new JLabel("Фамилия:");
        lastNameField = new JTextField(20);
        JLabel firstNameLabel = new JLabel("Имя:");
        firstNameField = new JTextField(20);
        JLabel patronymicLabel = new JLabel("Отчество:");
        patronymicField = new JTextField(20);
        JLabel birthDateLabel = new JLabel("Дата рождения (в формате ДД.ММ.ГГГГ):");
        birthDateField = new JTextField(20);
        submitButton = new JButton("Вывести результат");
        submitButton.addActionListener(this);
        resultLabel = new JLabel("");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(patronymicLabel);
        panel.add(patronymicField);
        panel.add(birthDateLabel);
        panel.add(birthDateField);
        panel.add(submitButton);
        panel.add(resultLabel);
        add(panel);

        setVisible(true);
    }

    /**
     * gets all inforamtion from user and outputs it on the screen
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            try {
                String lastName = lastNameField.getText();
                String firstName = firstNameField.getText();
                String patronymic = patronymicField.getText();
                String birthDateString = birthDateField.getText();
                String initials = firstName.substring(0, 1) + "." + patronymic.substring(0, 1) + ".";

                CheckData checkData = new CheckData();
                String gender = checkData.getGender(patronymic);
                int age = checkData.getAge(birthDateString);
                String ageSuffix = checkData.getAgeSuffix(birthDateString, age);

                if (!checkData.isRightInitials(lastName, firstName, patronymic)){
                    resultLabel.setText("Некорректные инициалы. Пожалуйста, попробуйте снова");
                }
                else if (age < 0){
                    resultLabel.setText("Такой человек еще не родился :)");
                }
                else {
                    resultLabel.setText(lastName + " " + initials + "   " + gender + "   " + age + " " + ageSuffix);
                }
            } catch (Exception ex) {
                resultLabel.setText("Ошибка ввода данных. Пожалуйста, попробуйте снова");
            }
        }
    }
}