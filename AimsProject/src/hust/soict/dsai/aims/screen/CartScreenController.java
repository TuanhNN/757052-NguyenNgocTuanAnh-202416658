package hust.soict.dsai.aims.screen;

import javafx.beans.value.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exceptions.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.sort.*;


public class CartScreenController {

    private Cart cart;
    private StoreScreen storeScreen;

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnOrder;

    @FXML
    private Button btnRemove;
    
    @FXML
    private TextField tfFilter;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costText;

    public CartScreenController(Cart cart, StoreScreen storeScreen) {
        super();
        this.cart = cart;
        this.storeScreen = storeScreen;
    }
    

    public CartScreenController(Cart cart) {
		super();
		this.cart = cart;
	}


	@FXML
    private void initialize() {

        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));
        tblMedia.setItems(this.cart.getItemsOrdered());
        costText.setText("0$");
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
        cart.getItemsOrdered().addListener((javafx.collections.ListChangeListener<Media>) change -> { updateTotalCost();});
        tblMedia.getSelectionModel().selectedItemProperty().addListener( new ChangeListener<Media>() {
                @Override
                public void changed(ObservableValue<? extends Media> observable,
                                    Media oldValue, Media newValue) {
                    if (newValue != null) {
                        updateButtonBar(newValue);
                    }
                }
            }
        );

        tfFilter.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldVal, String newVal)
            {
                showFiltedMedia(newVal);
            }
            
        });
        updateTotalCost();  
    }

    void showFiltedMedia(String newVal) {
        if (newVal == null || newVal.isEmpty()) {
            tblMedia.setItems(cart.getItemsOrdered());
            return;
        }
        
        if (radioBtnFilterId.isSelected()) {
            int id = Integer.parseInt(newVal);
            tblMedia.setItems(cart.filterByID(id));
        } else {
            tblMedia.setItems(cart.filterByTitle(newVal));
        }
    }

    void updateButtonBar(Media media)
    {
        btnRemove.setVisible(true);
        if(media instanceof Playable)
        {
            btnPlay.setVisible(true);
        }
        else
        {
            btnPlay.setVisible(false);
        }
    }

    @FXML
    void btnOrderPressed(ActionEvent e)
    {
        alert("Order Placed");
        cart.clearCart();
    }

    @FXML
    void btnRemovePressed(ActionEvent e)
    {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia(media);
    }

    @FXML
    void btnPlayPressed(ActionEvent e)
    {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        alert("Playing media, check console");
        try {
            cart.playMedia(media);
        } catch (PlayerException e1) {
            alert("Media length < 0");
        }
    }

    private void updateTotalCost() {
        costText.setText(String.format("%.2f$", cart.totalCost()));}


    private void alert(String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML 
    private void viewStore(){
        if (storeScreen != null) {
            storeScreen.showStoreView();
        }
    }

    @FXML
    private void sortByName()
    {
        ArrayList<Media> sortedList = new ArrayList<>(cart.getItemsOrdered());
        Collections.sort(sortedList, new MediaComparatorByTitleCost());
        tblMedia.setItems(FXCollections.observableArrayList(sortedList));
    }

    @FXML
    private void sortByCost()
    {
        ArrayList<Media> sortedList = new ArrayList<>(cart.getItemsOrdered());
        Collections.sort(sortedList, new MediaComparatorByCostTitle());
        tblMedia.setItems(FXCollections.observableArrayList(sortedList));
    }
}