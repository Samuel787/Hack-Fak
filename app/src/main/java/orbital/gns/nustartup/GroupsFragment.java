package orbital.gns.nustartup;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

public class GroupsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public GroupsFragment() {
        // Required empty public constructor
    }

    public static GroupsFragment newInstance(String param1, String param2) {
        GroupsFragment fragment = new GroupsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sms, container, false);
    }


    ArrayList<DataModel> dataModels;
    ListView listView;
    SearchView searchView;
    private static CustomAdapter adapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView = getView().findViewById(R.id.list);
        searchView = getView().findViewById(R.id.searchView);
        dataModels = new ArrayList<>();

        dataModels.add(new DataModel("NUSCats", "Passionate about cats", "C++", "Abhishake", "6969696969", "Mustafa"));
        dataModels.add(new DataModel("IceCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Little India"));
        dataModels.add(new DataModel("DuCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Queenstown"));
        dataModels.add(new DataModel("RishiCats", "Passionate about cats","C++", "Abhishake", "6969696969", "Chinatown"));
        dataModels.add(new DataModel("AdamCats", "Passionate about cats","C++", "Abhishake", "6969696969", "Changi"));
        dataModels.add(new DataModel("AbhiCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Chinese Garden"));
        dataModels.add(new DataModel("MuCats", "Passionate about cats","C++", "Abhishake", "6969696969", "NUS"));
        dataModels.add(new DataModel("PiCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Technopark"));
        dataModels.add(new DataModel("DiCats", "Passionate about cats","C++", "Abhishake", "6969696969", "Alexandra Park"));
        dataModels.add(new DataModel("JiCats", "Passionate about cats", "C++", "Abhishake", "6969696969", "I3"));
        dataModels.add(new DataModel("LiCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Utown"));
        dataModels.add(new DataModel("NuCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Lemon Engineering"));
        dataModels.add(new DataModel("MeowCats", "Passionate about cats", "C++","Abhishake", "6969696969", "Intrachat"));

        adapter= new CustomAdapter(dataModels, getContext());

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                transaction.replace(R.id.container, new StartUpInfo());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                ArrayList<DataModel> searchedDataModels = new ArrayList<>();

                for (int i = 0; i < adapter.getCount(); i++) {
                    if (adapter.getItem(i).name.toLowerCase().contains(s.toLowerCase())) {
                        searchedDataModels.add(adapter.getItem(i));
                    }
                }

                for (int i = 0; i < searchedDataModels.size(); i++) {
                    System.out.println(searchedDataModels.get(i).name);
                }

                CustomAdapter tempAdapter = new CustomAdapter(searchedDataModels, getContext());
                listView.setAdapter(tempAdapter);

                return false;
            }
        });

    }


}
