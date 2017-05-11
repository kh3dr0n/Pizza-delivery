package kheder.com.pizza.fragments.commande;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.schibstedspain.leku.LocationPickerActivity;

import kheder.com.pizza.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class PicklocationFragment extends Fragment {


    final PicklocationFragment that = this;
    public PicklocationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picklocation, container, false);



        Button bt = (Button) view.findViewById(R.id.picklocationbt);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(that.getActivity(), LocationPickerActivity.class);
                that.getActivity().startActivityForResult(i, 1);
            }
        });

        return view;
    }

    public static PicklocationFragment newInstance() {
        PicklocationFragment fragment = new PicklocationFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

}
