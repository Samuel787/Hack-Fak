package orbital.gns.nustartup;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import orbital.gns.nustartup.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class StartUpInfo extends Fragment {


    public StartUpInfo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start_up_info, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle bundle = this.getArguments();
        if(bundle != null){
            String mName = bundle.getString("Name");
            String mDescription = bundle.getString("Description");
            String mSkills = bundle.getString("Skills");
            String mLocation = bundle.getString("Location");
            String mContact = bundle.getString("Contact");

            ((TextView)getActivity().findViewById(R.id.infoStartUpNameHolder)).setText(mName);
            ((TextView)getActivity().findViewById(R.id.infoStartUpIdeaHolder)).setText(mName);
            ((TextView)getActivity().findViewById(R.id.infoStartUpSkillsHolder)).setText(mName);
            ((TextView)getActivity().findViewById(R.id.infoStartUpFounderHolder)).setText(mName);
            ((TextView)getActivity().findViewById(R.id.infoStartUpLocationHolder)).setText(mName);


            Log.d("Samuel-Samuel", mName + " is retrieved");
        }


    }
}
