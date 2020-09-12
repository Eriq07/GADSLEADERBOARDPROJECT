package com.example.leaderboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.leaderboard.model.StudentSkill;
import com.example.leaderboard.services.ServiceBuilder;
import com.example.leaderboard.services.StudentSkillService;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {
    private static final String TAG = "SubmissionActivity";

    Dialog confirmSubmission;
    Button yesConfirmation;
    ImageView cancleConfirmation;

    private EditText mFirstName, mLastName, mEmail, mGitLink;
    private Button mSubmitButton;
    private StudentSkillService mSubmitService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);


        mFirstName = (EditText)findViewById(R.id.first_name);
        mLastName = (EditText)findViewById(R.id.last_name);
        mEmail = (EditText)findViewById(R.id.email_address);
        mGitLink =  (EditText)findViewById(R.id.git_link);
        mSubmitButton =(Button) findViewById(R.id.submit_button);

        confirmSubmission = new Dialog(this);
       // yesConfirmation = (Button)findViewById(R.id.confirmation_button);
       // cancleConfirmation = (ImageView)findViewById(R.id.cancle_image);






        ///////Submission Popup
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showConfirmationPopup();
//               onSubmitButtonPressed();
            }
        });

    }

    private void showConfirmationPopup() {
        confirmSubmission.setContentView(R.layout.confirm_popup_success);
        cancleConfirmation = (ImageView) confirmSubmission.findViewById(R.id.cancle_image);
        yesConfirmation = (Button)confirmSubmission.findViewById(R.id.confirmation_button);

        //////Submission Cancle
        cancleConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                confirmSubmission.dismiss();
            }
        });
        confirmSubmission.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        confirmSubmission.show();
        ///////Submission okay
        yesConfirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSubmitButtonPressed();

            }
        });
    }



    ///////////////

    private void onSubmitButtonPressed() {
        Log.d(TAG, "onClick: attempting to submit" );
        ///Check for null valued EditText fields
        if(!isEmpty(mFirstName.getText().toString())
                && !isEmpty(mLastName.getText().toString())
                && !isEmpty(mEmail.getText().toString())
                && !isEmpty(mGitLink.getText().toString())){

            executeSendSubmission(mEmail.getText().toString(),
                    mFirstName.getText().toString(),
                    mLastName.getText().toString(),
                    mGitLink.getText().toString());
            //    Call<Void>projectSubmission(@Field("entry.1824927963")emailAddress:,
//                            @Field("entry.1877115667")firstName:String,
//                            @Field("entry.2006916086")lastName:String,
//                            @Field("entry.284483984")projectLink:String)

            mSubmitService = ServiceBuilder.builderService(StudentSkillService.class);
            /*Call<Void> submitRequest =  mSubmitService.projectSubmission(
                    mEmail.getText().toString(),
                    mFirstName.getText().toString(),
                    mLastName.getText().toString(),
                    mGitLink.getText().toString()
            );
            //      Toast.makeText(this, "Success on submission", Toast.LENGTH_SHORT).show();
            submitRequest.enqueue(new Callback<Void>() {
                @Override
                public void onResponse(Call<Void> call, Response<Void> response) {
//                    Intent intent = new Intent(SubmissionActivity.this, MainActivity.class);
//                    startActivity(intent);
                    showSubmissionSuccessPopup();

                }

                @Override
                public void onFailure(Call<Void> call, Throwable t) {

                   // Toast.makeText(SubmissionActivity.this, "Failed to submit", Toast.LENGTH_SHORT).show();
                    showSubmissionFailedPopup();

                }
            });*/


        }else{
            Toast.makeText(SubmissionActivity.this, "Fill all the Fields", Toast.LENGTH_SHORT).show();
        }
    }

    private void executeSendSubmission(String email, String firstName, String lastName, String gitLink) {
        Call<ResponseBody> call = mSubmitService.projectSubmission(
                email,
                firstName,
                lastName,
                gitLink
        );
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                showSubmissionSuccessPopup();

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                showSubmissionFailedPopup();

            }
        });

    }

    private void showSubmissionFailedPopup() {

        ConstraintLayout failedSubmission = (ConstraintLayout)findViewById(R.id.submission_failed_popup);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(failedSubmission);
        toast.show();

    }

    private void showSubmissionSuccessPopup() {
       /* successfulSubmission = new Dialog(this);
        confirmSubmission.setContentView(R.layout.submission_success_popup);*/
        ConstraintLayout successfulSubmission = (ConstraintLayout)findViewById(R.id.submission_success_popup);
        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(successfulSubmission);
        toast.show();


    }

    private boolean isEmpty(String string){return string.equals("");}


}