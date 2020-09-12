package com.example.leaderboard.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leaderboard.R;
import com.example.leaderboard.Util.StudentIQAdapter;
import com.example.leaderboard.model.StudentSkill;
import com.example.leaderboard.services.ApiClient;
import com.example.leaderboard.services.ServiceBuilder;
import com.example.leaderboard.services.StudentHourService;
import com.example.leaderboard.services.StudentSkillService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SkillsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SkillsFragment extends Fragment {


    StudentSkillService studentSkill;
    Call<List<StudentSkill>> skillsRequest;
   // TextView responseText2;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerNote;
    private View mRootView;
    private StudentIQAdapter recyclerAdapter;
    private List<StudentSkill> studentlist;
    private LinearLayoutManager mLayoutManager;




    public SkillsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SkillsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SkillsFragment newInstance(String param1, String param2) {
        SkillsFragment fragment = new SkillsFragment();
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

        studentSkill = ServiceBuilder.builderService(StudentSkillService.class);
        skillsRequest = studentSkill.getStudentSkillIQ();

        skillsRequest.enqueue(new Callback<List<StudentSkill>>() {
            @Override
            public void onResponse(Call<List<StudentSkill>> call, Response<List<StudentSkill>> response) {

                studentlist = response.body();
              //  Log.d("TAG","Response = "+studentlist);

                recyclerAdapter = new StudentIQAdapter(getContext(), studentlist);
                mRecyclerNote.setLayoutManager(new LinearLayoutManager(getActivity()));
                mRecyclerNote.setAdapter(recyclerAdapter);

              /* // recyclerAdapter = new StudentIQAdapter(getContext(), studentlist);
                String displayResponse = "";
                for (StudentSkill student : studentlist) {
                    displayResponse += student.name+ " " + student.score + " " + student.country + " " + student.badgeUrl + "\n";
                }

                responseText2.setText(displayResponse);*/

            }

            @Override
            public void onFailure(Call<List<StudentSkill>> call, Throwable t) {

                Toast.makeText(getContext(), "Failed to retrieve ideas.", Toast.LENGTH_SHORT).show();

            }
        });




    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_skills, container, false);

        mRecyclerNote = (RecyclerView) mRootView.findViewById(R.id.list_student_hours_2);
       // mLayoutManager = new LinearLayoutManager(getActivity());
       // mRecyclerNote.setLayoutManager(mLayoutManager);
      //  recyclerAdapter = new StudentIQAdapter(getContext(), studentlist);
       // mRecyclerNote.setAdapter(recyclerAdapter);


      //  responseText = mRootView.findViewById(R.id.response_Text);
       // responseText2 = (TextView) mRootView.findViewById(R.id.response_text1);



        return mRootView;
    }
}