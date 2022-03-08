package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class InputView extends JPanel{
    private JFrame windowFrame1;
    private JPanel cumulativePanel1;
    private JPanel cumulativePanel2;
    private JPanel titlePanel;
    private JLabel titleLabel;
    private JPanel inputPanel1;
    private JPanel inputPanel2;
    private JPanel inputPanel3;
    private JPanel inputPanel4;
    private JPanel inputPanel5;
    private JPanel inputTotal;
    private JLabel nrCustomersLabel;
    private JTextField nrCustomersField;
    private JLabel nrQueuesLabel;
    private JTextField nrQueuesField;
    private JLabel simulationTimeLabel;
    private JTextField simulationTimeField;
    private JLabel arrivalTimeLabel;
    private JLabel minArrivalTimeLabel;
    private JTextField minArrivalTimeField;
    private JLabel maxArrivalTimeLabel;
    private JTextField maxArrivalTimeField;
    private JLabel serviceTimeLabel;
    private JLabel minServiceTimeLabel;
    private JTextField minServiceTimeField;
    private JLabel maxServiceTimeLabel;
    private JTextField maxServiceTimeField;
    private JPanel buttonsPanel;
    private JPanel buttonsPanel1;
    private JPanel buttonsPanel2;
    private JButton shortestTimeStrategyButton;
    private JButton shortestQueueStrategyButton;

    public InputView()
    {
        //Window1 initialization area
        windowFrame1 = new JFrame("Unit Command");
        windowFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        windowFrame1.setLocation(500, 200);
        windowFrame1.setResizable(false);
        windowFrame1.getContentPane().setBackground(Color.DARK_GRAY);

        //Title area
        titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 1));
        titlePanel.setBackground(Color.DARK_GRAY);
        titleLabel = new JLabel("QUEUES SIMULATOR");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(new EmptyBorder(30, 0, 30, 0));
        titlePanel.add(titleLabel);
        titlePanel.setBorder(new MatteBorder(1,1,1,1, Color.white));

        //input Panel
        //1
        inputPanel1 = new JPanel();
        inputPanel1.setBackground(Color.DARK_GRAY);
        inputPanel1.setLayout(new GridLayout(3, 2));
        nrCustomersLabel = new JLabel("  Number of customers:  ");
        nrCustomersLabel.setForeground(Color.white);
        nrCustomersLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        nrCustomersLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
        nrCustomersField = new JTextField();
        nrCustomersField.setBackground(Color.LIGHT_GRAY);
        nrCustomersField.setHorizontalAlignment(JTextField.CENTER);
        nrCustomersField.setFont(new Font("Serif", Font.PLAIN, 14));
        nrQueuesLabel = new JLabel("  Number of queues:  ");
        nrQueuesLabel.setForeground(Color.white);
        nrQueuesLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        nrQueuesField = new JTextField();
        nrQueuesField.setBackground(Color.LIGHT_GRAY);
        nrQueuesField.setHorizontalAlignment(JTextField.CENTER);
        nrQueuesField.setFont(new Font("Serif", Font.PLAIN, 14));
        simulationTimeLabel = new JLabel("  Simulation time limit:  ");
        simulationTimeLabel.setForeground(Color.white);
        simulationTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        simulationTimeLabel.setBorder(new EmptyBorder(5, 0, 5, 0));
        simulationTimeField = new JTextField();
        simulationTimeField.setBackground(Color.LIGHT_GRAY);
        simulationTimeField.setHorizontalAlignment(JTextField.CENTER);
        simulationTimeField.setFont(new Font("Serif", Font.PLAIN, 14));

        inputPanel1.add(nrCustomersLabel);
        inputPanel1.add(nrCustomersField);
        inputPanel1.add(nrQueuesLabel);
        inputPanel1.add(nrQueuesField);
        inputPanel1.add(simulationTimeLabel);
        inputPanel1.add(simulationTimeField);
        inputPanel1.setBorder(new MatteBorder(1,1,1,1, Color.white));

        //2
        inputPanel2 = new JPanel();
        inputPanel2.setBackground(Color.DARK_GRAY);
        inputPanel2.setLayout(new FlowLayout());
        arrivalTimeLabel = new JLabel("Arrival Time Interval:");
        arrivalTimeLabel.setHorizontalAlignment(JLabel.CENTER);
        arrivalTimeLabel.setForeground(Color.white);
        arrivalTimeLabel.setFont(new Font("Serif", Font.ITALIC, 16));
        inputPanel2.add(arrivalTimeLabel);

        //3
        inputPanel3 = new JPanel();
        inputPanel3.setBackground(Color.DARK_GRAY);
        inputPanel3.setLayout(new GridLayout(1, 4));
        inputPanel3.setBorder(new EmptyBorder(0, 0, 10, 60));
        minArrivalTimeLabel = new JLabel("min: ");
        minArrivalTimeLabel.setForeground(Color.white);
        minArrivalTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        minArrivalTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        minArrivalTimeField = new JTextField();
        minArrivalTimeField.setBackground(Color.LIGHT_GRAY);
        minArrivalTimeField.setHorizontalAlignment(JTextField.CENTER);
        minArrivalTimeField.setFont(new Font("Serif", Font.PLAIN, 14));
        maxArrivalTimeLabel = new JLabel("max: ");
        maxArrivalTimeLabel.setForeground(Color.white);
        maxArrivalTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        maxArrivalTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        maxArrivalTimeField = new JTextField();
        maxArrivalTimeField.setBackground(Color.LIGHT_GRAY);
        maxArrivalTimeField.setHorizontalAlignment(JTextField.CENTER);
        maxArrivalTimeField.setFont(new Font("Serif", Font.PLAIN, 14));

        inputPanel3.add(minArrivalTimeLabel);
        inputPanel3.add(minArrivalTimeField);
        inputPanel3.add(maxArrivalTimeLabel);
        inputPanel3.add(maxArrivalTimeField);

        //4
        inputPanel4 = new JPanel();
        inputPanel4.setBackground(Color.DARK_GRAY);
        inputPanel4.setLayout(new FlowLayout());
        serviceTimeLabel = new JLabel("Service Time Interval:");
        serviceTimeLabel.setHorizontalAlignment(JLabel.CENTER);
        serviceTimeLabel.setForeground(Color.white);
        serviceTimeLabel.setFont(new Font("Serif", Font.ITALIC, 16));

        inputPanel4.setBorder(new MatteBorder(1,0,0,0,Color.white));
        inputPanel4.add(serviceTimeLabel);

        //5
        inputPanel5 = new JPanel();
        inputPanel5.setBackground(Color.DARK_GRAY);
        inputPanel5.setLayout(new GridLayout(1, 4));
        inputPanel5.setBorder(new EmptyBorder(0, 0, 10, 60));
        minServiceTimeLabel = new JLabel("min: ");
        minServiceTimeLabel.setForeground(Color.white);
        minServiceTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        minServiceTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        minServiceTimeField = new JTextField();
        minServiceTimeField.setBackground(Color.LIGHT_GRAY);
        minServiceTimeField.setHorizontalAlignment(JTextField.CENTER);
        minServiceTimeField.setFont(new Font("Serif", Font.PLAIN, 14));
        maxServiceTimeLabel = new JLabel("max: ");
        maxServiceTimeLabel.setForeground(Color.white);
        maxServiceTimeLabel.setHorizontalAlignment(JLabel.RIGHT);
        maxServiceTimeLabel.setFont(new Font("Serif", Font.ITALIC, 14));
        maxServiceTimeField = new JTextField();
        maxServiceTimeField.setBackground(Color.LIGHT_GRAY);
        maxServiceTimeField.setHorizontalAlignment(JTextField.CENTER);
        maxServiceTimeField.setFont(new Font("Serif", Font.PLAIN, 14));

        inputPanel5.add(minServiceTimeLabel);
        inputPanel5.add(minServiceTimeField);
        inputPanel5.add(maxServiceTimeLabel);
        inputPanel5.add(maxServiceTimeField);

        //buttons Panel
        buttonsPanel = new JPanel();
        buttonsPanel.setBackground(Color.DARK_GRAY);
        buttonsPanel.setBorder(new MatteBorder(1,1,1,1, Color.white));
        buttonsPanel.setLayout(new FlowLayout());

        buttonsPanel1 = new JPanel();
        buttonsPanel1.setBackground(Color.DARK_GRAY);
        buttonsPanel1.setBorder(new EmptyBorder(5,5,5,5));
        shortestQueueStrategyButton = new JButton("Shortest Queue Simulation");
        shortestQueueStrategyButton.setFont(new Font("Serif", Font.BOLD, 14));
        shortestQueueStrategyButton.setFocusPainted(false);
        shortestQueueStrategyButton.setBorder(new EmptyBorder(10,10,10,10));
        buttonsPanel1.add(shortestQueueStrategyButton);

        buttonsPanel2 = new JPanel();
        buttonsPanel2.setBackground(Color.DARK_GRAY);
        buttonsPanel2.setBorder(new EmptyBorder(5,5,5,5));
        shortestTimeStrategyButton = new JButton("Shortest Time Simulation");
        shortestTimeStrategyButton.setFont(new Font("Serif", Font.BOLD, 14));
        shortestTimeStrategyButton.setFocusPainted(false);
        shortestTimeStrategyButton.setBorder(new EmptyBorder(10,10,10,10));
        buttonsPanel2.add(shortestTimeStrategyButton);

        buttonsPanel.add(buttonsPanel1);
        buttonsPanel.add(buttonsPanel2);

        //input total
        inputTotal = new JPanel();
        inputTotal.setBackground(Color.DARK_GRAY);
        inputTotal.setLayout(new BoxLayout(inputTotal, BoxLayout.Y_AXIS));
        inputTotal.add(inputPanel1);
        inputTotal.add(inputPanel2);
        inputTotal.add(inputPanel3);
        inputTotal.add(inputPanel4);
        inputTotal.add(inputPanel5);
        inputTotal.add(buttonsPanel);

        cumulativePanel1 = new JPanel();
        cumulativePanel1.setBackground(Color.DARK_GRAY);
        cumulativePanel1.setLayout(new BoxLayout(cumulativePanel1, BoxLayout.Y_AXIS));
        cumulativePanel1.add(titlePanel);
        cumulativePanel1.add(inputTotal);
        cumulativePanel1.setBorder(new MatteBorder(1,1,1,1, Color.white));

        cumulativePanel2 = new JPanel();
        cumulativePanel2.setBackground(Color.BLACK);
        cumulativePanel2.setBorder(new EmptyBorder(10,10,10,10));
        cumulativePanel2.add(cumulativePanel1);

        windowFrame1.add(cumulativePanel2);
        windowFrame1.pack();
        windowFrame1.setVisible(true);
    }

    public JFrame getWindowFrame1() {
        return windowFrame1;
    }

    public void setWindowFrame1(JFrame windowFrame1) {
        this.windowFrame1 = windowFrame1;
    }

    public JPanel getCumulativePanel1() {
        return cumulativePanel1;
    }

    public void setCumulativePanel1(JPanel cumulativePanel1) {
        this.cumulativePanel1 = cumulativePanel1;
    }

    public JPanel getCumulativePanel2() {
        return cumulativePanel2;
    }

    public void setCumulativePanel2(JPanel cumulativePanel2) {
        this.cumulativePanel2 = cumulativePanel2;
    }

    public JPanel getTitlePanel() {
        return titlePanel;
    }

    public void setTitlePanel(JPanel titlePanel) {
        this.titlePanel = titlePanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JPanel getInputPanel1() {
        return inputPanel1;
    }

    public void setInputPanel1(JPanel inputPanel1) {
        this.inputPanel1 = inputPanel1;
    }

    public JPanel getInputPanel2() {
        return inputPanel2;
    }

    public void setInputPanel2(JPanel inputPanel2) {
        this.inputPanel2 = inputPanel2;
    }

    public JPanel getInputPanel3() {
        return inputPanel3;
    }

    public void setInputPanel3(JPanel inputPanel3) {
        this.inputPanel3 = inputPanel3;
    }

    public JPanel getInputPanel4() {
        return inputPanel4;
    }

    public void setInputPanel4(JPanel inputPanel4) {
        this.inputPanel4 = inputPanel4;
    }

    public JPanel getInputPanel5() {
        return inputPanel5;
    }

    public void setInputPanel5(JPanel inputPanel5) {
        this.inputPanel5 = inputPanel5;
    }

    public JPanel getInputTotal() {
        return inputTotal;
    }

    public void setInputTotal(JPanel inputTotal) {
        this.inputTotal = inputTotal;
    }

    public JLabel getNrCustomersLabel() {
        return nrCustomersLabel;
    }

    public void setNrCustomersLabel(JLabel nrCustomersLabel) {
        this.nrCustomersLabel = nrCustomersLabel;
    }

    public JTextField getNrCustomersField() {
        return nrCustomersField;
    }

    public void setNrCustomersField(JTextField nrCustomersField) {
        this.nrCustomersField = nrCustomersField;
    }

    public JLabel getNrQueuesLabel() {
        return nrQueuesLabel;
    }

    public void setNrQueuesLabel(JLabel nrQueuesLabel) {
        this.nrQueuesLabel = nrQueuesLabel;
    }

    public JTextField getNrQueuesField() {
        return nrQueuesField;
    }

    public void setNrQueuesField(JTextField nrQueuesField) {
        this.nrQueuesField = nrQueuesField;
    }

    public JLabel getSimulationTimeLabel() {
        return simulationTimeLabel;
    }

    public void setSimulationTimeLabel(JLabel simulationTimeLabel) {
        this.simulationTimeLabel = simulationTimeLabel;
    }

    public JTextField getSimulationTimeField() {
        return simulationTimeField;
    }

    public void setSimulationTimeField(JTextField simulationTimeField) {
        this.simulationTimeField = simulationTimeField;
    }

    public JLabel getArrivalTimeLabel() {
        return arrivalTimeLabel;
    }

    public void setArrivalTimeLabel(JLabel arrivalTimeLabel) {
        this.arrivalTimeLabel = arrivalTimeLabel;
    }

    public JLabel getMinArrivalTimeLabel() {
        return minArrivalTimeLabel;
    }

    public void setMinArrivalTimeLabel(JLabel minArrivalTimeLabel) {
        this.minArrivalTimeLabel = minArrivalTimeLabel;
    }

    public JTextField getMinArrivalTimeField() {
        return minArrivalTimeField;
    }

    public void setMinArrivalTimeField(JTextField minArrivalTimeField) {
        this.minArrivalTimeField = minArrivalTimeField;
    }

    public JLabel getMaxArrivalTimeLabel() {
        return maxArrivalTimeLabel;
    }

    public void setMaxArrivalTimeLabel(JLabel maxArrivalTimeLabel) {
        this.maxArrivalTimeLabel = maxArrivalTimeLabel;
    }

    public JTextField getMaxArrivalTimeField() {
        return maxArrivalTimeField;
    }

    public void setMaxArrivalTimeField(JTextField maxArrivalTimeField) {
        this.maxArrivalTimeField = maxArrivalTimeField;
    }

    public JLabel getServiceTimeLabel() {
        return serviceTimeLabel;
    }

    public void setServiceTimeLabel(JLabel serviceTimeLabel) {
        this.serviceTimeLabel = serviceTimeLabel;
    }

    public JLabel getMinServiceTimeLabel() {
        return minServiceTimeLabel;
    }

    public void setMinServiceTimeLabel(JLabel minServiceTimeLabel) {
        this.minServiceTimeLabel = minServiceTimeLabel;
    }

    public JTextField getMinServiceTimeField() {
        return minServiceTimeField;
    }

    public void setMinServiceTimeField(JTextField minServiceTimeField) {
        this.minServiceTimeField = minServiceTimeField;
    }

    public JLabel getMaxServiceTimeLabel() {
        return maxServiceTimeLabel;
    }

    public void setMaxServiceTimeLabel(JLabel maxServiceTimeLabel) {
        this.maxServiceTimeLabel = maxServiceTimeLabel;
    }

    public JTextField getMaxServiceTimeField() {
        return maxServiceTimeField;
    }

    public void setMaxServiceTimeField(JTextField maxServiceTimeField) {
        this.maxServiceTimeField = maxServiceTimeField;
    }

    public JPanel getButtonsPanel() {
        return buttonsPanel;
    }

    public void setButtonsPanel(JPanel buttonsPanel) {
        this.buttonsPanel = buttonsPanel;
    }

    public JPanel getButtonsPanel1() {
        return buttonsPanel1;
    }

    public void setButtonsPanel1(JPanel buttonsPanel1) {
        this.buttonsPanel1 = buttonsPanel1;
    }

    public JPanel getButtonsPanel2() {
        return buttonsPanel2;
    }

    public void setButtonsPanel2(JPanel buttonsPanel2) {
        this.buttonsPanel2 = buttonsPanel2;
    }

    public JButton getShortestTimeStrategyButton() {
        return shortestTimeStrategyButton;
    }

    public void setShortestTimeStrategyButton(JButton shortestTimeStrategyButton) {
        this.shortestTimeStrategyButton = shortestTimeStrategyButton;
    }

    public JButton getShortestQueueStrategyButton() {
        return shortestQueueStrategyButton;
    }

    public void setShortestQueueStrategyButton(JButton shortestQueueStrategyButton) {
        this.shortestQueueStrategyButton = shortestQueueStrategyButton;
    }
}
