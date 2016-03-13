package innoviz.ieee.niec.com.innoviz16.Frags;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

import innoviz.ieee.niec.com.innoviz16.R;


public class SignInfragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {
    private String TAG = "SignInActivity";

    public static int RC_SIGN_IN = 9001;
    SignInButton signInButton;
    public static View v;
    private GoogleApiClient mGoogleApiClient;
    private ProgressDialog mProgressDialog;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.fragment_sign_infragment, container, false);
     /*  SignInButton b=(SignInButton)root.findViewById(R.id.cheapGoogle);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), GoogleLogin.class);
                startActivity(i);

            }
        });*/
        v.findViewById(R.id.cheapGoogle).setOnClickListener(this);
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestId().build();
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity()).enableAutoManage(getActivity(), this).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        SignInButton signInButton = (SignInButton) v.findViewById(R.id.cheapGoogle);
        signInButton.setSize(SignInButton.SIZE_STANDARD);
        signInButton.setScopes(gso.getScopeArray());

        return v;
    }
    @Override
        public void onStart() {
               super.onStart();
                OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
                if (opr.isDone()) {
                       Log.d(TAG, "Got cached sign-in");
                        GoogleSignInResult result = opr.get();
                        handleSignInResult(result);

                            } else {
                        showProgressDialog();
                       opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
                                @Override
                               public void onResult(GoogleSignInResult googleSignInResult) {
                                        hideProgressDialog();
                                        handleSignInResult(googleSignInResult);
                                    }
                            });

                           }
           }
    private void hideProgressDialog() {
              if(mProgressDialog!=null&&mProgressDialog.isShowing()){
                        mProgressDialog.hide();
                    }
            }

    public void handleSignInResult(GoogleSignInResult result) {
                Log.d(TAG, "handleSignInResult:" + result.isSuccess());
                try {
                        if (result.isSuccess()) {
                                GoogleSignInAccount acct = result.getSignInAccount();
                            TextView t=(TextView)v.findViewById(R.id.loggedin);

                            t.setText(getString(R.string.signed_in_fmt,acct.getDisplayName()));
                                updateUI(true);
                              /*  Intent intent= new Intent(this.getContext(),HomepageActivity.class);
                                startActivity(intent);*/
                            } else {
                                Toast.makeText(this.getContext(),"Error Occured", Toast.LENGTH_SHORT).show();
                                updateUI(false);
                            }
                    } catch (NullPointerException n) {
                        Log.e("Null POINTER", "NULL");
                    }


                            }
    private void updateUI(boolean signedIn) {
                if (signedIn) {
                        v.findViewById(R.id.cheapGoogle).setVisibility(View.INVISIBLE);
                        Toast.makeText(getContext(), "Signed In", Toast.LENGTH_LONG).show();


                    } else {
                        Toast.makeText(getContext(), "Signed Out", Toast.LENGTH_SHORT).show();
                        v.findViewById(R.id.cheapGoogle).setVisibility(View.VISIBLE);
                    }

                    }

                public void showProgressDialog() {

                       if(mProgressDialog==null){
                       mProgressDialog= new ProgressDialog(this.getActivity());
                       mProgressDialog.setMessage("Loading");
                       mProgressDialog.setIndeterminate(true);
                   }
            }
    @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
                Log.d(TAG, "onConnectionFailed:" + connectionResult);
            }

                @Override
        public void onClick(View v) {

                        switch (v.getId()) {
                        case R.id.cheapGoogle:
                                signIn();
                                break;
                    }

                    }

                private void signIn() {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }




}