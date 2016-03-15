package innoviz.ieee.niec.com.innoviz16.Frags;


import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;

import innoviz.ieee.niec.com.innoviz16.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TAB3 extends DialogFragment {
    Button b1,b2,b3,b4;
    LayoutInflater li;
    Intent b;


    public TAB3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v=inflater.inflate(R.layout.fragment_tab3, container, false);
        b1=(Button)v.findViewById(R.id.face);

        return v;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog, null);
        builder.setView(view);

        return super.onCreateDialog(savedInstanceState);
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        b1=(Button)getActivity().findViewById(R.id.face);
        b2=(Button)getActivity().findViewById(R.id.twit);
        b3=(Button)getActivity().findViewById(R.id.insta);
        b4=(Button)getActivity().findViewById(R.id.info);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/InnovizNIEC/?fref=ts"));
                startActivity(b);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Intent(Intent.ACTION_VIEW,Uri.parse("https://twitter.com/innoviz_niec"));
                startActivity(b);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                b=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/innoviz.niec/"));
                startActivity(b);
            }
        });  b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {Dialog d= new Dialog(getActivity());
                    d.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
                    d.setContentView(getActivity().getLayoutInflater().inflate(R.layout.dialog, null));
                    d.show();


                }
            }
        });
super.onActivityCreated(savedInstanceState);

    }
    }
