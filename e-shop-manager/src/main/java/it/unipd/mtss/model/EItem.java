////////////////////////////////////////////////////////////////////
// Gabriele Da Re 2008071
// Claudio Giaretta 1225419
////////////////////////////////////////////////////////////////////
package it.unipd.mtss.model;
import java.time.LocalTime;

public class EItem {
    public enum ItemType{
        PROCESSOR, MOTHERBOARD, MOUSE, KEYBOARD;
    }

    private final ItemType type;
    private final String name;
    private final double price;
    private LocalTime time;

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

        time = LocalTime.now();

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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime _time) throws IllegalArgumentException {
        if (_time == null) {
            throw new IllegalArgumentException("L'orario non può essere nullo");
        }

        time = _time;
    }

    public boolean isDuringWinningTime() {
        return this.getTime().isAfter(LocalTime.of(18, 0, 0)) && this.getTime().isBefore(LocalTime.of(19, 0, 0));
    }
}

