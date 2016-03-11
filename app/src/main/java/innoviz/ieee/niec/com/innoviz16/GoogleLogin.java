package innoviz.ieee.niec.com.innoviz16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;

public class GoogleLogin extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {
    /*********************GOOGLE************************/
    SignInButton signInButton;
    private GoogleApiClient mGoogleApiClient;
    TextView mStatusTextview;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_login);
        mStatusTextview=(TextView)findViewById(R.id.textView2);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this/**/, this/*on connctionfailed listener*/)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();
        signInButton = (SignInButton) findViewById(R.id.signInbutton);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());



    signInButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.signInbutton:
                    signIn();
                    break;
            }

        }

        private void signIn() {
            Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
            startActivityForResult(signInIntent, RC_SIGN_IN);
        }
    });
}
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            if (requestCode == RC_SIGN_IN) {

                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data); //google OAR
                Log.d("ashgjnf",""+result);
                handleSignInResult(result);
            }
        }
    }
    private void handleSignInResult(GoogleSignInResult result) {
        Log.d(TAG, "handleSignInResult:" + result.isSuccess());
        try{
            if (result.isSuccess()){
                GoogleSignInAccount acct=result.getSignInAccount();
                mStatusTextview.setText(getString(R.string.signed_in_fmt,acct.getDisplayName()));
                updateUI(true);
            }else {updateUI(false);}}
        catch (NullPointerException n)
        {Log.e("NULL POINTER","NULL");}

    }

    private void updateUI(boolean signedIn) {
        if (signedIn) {
            findViewById(R.id.signInbutton).setVisibility(View.GONE);
        } else {
            mStatusTextview.setText(R.string.signed_out);

            findViewById(R.id.signInbutton).setVisibility(View.VISIBLE);
            Intent i=new Intent(GoogleLogin.this,MainActivity.class);
            i.putExtra("Signed In","true");
            startActivity(i);
        }
    }


    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        Log.d("con","Connection failed");

    }
}
