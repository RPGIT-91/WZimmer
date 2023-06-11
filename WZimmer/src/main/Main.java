//Main

package main;
import gui.*;

public class Main {
    public static void main(String[] args) {
        MyView view = new MyView();
        Controller controller = new Controller(view);

    }
}