package kheder.com.pizza.fragments.commande;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

import belka.us.androidtoggleswitch.widgets.ToggleSwitch;
import kheder.com.pizza.R;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the

 * to handle interaction events.
 * Use the {@link Ingredients#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Ingredients extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View view;
    //private OnFragmentInteractionListener mListener;

    public Ingredients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Ingredients.
     */
    // TODO: Rename and change types and number of parameters
    public static Ingredients newInstance() {
        Ingredients fragment = new Ingredients();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ingredients, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    public HashMap<Integer,Integer> getIng(){


        HashMap<Integer,Integer> sets = new HashMap<Integer,Integer>();

        ToggleSwitch toggleSwitch1 = (ToggleSwitch)view.findViewById(R.id.ing1);
        sets.put(1,toggleSwitch1.getCheckedTogglePosition());


        ToggleSwitch toggleSwitch2 = (ToggleSwitch)view.findViewById(R.id.ing2);
        sets.put(2,toggleSwitch2.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch3 = (ToggleSwitch)view.findViewById(R.id.ing3);
        sets.put(3,toggleSwitch3.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch4 = (ToggleSwitch)view.findViewById(R.id.ing4);
        sets.put(4,toggleSwitch4.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch5 = (ToggleSwitch)view.findViewById(R.id.ing5);
        sets.put(5,toggleSwitch5.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch6 = (ToggleSwitch)view.findViewById(R.id.ing6);
        sets.put(6,toggleSwitch6.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch7 = (ToggleSwitch)view.findViewById(R.id.ing7);
        sets.put(7,toggleSwitch7.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch8 = (ToggleSwitch)view.findViewById(R.id.ing8);
        sets.put(8,toggleSwitch8.getCheckedTogglePosition());

        ToggleSwitch toggleSwitch9 = (ToggleSwitch)view.findViewById(R.id.ing9);
        sets.put(9,toggleSwitch9.getCheckedTogglePosition());

        return sets;
    }
}
