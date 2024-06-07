import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizApp extends JFrame implements ActionListener {
    private String[] questions = {
        "What is the capital of Odisha",
        "Who wrote 'Ramayana'?",

    };
    private String[][] options = {
        {"Delhi", "Bhubaneswar", "Nayagarh", "Jagatsinghpur"},
        {"Valmiki", "Jayadev", "Sarala Das", "VyasDev"},

    };
    private int[] answers = {1, 2 };
    private int currentQuestion = 0;
    private int score = 0;

    private JLabel questionLabel;
    private JRadioButton[] optionButtons;
    private ButtonGroup buttonGroup;
    private JButton nextButton;

    public QuizApp() {
        setTitle("Quiz Application");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 1));

        questionLabel = new JLabel();
        add(questionLabel);

        optionButtons = new JRadioButton[4];
        buttonGroup = new ButtonGroup();
        for (int i = 0; i < 4; i++) {
            optionButtons[i] = new JRadioButton();
            buttonGroup.add(optionButtons[i]);
            add(optionButtons[i]);
        }

        nextButton = new JButton("Next");
        nextButton.addActionListener(this);
        add(nextButton);

        loadQuestion();
    }

    private void loadQuestion() {
        if (currentQuestion < questions.length) {
            questionLabel.setText(questions[currentQuestion]);
            for (int i = 0; i < 4; i++) {
                optionButtons[i].setText(options[currentQuestion][i]);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Quiz Over! Your score: " + score);
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedOption = -1;
        for (int i = 0; i < 4; i++) {
            if (optionButtons[i].isSelected()) {
                selectedOption = i;
            }
        }

        if (selectedOption == answers[currentQuestion]) {
            score++;
        }
        currentQuestion++;
        loadQuestion();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizApp().setVisible(true);
        });
    }
}

