package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame{
    private Store store;
    public Cart cart;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private JFXPanel cartFXPanel;
    private UpdateScreen updateScreen;
    private JPanel storePanel;
    private int currentPage = 0;
    private static final int ITEMS_PER_PAGE = 9;
    private ArrayList<Media> filteredMedia;
    private JTextField searchField;
    
    private static final String STORE_VIEW = "STORE";
    private static final String CART_VIEW = "CART";
    private static final String UPDATE_VIEW = "UPDATE";

    JPanel createNorth()
    {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        north.add(createSearchPanel());
        return north;
    }

    JMenuBar createMenuBar() {

        JMenu menu = new JMenu("Options");
        
        JMenu smUpdateStore = new JMenu("Update Store");
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> showUpdateView("BOOK"));
        smUpdateStore.add(addBook);
        
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> showUpdateView("CD"));
        smUpdateStore.add(addCD);
        
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> showUpdateView("DVD"));
        smUpdateStore.add(addDVD);
        
        menu.add(smUpdateStore);
        
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> showStoreView());
        menu.add(viewStore);

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> showCartView());
        menu.add(viewCart);
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        
        return menuBar;

    }

    JPanel createHeader() {

        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton cartBtn = new JButton("View cart");
        cartBtn.setPreferredSize(new Dimension(100, 50));
        cartBtn.setMaximumSize(new Dimension(100, 50));
        cartBtn.addActionListener(e -> showCartView());

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartBtn);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;

    }
    
    JPanel createSearchPanel() {
        JPanel searchPanel = new JPanel();
        searchPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel searchLabel = new JLabel("Search by title:");
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton resetButton = new JButton("Reset");
        
        
        searchButton.addActionListener(e -> performSearch());
        
        resetButton.addActionListener(e -> {
            searchField.setText("");
            filteredMedia = null;
            currentPage = 0;
            refreshStorePage();
        });
        
        searchPanel.add(searchLabel);
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(resetButton);
        
        return searchPanel;
    }
    
    private void performSearch() {
        String searchText = searchField.getText().toLowerCase().trim();
        
        if (searchText.isEmpty()) {
            filteredMedia = null;
        } else {
            filteredMedia = new ArrayList<>();
            for (Media media : store.getItemsInStore()) {
                if (media.getTitle().toLowerCase().contains(searchText)) {
                    filteredMedia.add(media);
                }
            }
        }
        currentPage = 0;
        refreshStorePage();
    }
    
    private ArrayList<Media> getDisplayMedia() {
        return filteredMedia != null ? filteredMedia : store.getItemsInStore();
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = getDisplayMedia();
        int startIndex = currentPage * ITEMS_PER_PAGE;
        int endIndex = Math.min(startIndex + ITEMS_PER_PAGE, mediaInStore.size());
        
        for (int i = startIndex; i < endIndex; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), this);
            center.add(cell);
        }
        
        for (int i = endIndex - startIndex; i < ITEMS_PER_PAGE; i++) {
            center.add(new JPanel());
        }

        return center;
    }
    
    JPanel createSouth() {
        JPanel south = new JPanel();
        south.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JButton btnPrevious = new JButton("Previous");
        JButton btnNext = new JButton("Next");
        JLabel pageLabel = new JLabel();
        
        updatePageLabel(pageLabel);
        
        btnPrevious.addActionListener(e -> {
            if (currentPage > 0) {
                currentPage--;
                refreshStorePage();
                updatePageLabel(pageLabel);
                btnPrevious.setEnabled(currentPage > 0);
                btnNext.setEnabled(currentPage < getTotalPages() - 1);
            }
        });
        
        btnNext.addActionListener(e -> {
            if (currentPage < getTotalPages() - 1) {
                currentPage++;
                refreshStorePage();
                updatePageLabel(pageLabel);
                btnPrevious.setEnabled(currentPage > 0);
                btnNext.setEnabled(currentPage < getTotalPages() - 1);
            }
        });
        
        btnPrevious.setEnabled(currentPage > 0);
        btnNext.setEnabled(currentPage < getTotalPages() - 1);
        
        south.add(btnPrevious);
        south.add(pageLabel);
        south.add(btnNext);
        
        return south;
    }
    
    private void updatePageLabel(JLabel label) {
        int totalPages = getTotalPages();
        label.setText(String.format("Page %d of %d", currentPage + 1, totalPages));
    }
    
    private int getTotalPages() {
        int totalItems = getDisplayMedia().size();
        return Math.max(1, (int) Math.ceil((double) totalItems / ITEMS_PER_PAGE));
    }

    public void removeMedia(Media media)
    {
        store.removeMedia(media);
        refreshStore();
    }
    
    private void refreshStorePage() {
        storePanel.removeAll();
        storePanel.add(createNorth(), BorderLayout.NORTH);
        storePanel.add(createCenter(), BorderLayout.CENTER);
        storePanel.add(createSouth(), BorderLayout.SOUTH);
        storePanel.revalidate();
        storePanel.repaint();
    }
    
    private JPanel createStorePanel() {
        storePanel = new JPanel(new BorderLayout());
        storePanel.add(createNorth(), BorderLayout.NORTH);
        storePanel.add(createCenter(), BorderLayout.CENTER);
        storePanel.add(createSouth(), BorderLayout.SOUTH);
        return storePanel;
    }
    
    private JFXPanel createCartPanel() {
        cartFXPanel = new JFXPanel();
        
        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("cart.fxml"));
                CartScreenController controller = new CartScreenController(cart, this);
                loader.setController(controller);
                Parent root = loader.load();
                cartFXPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        
        return cartFXPanel;
    }
    
    private JFXPanel createUpdatePanel() {
        updateScreen = new UpdateScreen(store);
        return updateScreen.getUpdatePanel(this);
    }
    
    public void showStoreView() {
        cardLayout.show(mainPanel, STORE_VIEW);
        setTitle("Store");
    }
    
    public void showCartView() {
        cardLayout.show(mainPanel, CART_VIEW);
        setTitle("Cart");
    }
    
    public void showUpdateView(String mediaType) {
        cardLayout.show(mainPanel, UPDATE_VIEW);
        setTitle("Update Store - Add " + mediaType);
        updateScreen.setMediaType(mediaType);
    }
    
    public void refreshStore() {
        refreshStorePage();
    }
    
public StoreScreen(Store store) {
    this.store = store;
    this.cart = new Cart();
    
    cardLayout = new CardLayout();
    mainPanel = new JPanel(cardLayout);
    
    mainPanel.add(createStorePanel(), STORE_VIEW);
    JFXPanel cartPanel = createCartPanel();
    mainPanel.add(cartPanel, CART_VIEW);
    
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    
    mainPanel.add(createUpdatePanel(), UPDATE_VIEW);
    
    Container cp = getContentPane();
    cp.add(mainPanel);
    
    cardLayout.show(mainPanel, STORE_VIEW);
    
    setTitle("Store");
    setSize(1024, 768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}
}