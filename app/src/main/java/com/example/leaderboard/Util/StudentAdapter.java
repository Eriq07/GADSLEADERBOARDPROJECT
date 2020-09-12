package com.example.leaderboard.Util;

import android.content.Context;
import android.net.Uri;
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

import retrofit2.Call;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private  Context mContext;
    private  List<StudentHour> mBody;

    private final LayoutInflater mLayoutInflater;

    public StudentAdapter(Context context, List<StudentHour> body) {
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
        StudentHour student =  mBody.get(position);
        //Picasso.with(mContext).load(student.badgeUrl).into(holder.mImageView);
        Picasso.get().load(student.badgeUrl).into(holder.mImageView);
       // holder.mImageView.setImageURI(Uri.parse(student.badgeUrl));
        holder.mTextName.setText(student.name);
        holder.mTextScore.setText(student.hours+ " "+"Learning hours"+" " + student.country + "\n");

//        holder.mTextName.setText(mBody.get(position).name);
//        holder.mTextName.setText(mBody.get(position).hours);
        /* String displayResponse = "";
        for (StudentHour student : studentlist) {
            displayResponse += student.name+ " " + student.hours + " " + student.country + " " + student.badgeUrl + "\n";
        }

        responseText.setText(displayResponse);*/


    }

    @Override
    public int getItemCount() {
        return mBody.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final ImageView mImageView;
        public final TextView mTextName;
        public final TextView mTextScore;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.image_view);
            mTextName = (TextView) itemView.findViewById(R.id.student_name);
            mTextScore = (TextView) itemView.findViewById(R.id.student_score);



        }
    }
}
