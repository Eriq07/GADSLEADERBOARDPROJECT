package com.example.leaderboard.Util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.leaderboard.R;
import com.example.leaderboard.model.StudentHour;
import com.example.leaderboard.model.StudentSkill;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StudentIQAdapter extends RecyclerView.Adapter<StudentIQAdapter.ViewHolder> {

    private Context mContext;
    private  List<StudentSkill> mBody;

    private final LayoutInflater mLayoutInflater;

    public StudentIQAdapter(Context context, List<StudentSkill> body) {
        this.mContext = context;
        this.mBody = body;

        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.item_note_list, parent, false);


        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        StudentSkill student =  mBody.get(position);
        Picasso.get().load(student.badgeUrl).into(holder.mImageView);
        holder.mTextName.setText(student.name);
        holder.mTextScore.setText(student.score+ " "+"Skill IQ Score"+" " + student.country + "\n");
        //holder.mTextScore.setText(student.score);

    }

    @Override
    public int getItemCount() {
        return mBody.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final TextView mTextScore;
        public final TextView mTextName;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image_view);
            mTextName = (TextView) itemView.findViewById(R.id.student_name);
            mTextScore = (TextView) itemView.findViewById(R.id.student_score);


        }
    }
}
