package com.sree.myappfeb.integration;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.request.RequestOptions;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;
import com.sree.myappfeb.R;
import org.json.JSONObject;
import java.util.Arrays;

public class FacebookIntegration extends AppCompatActivity {

    private LoginButton loginButton;
    private TextView txtName,txtEmail;
    private ProfilePictureView profile_pic;

    private CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook_integration);
        txtEmail=(TextView)findViewById(R.id.profile_email);
        txtName=(TextView)findViewById(R.id.profile_name);
        profile_pic=(ProfilePictureView) findViewById(R.id.profile_pic);
        loginButton =findViewById(R.id.login_button);

        callbackManager=CallbackManager.Factory.create();

        loginButton.setReadPermissions(Arrays.asList("email","public_profile"));

        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException error) {

            }

        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode, resultCode, data);
    }
    AccessTokenTracker tokenTracker = new AccessTokenTracker() {
        @Override
        protected void onCurrentAccessTokenChanged(AccessToken oldAccessToken, AccessToken currentAccessToken) {
            if (currentAccessToken==null){
                txtName.setText("");
                txtEmail.setText("");
                profile_pic.setProfileId(null);
                Toast.makeText(getApplicationContext(),"User is loged out",Toast.LENGTH_LONG).show();
            }else {
                loadProfile(currentAccessToken);
            }
        }
    };
    private  void loadProfile(AccessToken accessToken){
        GraphRequest request= GraphRequest.newMeRequest(accessToken, new GraphRequest.GraphJSONObjectCallback() {
            @Override
            public void onCompleted(JSONObject object, GraphResponse response) {
                try {
                    String first_name =object.getString("first_name");
                    String last_name = object.getString("last_name");
                    String email = object.getString("email");
                    String id = object.getString("id");


                    txtEmail.setText(email);
                    txtName.setText(first_name+" "+last_name);
                    profile_pic.setProfileId(id);

                    RequestOptions requestOptions = new RequestOptions();
                    requestOptions.dontAnimate();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        Bundle parameters = new Bundle();
        parameters.putString("fields","first_name,last_name,email,id");
        request.setParameters(parameters);
        request.executeAsync();
    }

}