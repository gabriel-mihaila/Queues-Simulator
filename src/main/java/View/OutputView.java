package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class OutputView extends JPanel {
    private JFrame windowFrame2;
    private JPanel headerPanel;
    private JPanel cumulativePanel1;
    private JPanel cumulativePanel2;
    private JPanel auxPanel;
    private JPanel textPanel;
    private JLabel simulationLabel;
    private JTextPane textPane;
    private JScrollPane scroll;

    public OutputView()
    {
       windowFrame2 = new JFrame("Simulation Plot");
       windowFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       windowFrame2.setLocation(300, 20);
       windowFrame2.setResizable(false);
       windowFrame2.setSize(new Dimension(1000, 800));

       headerPanel = new JPanel();
       headerPanel.setBackground(Color.DARK_GRAY);
       headerPanel.setBorder(new MatteBorder(1,1,1,1, Color.white));
       headerPanel.setMaximumSize(new Dimension(1000, 50));
       headerPanel.setLayout(new GridLayout(1,2));

       simulationLabel = new JLabel("   Simulation progress: ");
       simulationLabel.setForeground(Color.white);
       simulationLabel.setHorizontalAlignment(JLabel.LEFT);
       simulationLabel.setFont(new Font("Serif", Font.BOLD, 24));

       auxPanel = new JPanel();
       auxPanel.setBackground(Color.DARK_GRAY);
       auxPanel.setLayout(new GridLayout(1,1));
       auxPanel.setBorder(new EmptyBorder(10, 100,10,100));

       headerPanel.add(simulationLabel);
       headerPanel.add(auxPanel);

       textPanel = new JPanel();
       textPanel.setBackground(Color.DARK_GRAY);
       textPanel.setLayout(new GridLayout(1,1));

       textPane = new JTextPane();
       textPane.setBackground(Color.DARK_GRAY);
       textPane.setBorder(new EmptyBorder(5,5,5,5));
       textPane.setForeground(Color.white);

       scroll = new JScrollPane(textPane);
       textPanel.add(scroll);

       cumulativePanel1 = new JPanel();
       cumulativePanel1.setLayout(new BoxLayout(cumulativePanel1, BoxLayout.Y_AXIS));
       cumulativePanel1.setBackground(Color.DARK_GRAY);
       cumulativePanel1.setBorder(new MatteBorder(1,1,1,1,Color.white));
       cumulativePanel1.add(headerPanel);
       cumulativePanel1.add(textPanel);

       cumulativePanel2 = new JPanel();
       cumulativePanel2.setBackground(Color.BLACK);
       cumulativePanel2.setLayout(new GridLayout(1,1));
       cumulativePanel2.setBorder(new EmptyBorder(10,10,10,10));
       cumulativePanel2.add(cumulativePanel1);

       windowFrame2.add(cumulativePanel2);
       windowFrame2.setVisible(true);
    }

    public JFrame getWindowFrame2() {
        return windowFrame2;
    }

    public void setWindowFrame2(JFrame windowFrame2) {
        this.windowFrame2 = windowFrame2;
    }

    public JPanel getHeaderPanel() {
        return headerPanel;
    }

    public void setHeaderPanel(JPanel headerPanel) {
        this.headerPanel = headerPanel;
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

    public JPanel getAuxPanel() {
        return auxPanel;
    }

    public void setAuxPanel(JPanel auxPanel) {
        this.auxPanel = auxPanel;
    }

    public JPanel getTextPanel() {
        return textPanel;
    }

    public void setTextPanel(JPanel textPanel) {
        this.textPanel = textPanel;
    }

    public JLabel getSimulationLabel() {
        return simulationLabel;
    }

    public void setSimulationLabel(JLabel simulationLabel) {
        this.simulationLabel = simulationLabel;
    }

    public JTextPane getTextPane() {
        return textPane;
    }

    public void setTextPane(JTextPane textPane) {
        this.textPane = textPane;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public void setScroll(JScrollPane scroll) {
        this.scroll = scroll;
    }
}
