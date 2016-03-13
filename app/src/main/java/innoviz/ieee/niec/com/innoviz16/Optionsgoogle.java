package innoviz.ieee.niec.com.innoviz16;

/**
 * Created by PROPHET on 11-03-2016.
 */
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;

public class Optionsgoogle extends FragmentActivity{


    private  GoogleLogin gl;
    //private loginfragment ln;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState==null)
        {
            gl= new GoogleLogin();
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, gl).commit();
        }
        else
        {
            gl= (GoogleLogin) getSupportFragmentManager().findFragmentById(android.R.id.content);
        }
    }



    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK) {
            if (requestCode == gl.RC_SIGN_IN) {
                GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
                gl.handleSignInResult(result);

            }
        }
    }


}




