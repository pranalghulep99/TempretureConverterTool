//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.project.TempConverterTool;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class TempController implements Initializable {
	@FXML
	public Label welcomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField tempTextField;
	@FXML
	public Button convertButton;
	private static final String Cel_to_F = "Celsius to Fahrenheit";
	private static final String F_to_Cel = "Fahrenheit to Celsius";
	private static boolean is_C_to_F = true;

	public TempController() {
	}

	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.choiceBox.getItems().add("Celsius to Fahrenheit");
		this.choiceBox.getItems().add("Fahrenheit to Celsius");
		this.choiceBox.setValue("Celsius to Fahrenheit");
		this.choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
				System.out.println(newValue);
				if (newValue == "Celsius to Fahrenheit") {
					TempController.is_C_to_F = true;
				} else {
					TempController.is_C_to_F = false;
				}

			}
		});
		this.convertButton.setOnAction((actionEvent) -> {
			this.convert();
		});
	}

	private void convert() {
		String userEnteredText = this.tempTextField.getText();
		double userTemp = 0.0;

		try {
			userTemp = Double.parseDouble(userEnteredText);
		} catch (Exception var6) {
			this.invalidInput();
			return;
		}

		double newTemp = 0.0;
		if (is_C_to_F) {
			newTemp = userTemp * 9.0 / 5.0 + 32.0;
		} else {
			newTemp = (userTemp - 32.0) * 5.0 / 9.0;
		}

		this.display(newTemp);
	}

	private void invalidInput() {
		Alert invalidInputAlert = new Alert(AlertType.ERROR);
		invalidInputAlert.setTitle("ERROR OCCURRED!");
		invalidInputAlert.setContentText("!!Please Enter Valid Temperature As Input!!");
		invalidInputAlert.show();
	}

	private void display(double newTemp) {
		String unit = is_C_to_F ? "F" : "C";
		System.out.println("New Temperature is : " + newTemp + " " + unit);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("New Temperature is : " + newTemp + " " + unit);
		alert.show();
	}
}
