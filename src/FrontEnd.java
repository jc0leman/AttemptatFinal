import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.*;

public class FrontEnd extends JFrame implements KeyListener {

    private final JTextField textField;
    private final ArrayList<Food> foodsList;
    private JLabel welcomeLabel;
    private JLabel promptLabel;
    private JLabel resultLabel;
    private JLabel caloriesLabel;
    private String currentText;

    private JLabel rec2000;

    private JLabel Disclaimer;
    private CalorieTracker calorieTracker;
    private User user;
    private int totalCaloriesConsumed;

    public FrontEnd(ArrayList<Food> foodsList, CalorieTracker calorieTracker) {
        super("Calorie Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
        getContentPane().setBackground(Color.CYAN);
        setLayout(new BorderLayout());
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        getContentPane().add(mainPanel);

        welcomeLabel = new JLabel("Welcome to My Calorie Tracker");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(welcomeLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        promptLabel = new JLabel("What food did you eat:");
        promptLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        promptLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(promptLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        textField = new JTextField(20);
        textField.setBackground(Color.WHITE);
        textField.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(textField);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        resultLabel = new JLabel("");
        resultLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(resultLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        caloriesLabel = new JLabel("Total Calories Consumed: 0");
        caloriesLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        caloriesLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(caloriesLabel);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        rec2000 = new JLabel("2000 Calories A Day is Generally Advised");
        rec2000.setFont(new Font("Arial", Font.PLAIN, 16));
        rec2000.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(rec2000);

        mainPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        Disclaimer = new JLabel("Disclaimer: Some Users May Experience a dispairity between the text they input and the text they" +
                " see on the screen. Don't fret. The string you actually enter is the one that is used and it is " +
                "purely a cosmetic error");
        Disclaimer.setFont(new Font("Arial", Font.PLAIN, 8));
        Disclaimer.setAlignmentX(Component.CENTER_ALIGNMENT);
        mainPanel.add(Disclaimer);

        currentText = "";
        this.foodsList = foodsList;
        this.calorieTracker = calorieTracker;
        this.user = calorieTracker.getUser();
        this.totalCaloriesConsumed = 0;

        textField.addKeyListener(this);
        textField.requestFocus();
        getContentPane().setBackground(Color.CYAN);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_BACK_SPACE) {
            // Handle Backspace key
            if (currentText.length() > 0) {
                currentText = currentText.substring(0, currentText.length() - 1);
            }
        } else if (keyCode == KeyEvent.VK_ENTER) {
            // Handle Enter key
            if (currentText.length() > 0) {
                String foodName = currentText.trim(); // Trim any leading or trailing spaces

                boolean found = calorieTracker.searchFoodByName(foodName);
                if (found) {
                    // Match found
                    resultLabel.setText("Food found: " + foodName);

                    // Add calories to the total consumed
                    int calories = calorieTracker.getCaloriesByName(foodName);
                    totalCaloriesConsumed += calories;
                    caloriesLabel.setText("Total Calories Consumed: " + totalCaloriesConsumed);
                } else {
                    // No match found
                    resultLabel.setText("Food not found!");
                }

                // Reset the current text and text field
                currentText = "";
                textField.setText("");
            }
        } else if (Character.isLetterOrDigit(e.getKeyChar()) || keyCode == KeyEvent.VK_SPACE) {
            // Append the typed character to the current text
            currentText += e.getKeyChar();
        }

        textField.setText(currentText);
    }



    @Override
    public void keyTyped(KeyEvent e) {
        // Do nothing
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Do nothing
    }

    public String getScreenText() {
        return currentText;
    }
}
