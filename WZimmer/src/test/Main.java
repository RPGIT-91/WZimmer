package test;



public class Main {
    public static void main(String[] args) {
        MyView view = new MyView();
        Controller controller = new Controller(view);

        view.setVisible(true);
    }
}