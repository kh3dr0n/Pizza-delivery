package kheder.com.pizza.Model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Marwen on 5/9/17.
 */

public class Commande implements Serializable{
    int size;
    double latitude;
    double longitude;
    HashMap<Integer,Integer> ingridents;
    Float prix;



    public HashMap<Integer, Integer> getIngridents() {
        return ingridents;
    }

    public void setIngridents(HashMap<Integer, Integer> ingridents) {
        this.ingridents = ingridents;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "size=" + size +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", ingridents=" + ingridents +
                '}';
    }
}
