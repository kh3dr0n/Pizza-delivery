package kheder.com.pizza.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import kheder.com.pizza.Model.FlatCommande;
import kheder.com.pizza.R;

/**
 * Created by Marwen on 5/10/17.
 */

public class CommandeArrayAdapter extends ArrayAdapter<FlatCommande> {


    String[] sizeName = {"MEGA","GIGA","TETA","PETA"};
    String[] ingrid = {"","Cheese","Olive","Mushroom","Tomato","Basil","Onion","Green pepper","Chili","Pepperoni"};

    private Context context;
    private List<FlatCommande> commands;

    public CommandeArrayAdapter(Context context, int resource, ArrayList<FlatCommande> objects) {
        super(context, resource, objects);

        this.context = context;
        this.commands = objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {



        FlatCommande commande = commands.get(position);

        //get the inflater and inflate the XML layout for each item
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.commandelistitem, null);


        TextView size = (TextView) view.findViewById(R.id.size);
        TextView ing = (TextView) view.findViewById(R.id.ingridens);
        TextView date = (TextView) view.findViewById(R.id.date);
        TextView prix = (TextView) view.findViewById(R.id.prix);

        size.setText(sizeName[commande.getSize()]);
        date.setText(commande.getDate());
        String tmp = "";

        if(commande.getIng1() > 0){
            tmp += ingrid[1] + (commande.getIng1() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng2() > 0){
            tmp += ingrid[2] + (commande.getIng2() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng3() > 0){
            tmp += ingrid[3] + (commande.getIng3() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng4() > 0){
            tmp += ingrid[4] + (commande.getIng4() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng5() > 0){
            tmp += ingrid[5] + (commande.getIng5() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng6() > 0){
            tmp += ingrid[6] + (commande.getIng6() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng7() > 0){
            tmp += ingrid[7] + (commande.getIng7() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng8() > 0){
            tmp += ingrid[8] + (commande.getIng8() == 1 ? "" : "(Extra)") +", ";
        }
        if(commande.getIng9() > 0){
            tmp += ingrid[9] + (commande.getIng9() == 1 ? "" : "(Extra)") +", ";
        }


        prix.setText(Double.toString(commande.getPrix()));



        ing.setText(tmp);



        return view;


    }
}
