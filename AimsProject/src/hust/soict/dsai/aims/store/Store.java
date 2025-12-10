package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import java.util.Arrays;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class Store {
    public static final int MAX_ITEMS_IN_STORE = 100;
    private int itemCount = 0;
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) throws LimitExceededException {
        if (itemCount >= MAX_ITEMS_IN_STORE) {
            throw new LimitExceededException("Error: max media in store");
        }
        
        itemsInStore.add(media);
        itemCount++;
        System.out.println("Media added to store: " + media.getTitle());
    }


    public void removeMedia(Media media) {
        try {
            if (itemsInStore.contains(media)) {
                itemsInStore.remove(media);
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
    public void displayStore() {
        System.out.println("******************** STORE ********************");
        System.out.println("Available Media in store (" + itemCount + " items):");
        for (int i = 0; i < itemCount; i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***********************************************");
    }

    public int getItemCount() {
        return itemCount;
    }
    public Media getMedia(int id)
    {
        return itemsInStore.get(id);
    }

    public void playMedia(int id) throws PlayerException
    {
        Media media = itemsInStore.get(id);
        if(media != null)
        {
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

    public Store() {
        super();
    }

    public Store(Media... medias) {
        super();
        this.itemsInStore = new ArrayList<Media>(Arrays.asList(medias));
        this.itemCount = itemsInStore.size();
    }

    public void updateStore(Media... medias) {
        this.itemsInStore = new ArrayList<Media>(Arrays.asList(medias));
        this.itemCount = itemsInStore.size();
    }

    public void updateStore() {
        this.itemCount = itemsInStore.size();
    }

    public ArrayList<Media> getItemsInStore()
    {
        return itemsInStore;
    }

}