package innoviz.ieee.niec.com.innoviz16.Frags;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.common.SignInButton;

import java.util.zip.Inflater;

import innoviz.ieee.niec.com.innoviz16.GoogleLogin;
import innoviz.ieee.niec.com.innoviz16.R;


public class SignInfragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, final Bundle savedInstanceState) {
        View root= inflater.inflate( R.layout.fragment_sign_infragment,container,false);
        SignInButton b=(SignInButton)root.findViewById(R.id.cheapGoogle);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), GoogleLogin.class);
                startActivity(i);

            }
        });
        return root;
    }
}