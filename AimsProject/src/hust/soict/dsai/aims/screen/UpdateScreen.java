package hust.soict.dsai.aims.screen;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.store.Store;

import java.io.IOException;

public class UpdateScreen {
    private Store store;
    private JFXPanel fxPanel;
    private UpdateScreenController controller;
    
    public UpdateScreen(Store store) {
        this.store = store;
    }
    
    public JFXPanel getUpdatePanel(StoreScreen storeScreen) {
        fxPanel = new JFXPanel();
        
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("update.fxml"));
                controller = new UpdateScreenController(store, storeScreen);
                loader.setController(controller);
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        
        return fxPanel;
    }
    
    public void setMediaType(String mediaType) {
        Platform.runLater(() -> {
            if (controller != null) {
                controller.showForm(mediaType);
            }
        });
    }
}