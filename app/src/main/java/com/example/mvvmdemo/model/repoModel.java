package com.example.mvvmdemo.model;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

import static android.content.ContentValues.TAG;

public class repoModel {


    public static repoModel.MyCallback MyCallback;

    public interface MyCallback {
        public boolean onSuccess();
        public void onFailure(Exception e);
    }
    FirebaseAuth mAuth =FirebaseAuth.getInstance();


    public boolean firebaseLogin(String email, final String password){
        Log.d(TAG, "firebase Login: Success" + email );
        final boolean status[]={false};
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener((Executor) this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                       status[0]=true;
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                status[0]=false;

            }

        });

        return status[0];
    }
}
