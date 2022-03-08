package Model;

import Controller.InputController;
import View.InputView;

public class Main {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        new InputController(inputView);
    }
}
