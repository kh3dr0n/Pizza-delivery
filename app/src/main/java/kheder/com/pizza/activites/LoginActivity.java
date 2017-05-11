package kheder.com.pizza.activites;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kheder.com.pizza.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class LoginActivity extends AppCompatActivity {
    /**
     * Whether or not the system UI should be auto-hidden after
     * {@link #AUTO_HIDE_DELAY_MILLIS} milliseconds.
     */
    private static final boolean AUTO_HIDE = true;

    /**
     * If {@link #AUTO_HIDE} is set, the number of milliseconds to wait after
     * user interaction before hiding the system UI.
     */
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;

    /**
     * Some older devices needs a small delay between UI widget updates
     * and a change of the status and navigation bar.
     */


    LoginButton loginButton;
    CallbackManager callbackManager;

    private static final int UI_ANIMATION_DELAY = 300;
    private final Handler mHideHandler = new Handler();
    private View mContentView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);




        try{
            PackageInfo info = getPackageManager().getPackageInfo(
                    "kheder.com.pizza", PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash:",Base64.encodeToString(md.digest(), Base64.DEFAULT));

            }
        } catch (PackageManager.NameNotFoundException e) {

        } catch (NoSuchAlgorithmException e) {

        }


        setContentView(R.layout.activity_login);



        callbackManager = CallbackManager.Factory.create();

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG);

                        Profile profile = Profile.getCurrentProfile();
                        LoginManager loginManager = LoginManager.getInstance();
                        Log.d("pizza", "" +profile.getId());

                        Intent intent = new Intent(LoginActivity.this, CommandesActivity.class);

                        intent.putExtra("profile",profile);

                        startActivity(intent);
                        finish();

                    }

                    @Override
                    public void onCancel() {

                        Toast.makeText(getApplicationContext(),"Erreur lors connection",Toast.LENGTH_LONG);
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Toast.makeText(getApplicationContext(),"Erreur lors connection",Toast.LENGTH_LONG);
                    }
                });


        if(isLoggedIn()){
            Profile profile = Profile.getCurrentProfile();
            Intent intent = new Intent(this,CommandesActivity.class);
            intent.putExtra("profile",profile);
            startActivity(intent);
            finish();
        }
    }

//
//    public View onCreateView(
//            LayoutInflater inflater,
//            ViewGroup container,
//            Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.activity_login, container, false);
//
//        loginButton = (LoginButton) view.findViewById(R.id.login_button);
//        loginButton.setReadPermissions("email");
//
//
//        // Callback registration
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//
//                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG);
//            }
//
//            @Override
//            public void onCancel() {
//                Toast.makeText(getApplicationContext(),"Cancel",Toast.LENGTH_LONG);
//            }
//
//            @Override
//            public void onError(FacebookException exception) {
//                Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG);
//            }
//        });
//        return view;
//    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public boolean isLoggedIn() {
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
        return accessToken != null;
    }


}
