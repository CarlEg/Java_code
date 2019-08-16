package sample;

import datamodel.TodoItem;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItemList;

    @FXML
    private ListView<TodoItem> listView;

    @FXML
    private TextArea descriptionText;

    @FXML
    private Label deadlineLabel;

    public void initialize(){
        TodoItem birthdayCard = new TodoItem("Birthday card", "Buy a birthday card for the old man's 60th",
                LocalDate.of(2019,8,20));
        TodoItem carInsurance = new TodoItem("Car insurance", "Pay for my car insurance on the 27th of August",
                LocalDate.of(2019,8,27));
        TodoItem lockIn = new TodoItem("Lock in", "Lock in at work on the 14th of August",
                LocalDate.of(2019,8,14));

        todoItemList = new ArrayList<>();

        todoItemList.add(birthdayCard);
        todoItemList.add(carInsurance);
        todoItemList.add(lockIn);

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observableValue, TodoItem todoItem, TodoItem t1) {
                if (t1 != null){
                    TodoItem item = listView.getSelectionModel().getSelectedItem();

                    descriptionText.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                    deadlineLabel.setText(df.format(item.getDeadline()));
                }
            }
        });

        listView.getItems().setAll(todoItemList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        listView.getSelectionModel().selectFirst();

    }

    @FXML
    public void handleListClick(){
        TodoItem item = listView.getSelectionModel().getSelectedItem();
        descriptionText.setText(item.getDetails());
        deadlineLabel.setText(item.getDeadline().toString());
//        StringBuilder sb = new StringBuilder();
//        sb.append("\n\n\n\n");
//        sb.append("Due: ");
//        sb.append(item.getDeadline().toString());
//        deadlineLabel.setText(sb.toString());
        System.out.println(item.getShortDescription() + " selected");
    }

}
