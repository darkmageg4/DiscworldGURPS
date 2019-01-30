package discworldgurps.data;

import java.util.Comparator;


public class ItemComparator implements Comparator<ItemLoader>{
    
        @Override
    public int compare(ItemLoader i1, ItemLoader i2) {
        return i1.getA().compareToIgnoreCase(i2.getA());
    }

}
