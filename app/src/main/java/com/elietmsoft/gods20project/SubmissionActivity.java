package com.elietmsoft.gods20project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.elietmsoft.gods20project.interfaces.RetrofitClientEnvoi;
import com.jaeger.library.StatusBarUtil;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubmissionActivity extends AppCompatActivity {

    Button btnSubmit;
    LinearLayout layoutSubmit,layoutDecorBottom,layoutMain;
    EditText editFirstName, editLastName,editEmail,editLinkGithub;
    Toast toast;
    Dialog dialog;
    ImageView imgCancel,imgBack;
    Button btnYes;
    View viewAlert;
    View viewToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);
        customStatusBar();
        init();
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backOfMainActivity();
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation();
            }
        });
    }

    void init(){
        layoutSubmit = (LinearLayout)findViewById(R.id.layout_submit);
        layoutDecorBottom = (LinearLayout)findViewById(R.id.decor_bottom);
        layoutMain = (LinearLayout)findViewById(R.id.layout_main);

        btnSubmit = (Button)layoutMain.findViewById(R.id.btnSubmit);
        editFirstName = (EditText)findViewById(R.id.txtFirstName);
        editLastName = (EditText)findViewById(R.id.txtLastName);
        editEmail = (EditText)findViewById(R.id.txtEmail);
        editLinkGithub = (EditText)findViewById(R.id.txtLink);
        dialog = new Dialog(SubmissionActivity.this);
        viewAlert = getLayoutInflater().inflate(R.layout.alert_custom,(LinearLayout)findViewById(R.id.alertcustom));
        viewToolbar = findViewById(R.id.toolbar_submit);
        imgBack = (ImageView)viewToolbar.findViewById(R.id.imgBack);
    }

    void customStatusBar(){
        StatusBarUtil.setTransparent(SubmissionActivity.this);
    }
    void backOfMainActivity(){
        Intent goMainActivity = new Intent(SubmissionActivity.this,MainActivity.class);
        startActivity(goMainActivity);
        SubmissionActivity.this.finish();
    }
    boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }
    boolean isValid(String urlString) {
        try {
            URL url = new URL(urlString);
            return URLUtil.isValidUrl(url.toString()) && Patterns.WEB_URL.matcher(url.toString()).matches();
        } catch (MalformedURLException e) {

        }
        return false;
    }

    boolean verifyValEmpty(String first, String last, String email, String link)
    {
        if(!TextUtils.isEmpty(first) && !TextUtils.isEmpty(last) && !TextUtils.isEmpty(email) && !TextUtils.isEmpty(link))
            return true;
        else
            return false;
    }

    void questionBackSend(String email,String firstName,String lastName,String link)
    {
        Call<ResponseBody> call = RetrofitClientEnvoi.
                getInstance().
                getApi().
                envoiProject(email,firstName,lastName,link);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    if(response.isSuccessful()) {
                        String s = response.body().string();
                        String viewss = "toast_custom_successfull";
                        optionsMessage(viewss);
                    }
                    else{
                        String viewss = "toast_custom_error";
                        optionsMessage(viewss);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                String viewss = "toast_custom_error";
                optionsMessage(viewss);
            }
        });
    }

    void optionsMessage(String viewss)
    {
        if(viewss.equals("toast_custom_successfull"))
        {
            layoutSubmit.setVisibility(View.INVISIBLE);
            toast = Toast.makeText(SubmissionActivity.this,"",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            View view = getLayoutInflater().inflate(R.layout.toast_custom_successfull,(ViewGroup)findViewById(R.id.toastcustom));
            toast.setView(view);
            toast.show();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    layoutSubmit.setVisibility(View.VISIBLE);
                }
            }, 3000L);

        }
        else
        {
            layoutSubmit.setVisibility(View.INVISIBLE);
            toast = Toast.makeText(SubmissionActivity.this,"",Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER,0,0);
            View view = getLayoutInflater().inflate(R.layout.toast_custom_error,(ViewGroup)findViewById(R.id.toastcustom));
            toast.setView(view);
            toast.show();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable()
            {
                public void run()
                {
                    layoutSubmit.setVisibility(View.VISIBLE);
                }
            }, 3000L);

        }
    }

    void btnOptionsWithQuestion(final String email, final String firstName, final String lastName, final String link)
    {
        optionsMessageDialog();

        imgCancel = (ImageView)viewAlert.findViewById(R.id.imgCancel);
        btnYes = (Button)viewAlert.findViewById(R.id.btnYes);
        imgCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
                layoutSubmit.setVisibility(View.VISIBLE);
                layoutMain.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.VISIBLE);
                layoutDecorBottom.setVisibility(View.VISIBLE);
            }
        });
        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               questionBackSend(email,firstName,lastName,link);
            }
        });
    }

    void optionsMessageDialog()
    {
        dialog.setContentView(viewAlert);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //
        View view = getLayoutInflater().inflate(R.layout.alert_custom,(ViewGroup)findViewById(R.id.alertcustom));
        toast = Toast.makeText(SubmissionActivity.this,"",Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(view);
        toast.show();
        layoutSubmit.setVisibility(View.INVISIBLE);
        btnSubmit.setVisibility(View.INVISIBLE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable()
        {
            public void run()
            {
                dialog.show();
            }
        }, 3000L);
        //
    }

    void validation(){
        String firstName = editFirstName.getText().toString().trim();
        String lastName = editLastName.getText().toString().trim();
        String email = editEmail.getText().toString().trim();
        String link = editLinkGithub.getText().toString().trim();
        boolean test = verifyValEmpty(firstName,lastName,email,link);
        if(test){
            if(isValidEmail(email)){
                if(isValid(link)){
                   btnOptionsWithQuestion(email,firstName,lastName,link);
                }
                else{
                    editLinkGithub.setError("Url invalide!!");
                }
            }
            else{
                editEmail.setError("Email invalide!!");
            }
        }
        else {

        }
    }
}