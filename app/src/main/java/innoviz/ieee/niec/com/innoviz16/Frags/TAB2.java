package innoviz.ieee.niec.com.innoviz16.Frags;


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
public class TAB2 extends Fragment {
    String[] E_name, E_desc;
    ArrayList<DataProvider> arrayList;// = new ArrayList<DataProvider>();

    int[] img_res = {R.drawable.innovizl1, R.drawable.innovizl2, R.drawable.innovizl3,
            R.drawable.innovizl4, R.drawable.innovizl5,
            R.drawable.innovizl7, R.drawable.innovizl8};
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    public TAB2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView2);
        layoutManager = new LinearLayoutManager(getActivity());

        E_name = getResources().getStringArray(R.array.planets_array3);
        E_desc = getResources().getStringArray(R.array.planets_array3);
        int i = 0;
        arrayList = new ArrayList<>();
        for (String name : E_name) {
            DataProvider dataProvider = new DataProvider(img_res[i], name, E_desc[i]);

            arrayList.add(dataProvider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList, this.getContext());

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return v;
    }

}
