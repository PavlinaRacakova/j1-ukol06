package cz.czechitas.ukol6;


import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {

    private JSpinner geeseSpinner;
    private SpinnerNumberModel geeseSpinnerNumberModel;
    private JSpinner rabbitsSpinner;
    private SpinnerNumberModel rabbitsSpinnerNumberModel;
    private JTextField legsField;
    private JTextField headsField;
    private JLabel geeseLabel;
    private JLabel rabbitsLabel;
    private JLabel legsLabel;
    private JLabel headsLabel;
    private JButton calculateButton;

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    /**
     * Constructor
     * @throws HeadlessException
     */
    public Aplikace() throws HeadlessException {
        super("The farm");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * Main initialization code
     */
    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //Geese spinner
        geeseSpinnerNumberModel = new SpinnerNumberModel(0, 0, 10000, 5);
        geeseSpinner = new JSpinner(geeseSpinnerNumberModel);
        geeseLabel = new JLabel("Geese ");
        geeseLabel.setLabelFor(geeseSpinner);
        add(geeseLabel);
        add(geeseSpinner);

        //Rabbits spinner
        rabbitsSpinnerNumberModel = new SpinnerNumberModel(0, 0, 10000, 5);
        rabbitsSpinner = new JSpinner(rabbitsSpinnerNumberModel);
        rabbitsLabel = new JLabel("Rabbits ");
        rabbitsLabel.setLabelFor(rabbitsSpinner);
        add(rabbitsLabel);
        add(rabbitsSpinner);

        //Calculate button
        calculateButton = new JButton("Calculate");
        JPanel calculateButtonPanel = new JPanel();
        calculateButtonPanel.add(calculateButton);
        add(calculateButtonPanel, "span");

        //Heads field
        headsField = new JTextField();
        headsLabel = new JLabel("Number of heads: ");
        headsLabel.setLabelFor(headsField);
        headsField.setEditable(false);
        headsField.setHorizontalAlignment(JTextField.TRAILING);
        add(headsLabel);
        add(headsField);

        //Legs field
        legsField = new JTextField();
        legsLabel = new JLabel("Number of legs: ");
        legsLabel.setLabelFor(legsField);
        legsField.setEditable(false);
        legsField.setHorizontalAlignment(JTextField.TRAILING);
        add(legsLabel);
        add(legsField);

        pack();

        calculateButton.addActionListener(this::handleCalculate);
    }

    /**
     * When the calculate button is invoked, this method counts how many heads and legs are presented and sets the results to relevant fields
     *
     * @param actionEvent
     */
    private void handleCalculate(ActionEvent actionEvent) {
        int numberOfGeese = (Integer) geeseSpinner.getValue();
        int numberOfRabbits = (Integer) rabbitsSpinner.getValue();

        int numberOfHeads = numberOfGeese + numberOfRabbits;
        int numberOfLegs = (numberOfGeese * 2) + (numberOfRabbits * 4);

        headsField.setText(Integer.toString(numberOfHeads));
        legsField.setText(Integer.toString(numberOfLegs));
    }
}
