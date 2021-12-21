package id.ac.upj.tif.pbouas;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

import java.io.IOException;

public class Login {
    public Login() {

    }

    @FXML
    private Button btnLogin;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username_text;
    @FXML
    private PasswordField password_text;



    public void onClickButtonMasuk(ActionEvent actionEvent) throws IOException {
        checkLogin();
    }

    private void checkLogin() throws IOException {
        PboUasApplication m = new PboUasApplication();
        if(username_text.getText().toString().equals("javacoding") && password_text.getText().toString().equals("123")) {

            m.changeScene("pbo-uas.fxml");
        }
    }
}
