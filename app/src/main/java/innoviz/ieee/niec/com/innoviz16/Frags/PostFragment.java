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
public class PostFragment extends Fragment {
    String[] E_name, E_desc;
    ArrayList<DataProvider> arrayList;
    int[] img_res = { R.drawable.innovizp1, R.drawable.innovizp2, R.drawable.innovizp3,
            R.drawable.innovizp4, R.drawable.innovizp5, R.drawable.innovizp6,
            R.drawable.innovizp7, R.drawable.innovizp8, R.drawable.innovizp9, R.drawable.innovizp10,
            R.drawable.innovizp11, R.drawable.innovizp12, R.drawable.innovizp13, R.drawable.innovizp14,
            R.drawable.innovizp15, R.drawable.innovizp16};
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;


    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewpost);
        layoutManager = new LinearLayoutManager(getActivity());
        int i = 0;
        E_name = getResources().getStringArray(R.array.planets_array2);
        E_desc = getResources().getStringArray(R.array.planets_array2);
        arrayList = new ArrayList<>();
        for (String name : E_name) {
            DataProvider dataProvider = new DataProvider(img_res[i], name, E_desc[i]);

            arrayList.add(dataProvider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        return view;

    }


}
