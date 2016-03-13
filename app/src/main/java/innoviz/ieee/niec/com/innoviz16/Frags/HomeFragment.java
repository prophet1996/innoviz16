package innoviz.ieee.niec.com.innoviz16.Frags;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import innoviz.ieee.niec.com.innoviz16.R;
import innoviz.ieee.niec.com.innoviz16.RecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String[] E_name, E_desc;
    int[] img_res = {R.drawable.innoviz10, R.drawable.innoviz11, R.drawable.innoviz12,
            R.drawable.innoviz13, R.drawable.innoviz14, R.drawable.innoviz15,
            R.drawable.innoviz16, R.drawable.innoviz18, R.drawable.innoviz19, R.drawable.innoviz20,
            R.drawable.innoviz21, R.drawable.innoviz22, R.drawable.innoviz23, R.drawable.innoviz24,
            R.drawable.innoviz25, R.drawable.innoviz26, R.drawable.innoviz27, R.drawable.innoviz28,
            R.drawable.innoviz29};
    ArrayList<DataProvider> arrayList;// = new ArrayList<DataProvider>();


    public HomeFragment() {
        // Required empty public constructor
    }


    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = (View) inflater.inflate(R.layout.fragment_home, container, false);

        arrayList = new ArrayList<>();
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        E_name = getResources().getStringArray(R.array.planets_array);
        E_desc = getResources().getStringArray(R.array.planets_array);
        int i = 0;
        for (String name : E_name) {
            DataProvider dataProvider = new DataProvider(img_res[i], name, E_desc[i]);
            arrayList.add(dataProvider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList);

        // recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        // recyclerView.setElevation((float) 10.00);
        recyclerView.setAdapter(adapter);


        return root;
    }

}
