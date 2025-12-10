package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exceptions.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public void addMedia(Media media)
    {
        if(itemsOrdered.size() < MAX_NUMBERS_ORDERED)
        {
            itemsOrdered.add(media);
            System.out.println("Added " + media.getTitle());
        }
        else
        {
            System.out.println("Full");
        }
    }

    public ObservableList<Media> getItemsOrdered()
    {
        return itemsOrdered;
    }
    

    public void removeMedia(Media media) {
        try {
            if (itemsOrdered.contains(media)) {
                itemsOrdered.remove(media);
                System.out.println("Removed " + media.getTitle());
            } else {
                System.out.println("Not exist");
            }
        } catch (NullPointerException e) {
            System.out.println("null media");
        } catch (ClassCastException e) {
            System.out.println("invalid media type for comparison");
        }
    }

    public void removeMedia(int index)
    {
        if(index >=0 && index < itemsOrdered.size())
        {
            Media media = itemsOrdered.get(index);
            itemsOrdered.remove(index);
            System.out.println("Removed " + media.getTitle());
        }
        else
        {
            System.out.println("Not exist");
        }
    }

    public void clearCart()
    {
        itemsOrdered.clear();
        System.out.println("cleared");
    }

    public void playMedia(int index) throws PlayerException
    {
        if(index >=0 && index < itemsOrdered.size())
        {
            Media media = itemsOrdered.get(index);
            if(media instanceof Playable)
            {

                ((Playable) media).play();
            
            }
            else
            {
                System.out.println("Can't play");
            }
        }
        else
        {
            System.out.println("Not exist");
        }
    }

    public float totalCost()
    {
        float s = 0;
        for(int i = 0; i < itemsOrdered.size(); i++)
        {
            s += itemsOrdered.get(i).getCost();
        }
        return s;
    }
    public void exit()
    {
        System.exit(0);
    }

    public void printCart()
    {
        System.out.println("***********************CART***********************");
        for(int i =0; i< itemsOrdered.size(); i++)
        {
            System.out.println(itemsOrdered.get(i).toString());
        }
        System.out.println("Total cost: "+totalCost());
        System.out.println("***************************************************");
    }

    public int searchID(int id)
    {
        for(int i =0; i< itemsOrdered.size(); i++)
        {
            if(itemsOrdered.get(i).getId() == id)
            {
                System.out.println("Found, at pos " + i);
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public int searchTitle(String title)
    {
        for(int i =0; i< itemsOrdered.size(); i++)
        {
            if(itemsOrdered.get(i).getTitle().equals(title))
            {
                System.out.println("Found, at pos " + i);
                return i;
            }
        }
        System.out.println("Not found");
        return -1;
    }

    public void sortByTitleCost()
    {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
        printCart();
    }

    public void sortByCostTitle()
    {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
        printCart();
    }


    public ObservableList<Media> filterByID(int id) {
        ObservableList<Media> filtered = FXCollections.observableArrayList();
        for(Media media : itemsOrdered) {
            if(media.getId() == id) {
                filtered.add(media);
            }
        }
        return filtered;
    }

    public ObservableList<Media> filterByTitle(String title) {
        ObservableList<Media> filtered = FXCollections.observableArrayList();
        for(Media media : itemsOrdered) {
            if(media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                filtered.add(media);
            }
        }
        return filtered;
    }

    public void playMedia(Media media) throws PlayerException
    {
        if (itemsOrdered.contains(media)) {
            if(media instanceof Playable)
            {
                ((Playable)media).play();
            }
        }   
    }
}
