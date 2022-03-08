package Controller;

import Model.SelectionPolicy;
import Model.SimulationManager;
import View.InputView;
import View.OutputView;

import javax.swing.*;
import java.awt.*;

public class InputController extends Component {
    private InputView inputView;
    private OutputView outputView;

    public InputController(InputView inputView){
        this.inputView = inputView;
        OperationsListeners();
    }

    private void OperationsListeners()
    {
        inputView.getShortestQueueStrategyButton().addActionListener( e ->{
            try
            {
                int timeLimit, maxServicingTime, minServicingTime, maxArrivingTime, minArrivingTime, numberOfCustomers, numberOfServers;
                SelectionPolicy selectionPolicy;

                numberOfCustomers = Integer.parseInt(inputView.getNrCustomersField().getText());
                numberOfServers = Integer.parseInt(inputView.getNrQueuesField().getText());
                timeLimit = Integer.parseInt(inputView.getSimulationTimeField().getText());
                minArrivingTime = Integer.parseInt(inputView.getMinArrivalTimeField().getText());
                maxArrivingTime = Integer.parseInt(inputView.getMaxArrivalTimeField().getText());
                minServicingTime = Integer.parseInt(inputView.getMinServiceTimeField().getText());
                maxServicingTime = Integer.parseInt(inputView.getMaxServiceTimeField().getText());
                selectionPolicy = SelectionPolicy.SHORTEST_QUEUE;

                inputView.getWindowFrame1().setVisible(false);
                SimulationManager simulationManager = new SimulationManager(timeLimit, maxServicingTime, minServicingTime, maxArrivingTime, minArrivingTime,numberOfCustomers, numberOfServers, selectionPolicy);
                outputView = new OutputView();
                simulationManager.setOutputView(outputView);

                Thread thread = new Thread(simulationManager);
                thread.start();
            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this,"<html><font color=#ff0000>Invalid data!</font> ","Error",JOptionPane.ERROR_MESSAGE);
            }
        });

        inputView.getShortestTimeStrategyButton().addActionListener(e -> {
            try
            {
                int timeLimit, maxServicingTime, minServicingTime, maxArrivingTime, minArrivingTime, numberOfCustomers, numberOfServers;
                SelectionPolicy selectionPolicy;

                numberOfCustomers = Integer.parseInt(inputView.getNrCustomersField().getText());
                numberOfServers = Integer.parseInt(inputView.getNrQueuesField().getText());
                timeLimit = Integer.parseInt(inputView.getSimulationTimeField().getText());
                minArrivingTime = Integer.parseInt(inputView.getMinArrivalTimeField().getText());
                maxArrivingTime = Integer.parseInt(inputView.getMaxArrivalTimeField().getText());
                minServicingTime = Integer.parseInt(inputView.getMinServiceTimeField().getText());
                maxServicingTime = Integer.parseInt(inputView.getMaxServiceTimeField().getText());
                selectionPolicy = SelectionPolicy.SHORTEST_TIME;

                inputView.getWindowFrame1().setVisible(false);
                SimulationManager simulationManager = new SimulationManager(timeLimit, maxServicingTime, minServicingTime, maxArrivingTime, minArrivingTime,numberOfCustomers, numberOfServers, selectionPolicy);
                outputView = new OutputView();
                simulationManager.setOutputView(outputView);


                Thread thread = new Thread(simulationManager);
                thread.start();

            }
            catch (NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(this,"<html><font color=#ff0000>Invalid data!</font> ","Error",JOptionPane.ERROR_MESSAGE);
            }
        });


    }

    public InputView getInputView() {
        return inputView;
    }

    public void setInputView(InputView inputView) {
        this.inputView = inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

    public void setOutputView(OutputView outputView) {
        this.outputView = outputView;
    }
}
