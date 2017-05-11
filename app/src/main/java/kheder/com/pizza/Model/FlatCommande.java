package kheder.com.pizza.Model;

/**
 * Created by Marwen on 5/10/17.
 */

public class FlatCommande {

    int size;
    double latitude;
    double longitude;
    int ing1,ing2,ing3,ing4,ing5,ing6,ing7,ing8,ing9;
    String date;
    double prix;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public FlatCommande(int size, double latitude, double longitude, int ing1, int ing2, int ing3, int ing4, int ing5, int ing6, int ing7, int ing8, int ing9, String date, double prix) {
        this.size = size;
        this.latitude = latitude;
        this.longitude = longitude;
        this.ing1 = ing1;
        this.ing2 = ing2;
        this.ing3 = ing3;
        this.ing4 = ing4;
        this.ing5 = ing5;
        this.ing6 = ing6;
        this.ing7 = ing7;
        this.ing8 = ing8;
        this.ing9 = ing9;
        this.date = date;
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

    public int getIng1() {
        return ing1;
    }

    public void setIng1(int ing1) {
        this.ing1 = ing1;
    }

    public int getIng2() {
        return ing2;
    }

    public void setIng2(int ing2) {
        this.ing2 = ing2;
    }

    public int getIng3() {
        return ing3;
    }

    public void setIng3(int ing3) {
        this.ing3 = ing3;
    }

    public int getIng4() {
        return ing4;
    }

    public void setIng4(int ing4) {
        this.ing4 = ing4;
    }

    public int getIng5() {
        return ing5;
    }

    public void setIng5(int ing5) {
        this.ing5 = ing5;
    }

    public int getIng6() {
        return ing6;
    }

    public void setIng6(int ing6) {
        this.ing6 = ing6;
    }

    public int getIng7() {
        return ing7;
    }

    public void setIng7(int ing7) {
        this.ing7 = ing7;
    }

    public int getIng8() {
        return ing8;
    }

    public void setIng8(int ing8) {
        this.ing8 = ing8;
    }

    public int getIng9() {
        return ing9;
    }

    public void setIng9(int ing9) {
        this.ing9 = ing9;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
