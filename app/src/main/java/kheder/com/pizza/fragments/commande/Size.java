package kheder.com.pizza.fragments.commande;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import kheder.com.pizza.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Size.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Size#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Size extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ImageView pizza;
    private TextView name;
    private TextView desc;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private int progress;
    //private OnFragmentInteractionListener mListener;

    public Size() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment Size.
     */
    // TODO: Rename and change types and number of parameters
    public static Size newInstance() {
        Size fragment = new Size();
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


        View view = inflater.inflate(R.layout.fragment_size, container, false);



        pizza = (ImageView)view.findViewById(R.id.imageView2);
        name = (TextView)view.findViewById(R.id.textView);
        desc = (TextView)view.findViewById(R.id.textView2);

        SeekBar mSeekBar = (SeekBar)view.findViewById(R.id.seekBar2);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,boolean fromUser) {
                Size.this.progress = progress;
                switch (progress){
                    case 0:
                        name.setText("MEGA");
                        pizza.setPadding(convertDpToPx(50),convertDpToPx(50),convertDpToPx(50),convertDpToPx(50));
                        desc.setText("(1 pers.)");
                        break;
                    case 1:
                        name.setText("GIGA");
                        desc.setText("(2 pers.)");
                        pizza.setPadding(convertDpToPx(40),convertDpToPx(40),convertDpToPx(40),convertDpToPx(40));
                        break;
                    case 2:
                        name.setText("TERA");
                        desc.setText("(3 pers.)");
                        pizza.setPadding(convertDpToPx(30),convertDpToPx(30),convertDpToPx(30),convertDpToPx(30));
                        break;
                    case 3:
                        name.setText("PETA");
                        desc.setText("(4 pers.)");
                        pizza.setPadding(convertDpToPx(20),convertDpToPx(20),convertDpToPx(20),convertDpToPx(20));
                        break;
                }

            }
        });

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





    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }

    private int convertDpToPx(int dp){
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }

    public int getSizeValue(){
        return progress;
    }
}
