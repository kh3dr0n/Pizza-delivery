package kheder.com.pizza.activites;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.Profile;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.Map;

import kheder.com.pizza.Model.Commande;
import kheder.com.pizza.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FinishActivity extends AppCompatActivity implements OnMapReadyCallback {

    Commande commande;

    Profile profile;
    FinishActivity that = this;
    ProgressDialog ringProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        Float prix = 0F;

        String[] size = {"MEGA","GIGA","TETA","PETA"};
        String[] ingrid = {"Cheese","Olive","Mushroom","Tomato","Basilic","Onion","Green pepper","Chili","Pepperoni"};
        Float[] prices = {2F,0.5F,1F,0.5F,0.2F,0.3F,0.5F,0.4F,2F};

        commande = (Commande) getIntent().getSerializableExtra("commande");

        TextView details = (TextView)findViewById(R.id.textView4);

        String tmp = "Size :" + size[commande.getSize()] + "\n";
        HashMap<Integer,Integer> sets = commande.getIngridents();
        for (int i = 0; i < 9; i++) {
            if(sets.get(i+1) > 0){
                tmp += ingrid[i] + ": " + (sets.get(i+1) == 1 ? "Normal" : "Extra") +"\n";
                prix += sets.get(i+1)*prices[i];
            }

        }



        prix = prix + prix*commande.getSize()*0.3F;


        switch (commande.getSize()){
            case 0:
                prix += 7;
                break;
            case 1:
                prix += 10;
                break;
            case 2:
                prix += 12;
                break;
            case 3:
                prix += 16;
                break;
        }

        commande.setPrix(prix);


        tmp += "Prix : " + prix;

        details.setText(tmp);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapV);
        mapFragment.getMapAsync(this);



        profile = Profile.getCurrentProfile();

        Button finishbt = (Button) findViewById(R.id.finishbt);
        finishbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                ringProgressDialog = ProgressDialog.show(that, "Saving you command ...", "...", true);

                RequestQueue queue = Volley.newRequestQueue(that);
                String url ="https://pizzadelivdemo.herokuapp.com/add.php";

                StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>()
                        {
                            @Override
                            public void onResponse(String response) {
                                // response
                                ringProgressDialog.dismiss();
                                Intent intent = new Intent(FinishActivity.this,CommandesActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(intent);
                                Log.d("Response", response);
                                finish();
                            }
                        },
                        new Response.ErrorListener()
                        {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                // error
                                Log.d("Error.Response", error.toString());
                            }
                        }
                ) {
                    @Override
                    protected Map<String, String> getParams()
                    {
                        Map<String, String>  params = new HashMap<String, String>();
                        params.put("userid", profile.getId());
                        params.put("username", profile.getName());
                        params.put("size", Integer.toString(commande.getSize()));
                        params.put("lat", Double.toString(commande.getLatitude()));
                        params.put("lng", Double.toString(commande.getLongitude()));
                        params.put("ing1", Integer.toString(commande.getIngridents().get(1)));
                        params.put("ing2", Integer.toString(commande.getIngridents().get(2)));
                        params.put("ing3", Integer.toString(commande.getIngridents().get(3)));
                        params.put("ing4", Integer.toString(commande.getIngridents().get(4)));
                        params.put("ing5", Integer.toString(commande.getIngridents().get(5)));
                        params.put("ing6", Integer.toString(commande.getIngridents().get(6)));
                        params.put("ing7", Integer.toString(commande.getIngridents().get(7)));
                        params.put("ing8", Integer.toString(commande.getIngridents().get(8)));
                        params.put("ing9", Integer.toString(commande.getIngridents().get(9)));
                        params.put("prix", Float.toString(commande.getPrix()));

                        return params;
                    }
                };
                queue.add(postRequest);

            }
        });



    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Add a marker in Sydney, Australia,
        // and move the map's camera to the same location.
        LatLng sydney = new LatLng(commande.getLatitude(),commande.getLongitude());
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("You positon"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney,10));
    }


}
