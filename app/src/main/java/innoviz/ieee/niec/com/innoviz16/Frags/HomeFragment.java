package innoviz.ieee.niec.com.innoviz16.Frags;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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
    int[] img_res = {R.drawable.innovizh11, R.drawable.innovizh2, R.drawable.innovizh3,
            R.drawable.innovizh4, R.drawable.innovizh5, R.drawable.innovizh6,
            R.drawable.innovizh7,R.drawable.innovizh1};
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
        adapter = new RecyclerAdapter(arrayList,this.getContext());

        // recyclerView.setHasFixedSize(true);


        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        // recyclerView.setElevation((float) 10.00);
        recyclerView.setAdapter(adapter);


        return root;
    }

}
