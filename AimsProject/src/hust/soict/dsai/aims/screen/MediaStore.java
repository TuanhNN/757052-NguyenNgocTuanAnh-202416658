package hust.soict.dsai.aims.screen;

import javax.swing.*;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.awt.*;
import java.awt.event.*;

import hust.soict.dsai.aims.exceptions.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private StoreScreen store;
    public MediaStore(Media media, StoreScreen store) {
        this.store = store;
        this.media = media;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                JDialog dialog = new JDialog();
                dialog.setTitle("Add to cart");
                JLabel label = new JLabel(media.getTitle() + " has been added to cart");
                Platform.runLater(() -> {
                    store.cart.addMedia(media);
                });
                
                label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
                label.setAlignmentX(CENTER_ALIGNMENT);
                dialog.add(label);
                dialog.setSize(400, 100);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
            }
        });

        container.add(addToCartButton);

        JButton playButton = new JButton("Play");
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (media instanceof Playable) {
                    JDialog dialog = new JDialog();
                    dialog.setTitle("Playing");
                    JLabel label = new JLabel("Playing " + media.getTitle());
                    try {
                        ((Playable) media).play();
                    } catch (PlayerException e1) {
                        
                        alert(e1.getMessage());
                    }
                    label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 20));
                    label.setAlignmentX(CENTER_ALIGNMENT);
                    dialog.add(label);
                    dialog.setSize(400, 100);
                    dialog.setLocationRelativeTo(null);
                    dialog.setVisible(true);
                }
            }
        });

        if (media instanceof Playable) {
            container.add(playButton);
        }
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                store.removeMedia(media);
            }
        });
        container.add(removeButton);
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
        
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
    private void alert(String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Attention");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}