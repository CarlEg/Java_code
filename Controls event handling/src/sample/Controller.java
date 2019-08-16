package sample;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button hi;
    @FXML
    private Button bye;
    @FXML
    private CheckBox checkBox;
    @FXML
    private Label ourLabel;

    @FXML
    public void initialize(){
        hi.setDisable(true);
        bye.setDisable(true);
    }

    @FXML
    public void onButtonClicked(ActionEvent event){
        if (event.getSource().equals(hi)){
            System.out.println("Hi " + nameField.getText());
            checkBoxChecked();
        }else if (event.getSource().equals(bye)){
            System.out.println("Bye " + nameField.getText());
            checkBoxChecked();
        }

        Runnable task = new Runnable() {
            @Override
            public void run() {
                try{
                    String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI Thread" : "Background Thread";
                            System.out.println("I'm updating on the: " + s);
                            ourLabel.setText("We did something!");
                        }
                    });
                }catch (InterruptedException interrupt){

                }
        }

        };
        new Thread(task).start();
    }

    @FXML
    public void handleKeyReleased(){
        String text = nameField.getText();
        boolean buttonState = text.isEmpty() || text.trim().isEmpty();
        hi.setDisable(buttonState);
        bye.setDisable(buttonState);
    }

    @FXML
    public void checkBoxChecked(){
        boolean checked = checkBox.isSelected();
        if (checked){
            nameField.clear();
            hi.setDisable(true);
            bye.setDisable(true);
        }
    }
}
