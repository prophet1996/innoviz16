package innoviz.ieee.niec.com.innoviz16.Frags;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
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

    int[] img_res = {R.drawable.innoviz10, R.drawable.innoviz11, R.drawable.innoviz12,
            R.drawable.innoviz13, R.drawable.innoviz14, R.drawable.innoviz15,
            R.drawable.innoviz16, R.drawable.innoviz18, R.drawable.innoviz19, R.drawable.innoviz20,
            R.drawable.innoviz21, R.drawable.innoviz22, R.drawable.innoviz23, R.drawable.innoviz24,
            R.drawable.innoviz25, R.drawable.innoviz26, R.drawable.innoviz27, R.drawable.innoviz28,
            R.drawable.innoviz29};
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
       layoutManager= new GridLayoutManager(getActivity(),2);

        E_name = getResources().getStringArray(R.array.planets_array);
        E_desc = getResources().getStringArray(R.array.planets_array);
        int i = 0;
        arrayList = new ArrayList<>();
        for (String name : E_name) {
            DataProvider dataProvider = new DataProvider(img_res[i], name, E_desc[i]);

            arrayList.add(dataProvider);
            i++;
        }
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return v;
    }

}
