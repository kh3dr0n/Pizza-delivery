package kheder.com.pizza.activites;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.facebook.CallbackManager;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.widget.LoginButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import kheder.com.pizza.Model.FlatCommande;
import kheder.com.pizza.R;
import kheder.com.pizza.adapter.CommandeArrayAdapter;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class CommandesActivity extends AppCompatActivity {


    //LoginButton loginButton;
    CallbackManager callbackManager;
    LoginManager loginManager;
    Profile profile;
    ArrayList<FlatCommande> commandes;
    CommandesActivity that = this;
    ListView listView;
    ProgressBar progressBar2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_commandes);

        listView = (ListView) findViewById(R.id.listviewCommande);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);

        //Profile profile = getIntent().getParcelableExtra("profile");
        profile = Profile.getCurrentProfile();

        TextView nom = (TextView) findViewById(R.id.nom);
        nom.setText("Hello, " + profile.getName());


        callbackManager = CallbackManager.Factory.create();

        loginManager  = LoginManager.getInstance();



        FloatingActionButton command = (FloatingActionButton) findViewById(R.id.floatingActionButton);

        command.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CommandesActivity.this,CommandeActivity.class);

                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        commandes = new ArrayList<FlatCommande>();
        RequestQueue queue = Volley.newRequestQueue(this);

        progressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        progressBar2.setVisibility(View.VISIBLE);


        String url ="https://pizzadelivdemo.herokuapp.com/?id=" + profile.getId();
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {
                            // Parsing json array response
                            // loop through each json object
                            Log.d("Response", Integer.toString(response.length()));
                            for (int i = 0; i < response.length(); i++) {

                                JSONObject comm = (JSONObject) response
                                        .get(i);

                                commandes.add(new FlatCommande(
                                        comm.getInt("size"),
                                        comm.getDouble("lat"),
                                        comm.getDouble("lng"),
                                        comm.getInt("ing1"),
                                        comm.getInt("ing2"),
                                        comm.getInt("ing3"),
                                        comm.getInt("ing4"),
                                        comm.getInt("ing5"),
                                        comm.getInt("ing6"),
                                        comm.getInt("ing7"),
                                        comm.getInt("ing8"),
                                        comm.getInt("ing8"),
                                        comm.getString("date"),
                                        comm.getDouble("prix")
                                ));
                                ArrayAdapter<FlatCommande> adapter = new CommandeArrayAdapter(that, 0, commandes);
                                listView.setAdapter(adapter);
                                progressBar2.setVisibility(View.GONE);
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                            Toast.makeText(getApplicationContext(),
                                    "Error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(),
                        error.getMessage(), Toast.LENGTH_SHORT).show();


            }
        });

        queue.add(req);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_logout:

                loginManager.logOut();
                Intent intent = new Intent(CommandesActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();

                return true;


            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }
}
