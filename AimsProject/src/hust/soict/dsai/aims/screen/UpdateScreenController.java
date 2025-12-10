package hust.soict.dsai.aims.screen;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import hust.soict.dsai.aims.store.Store;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.media.*;

public class UpdateScreenController {
    
    private Store store;
    private StoreScreen storeScreen;
    
    @FXML
    private RadioButton radioBook, radioCD, radioDVD;
    
    @FXML
    private VBox bookForm, cdForm, dvdForm;
    
    // Book fields
    @FXML
    private TextField bookTitle, bookCategory, bookCost, bookAuthors;
    
    // CD fields
    @FXML
    private TextField cdTitle, cdCategory, cdCost, cdArtist, cdDirector, cdLength;
    
    // DVD fields
    @FXML
    private TextField dvdTitle, dvdCategory, dvdCost, dvdDirector, dvdLength;
    
    public UpdateScreenController(Store store, StoreScreen storeScreen) {
        this.store = store;
        this.storeScreen = storeScreen;
    }
    
    @FXML
    private void initialize() {
        // Default to book form
        showForm("BOOK");
    }
    
    public void showForm(String mediaType) {
        // Hide all forms first
        bookForm.setVisible(false);
        cdForm.setVisible(false);
        dvdForm.setVisible(false);
        
        // Select appropriate radio button and show form
        switch (mediaType.toUpperCase()) {
            case "BOOK":
                radioBook.setSelected(true);
                bookForm.setVisible(true);
                break;
            case "CD":
                radioCD.setSelected(true);
                cdForm.setVisible(true);
                break;
            case "DVD":
                radioDVD.setSelected(true);
                dvdForm.setVisible(true);
                break;
        }
    }
    
    @FXML
    private void handleMediaTypeChange(ActionEvent event) {
        bookForm.setVisible(false);
        cdForm.setVisible(false);
        dvdForm.setVisible(false);
        
        if (radioBook.isSelected()) {
            bookForm.setVisible(true);
        } else if (radioCD.isSelected()) {
            cdForm.setVisible(true);
        } else if (radioDVD.isSelected()) {
            dvdForm.setVisible(true);
        }
    }
    
    @FXML
    private void handleAddMedia(ActionEvent event) {
        try {
            if (radioBook.isSelected()) {
                addBook();
            } else if (radioCD.isSelected()) {
                addCD();
            } else if (radioDVD.isSelected()) {
                addDVD();
            }
        } catch (LimitExceededException e) {
            showAlert("Error", "Failed to add media: " + e.getMessage());
        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid number format. Please check your input.");
        } catch (IllegalArgumentException e) {
            showAlert("Error", e.getMessage());
        }
    }
    
    private void addBook() throws LimitExceededException, IllegalArgumentException, NumberFormatException {
        String title = bookTitle.getText().trim();
        String category = bookCategory.getText().trim();
        float cost = Float.parseFloat(bookCost.getText().trim());
        
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0");
        }
        
        Book book = new Book(title, category, cost);
        
        String authorsText = bookAuthors.getText().trim();
        if (!authorsText.isEmpty()) {
            String[] authors = authorsText.split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
        }

        store.addMedia(book);
        showAlert("Success", "Book added successfully! ID: " + book.getId());
        clearBookForm();
    }
    
    private void addCD() throws LimitExceededException, IllegalArgumentException, NumberFormatException {
        String title = cdTitle.getText().trim();
        String category = cdCategory.getText().trim();
        float cost = Float.parseFloat(cdCost.getText().trim());
        String artist = cdArtist.getText().trim();
        String director = cdDirector.getText().trim();
        int length = Integer.parseInt(cdLength.getText().trim());
        
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0");
        }

        CompactDisc cd = new CompactDisc(title, category, cost, director, length, artist);
        store.addMedia(cd);
        showAlert("Success", "CD added successfully! ID: " + cd.getId());
        clearCDForm();
    }
    
    private void addDVD() throws LimitExceededException, NumberFormatException, IllegalArgumentException {
        String title = dvdTitle.getText().trim();
        String category = dvdCategory.getText().trim();
        float cost = Float.parseFloat(dvdCost.getText().trim());
        String director = dvdDirector.getText().trim();
        int length = Integer.parseInt(dvdLength.getText().trim());
        
        if (title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        if (length <= 0) {
            throw new IllegalArgumentException("Length must be greater than 0");
        }
        if (cost <= 0) {
            throw new IllegalArgumentException("Cost must be greater than 0");
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);
        store.addMedia(dvd);
        showAlert("Success", "DVD added successfully! ID: " + dvd.getId());
        clearDVDForm();
    }
    
    private void clearBookForm() {
        bookTitle.clear();
        bookCategory.clear();
        bookCost.clear();
        bookAuthors.clear();
    }
    
    private void clearCDForm() {
        cdTitle.clear();
        cdCategory.clear();
        cdCost.clear();
        cdArtist.clear();
        cdDirector.clear();
        cdLength.clear();
    }
    
    private void clearDVDForm() {
        dvdTitle.clear();
        dvdCategory.clear();
        dvdCost.clear();
        dvdDirector.clear();
        dvdLength.clear();
    }
    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    
    @FXML
    private void viewStore() {
        if (storeScreen != null) {
            storeScreen.showStoreView();
        }
    }
    
    @FXML
    private void viewCart() {
        if (storeScreen != null) {
            storeScreen.showCartView();
        }
    }
}