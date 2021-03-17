import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;


public class Window {

    private String title;
    private int width;
    private int height;
    private JFrame window;
    private JLabel label;
    private JButton clickerButton = createButton("CLICK!");
    private JButton purchase = createButton("Multiply Clicks by 2: Cost 10 clicks");
    private JButton autoclick = createButton("Purchase Auto Clicker * 10: Cost 100 Clicks");
    private JButton clickFactory = createButton("Purchase Click Factory: Cost 10000 Clicks");
    private JButton superClicker = createButton("Purchase Super Clicker: Cost 100000 Clicks");

    public Window(String title, int width, int height){

        // Set window properties.
        this.title = title;
        this.width = width;
        this.height = height;

        // Create the window.
        createWindow();
    }

    // Creates and sets all the properties of the JFrame.
    private void createWindow(){

        // Objects
        window = new JFrame();
        label = new JLabel();

        // Properties
        window.setTitle(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setPreferredSize(new Dimension(width, height));
        window.setSize(new Dimension(width, height));

        label.setPreferredSize(new Dimension(50, 50));

        window.getContentPane().setLayout(new BorderLayout());
        window.getContentPane().add(label, BorderLayout.NORTH);

        window.add(clickerButton, BorderLayout.CENTER);
        window.getContentPane().add(initPanel(), BorderLayout.SOUTH);

        window.pack();
        window.setVisible(true);

    }

    // Methods to get the buttons.
    public JButton getClickerButton() {return clickerButton;}
    public JLabel getLabel() {return label;}
    public JButton getPurchase() {return purchase;}
    public JButton getAutoClick() {return autoclick;}
    public JButton getClickFactory() {return clickFactory;}
    public JButton getSuperClicker() {return superClicker;}

    // Add all the components to the panel.
    private JPanel initPanel(){
        JPanel panel = new JPanel();
        panel.setLayout((new GridLayout(3, 2)));

        panel.add(purchase);
        panel.add(autoclick);
        panel.add(clickFactory);
        panel.add(superClicker);

        return panel;
    }

    // Creates buttons.
    private JButton createButton(String label){

        // Creates buttons for the frame.
        JButton button = new JButton();

        // Set button properties.
        button.setSize(new Dimension(35, 50));
        button.setText(label);

        return button;
    }

}

