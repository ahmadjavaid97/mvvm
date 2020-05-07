package com.example.mvvmdemo.viewModels;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;

import com.example.mvvmdemo.model.repoModel;
import com.example.mvvmdemo.model.user;

//import androidx.databinding.library.baseAdapters.BR;

//import com.android.databinding.library.baseAdapters.BR;

public class LoginViewModel extends BaseObservable {
    private user user;
    repoModel mymodel = new repoModel();


    private String successMessage = "Login was successful";
    private String errorMessage = "Email or Password not valid";

    @Bindable
    private String toastMessage = null;


    public String getToastMessage() {
        return toastMessage;
    }


    private void setToastMessage(String toastMessage) {

        this.toastMessage = toastMessage;
        notifyPropertyChanged(BR.toastMessage);
    }


    public void setUserEmail(String email) {
        user.setEmail(email);
        notifyPropertyChanged(BR.userEmail);
    }

    @Bindable
    public String getUserEmail() {
        return user.getEmail();
    }

    @Bindable
    public String getUserPassword() {
        return user.getPassword();
    }

    public void setUserPassword(String password) {
        user.setPassword(password);
        notifyPropertyChanged(BR.userPassword);
    }

    public LoginViewModel() {
        user = new user("", "");
    }

    public void onLoginClicked() {

        if (mymodel.firebaseLogin(getUserEmail(), getUserPassword())) {


            setToastMessage(successMessage);
        }else {
                setToastMessage(errorMessage);
            }




        /*if (isInputDataValid())
            setToastMessage(successMessage);
        else
            setToastMessage(errorMessage);
    }

    public boolean isInputDataValid() {
        return !TextUtils.isEmpty(getUserEmail()) && Patterns.EMAIL_ADDRESS.matcher(getUserEmail()).matches() && getUserPassword().length() > 5;
    }*/
        }
    }
