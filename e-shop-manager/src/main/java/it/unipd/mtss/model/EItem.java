////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;

public class EItem {
    public enum ItemType{
        PROCESSOR, MOTHERBOARD, MOUSE, KEYBOARD;
    }

    private final ItemType type;
    private final String name;
    private final double price;

    public EItem(ItemType _type, String _name, double _price) throws IllegalArgumentException {
        if (_type == null) {
            throw new IllegalArgumentException("Il ItemType non può essere nullo");
        }
        if (_name == null) {
            throw new IllegalArgumentException("Il nome non può essere nullo");
        }
        if (_name == "") {
            throw new IllegalArgumentException("Il nome non può essere vuoto");
        }
        if (_price<0) {
            throw new IllegalArgumentException("Il prezzo non può essere negativo");
        }
        this.type = _type;
        this.name = _name;
        this.price = _price;
    }

    public ItemType getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

