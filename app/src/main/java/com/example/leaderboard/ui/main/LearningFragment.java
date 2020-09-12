package com.example.leaderboard.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.leaderboard.R;
import com.example.leaderboard.Util.StudentAdapter;
import com.example.leaderboard.model.StudentHour;
import com.example.leaderboard.services.ServiceBuilder;
import com.example.leaderboard.services.StudentHourService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LearningFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LearningFragment extends Fragment {

    private RecyclerView mRecyclerNote;

    StudentHourService studentHour;
    Call<List<StudentHour>> hoursRequest;
  //  TextView responseText;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   // private List<StudentHour> studentlist;
    private StudentAdapter mRecyclerAdapter;
    private List<StudentHour> mStudentlist;
    //  private RecyclerView mRecyclerNote;

    public LearningFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LearningFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LearningFragment newInstance(String param1, String param2) {
        LearningFragment fragment = new LearningFragment();
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

       studentHour = ServiceBuilder.builderService(StudentHourService.class);
        hoursRequest = studentHour.getStudentHours();

        hoursRequest.enqueue(new Callback<List<StudentHour>>() {
            @Override
            public void onResponse(Call<List<StudentHour>> call, Response<List<StudentHour>> response) {
                ///recyclerview area
              //  mRecyclerNote.setAdapter(new StudentAdapter(getContext(), (Call<List<StudentHour>>) response.body()));
                mStudentlist = response.body();
             // Log.d("TAG","Response = "+response.body());

               // studentlist = response.body();
               // Log.d("TAG","Response = "+studentlist);
                mRecyclerAdapter = new StudentAdapter(getContext(), mStudentlist);
                mRecyclerNote.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerNote.setAdapter(mRecyclerAdapter);



                ///////////////


             /*   // recyclerAdapter = new StudentIQAdapter(getContext(), studentlist);
                String displayResponse = "";
                for (StudentHour student : studentlist) {
                   displayResponse += student.name+ " " + student.hours + " " + student.country + " " + student.badgeUrl + "\n";
                }

                responseText.setText(displayResponse);*/



            }

            @Override
            public void onFailure(Call<List<StudentHour>> call, Throwable t) {
                Toast.makeText(getContext(), "Failed to retrieve ideas.", Toast.LENGTH_SHORT).show();


            }
        });

       // final RecyclerView recyclerNote = (RecyclerView)findViewById(R.id.list_student_hours);
        //final LinearLayoutManager hourLayoutManager = new LinearLayoutManager(this);
        //recyclearnote.setLayoutManager(hourLayoutManager);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_learning, container, false);
        View rootView = inflater.inflate(R.layout.fragment_learning, container, false);


        mRecyclerNote = (RecyclerView) rootView.findViewById(R.id.list_student_hour);


        ///Adapter
      //  StudentAdapter recyclerAdapter = new StudentAdapter(getContext(), studentlist);


//        mRecyclerNote.setLayoutManager(new LinearLayoutManager(getActivity()));
//        mRecyclerNote.setAdapter(mRecyclerAdapter);
//        final LinearLayoutManager hourLayoutManager = new LinearLayoutManager(getActivity());
//        mRecyclerNote.setLayoutManager(hourLayoutManager);
       // responseText = (TextView) rootView.findViewById(R.id.response_text_2);

        return rootView;

    }
}