package hust.soict.dsai.aims.sort;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByCostTitle implements Comparator<Media> {
    public int compare(Media m1, Media m2) {
        if (m1.getCost() != m2.getCost()) {
            return Float.compare(m1.getCost(), m2.getCost());
        } else {
            return m1.getTitle().compareTo(m2.getTitle());
        }
    }

    
}