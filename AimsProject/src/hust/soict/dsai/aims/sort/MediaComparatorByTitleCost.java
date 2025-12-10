package hust.soict.dsai.aims.sort;

import java.util.Comparator;

import hust.soict.dsai.aims.media.Media;

public class MediaComparatorByTitleCost implements Comparator<Media> {
    
    public int compare(Media m1, Media m2) {
        if (!m1.getTitle().equals(m2.getTitle())) {
            return m1.getTitle().compareTo(m2.getTitle());
        } else {
            return Float.compare(m1.getCost(), m2.getCost());
        }
    }
}
