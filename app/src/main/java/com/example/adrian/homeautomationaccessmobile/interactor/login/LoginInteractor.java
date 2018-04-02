package com.example.adrian.homeautomationaccessmobile.interactor.login;

import android.os.AsyncTask;

import com.example.adrian.homeautomationaccessmobile.ui.login.LoginResponse;

public class LoginInteractor extends AsyncTask<Void, Void, Boolean> {

    private String email;
    private String password;
    private LoginResponse loginResponse;

    private static final String[] DUMMY_CREDENTIALS = new String[]{
            "foo@example.com:hello", "bar@example.com:world", "a:a"
    };

    public void setCreadentials(String email, String password, LoginResponse loginResponse) {
        this.email = email;
        this.password = password;
        this.loginResponse = loginResponse;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        // TODO: attempt authentication against a network service.

        try {
            // Simulate network access.
            Thread.sleep(500);
        } catch (InterruptedException e) {
            return false;
        }

        for (String credential : DUMMY_CREDENTIALS) {
            String[] pieces = credential.split(":");
            if (pieces[0].equals(email)) {
                // Account exists, return true if the password matches.
                return pieces[1].equals(password);
            }
        }

        // TODO: register the new account here.
        return false;
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        if(success) loginResponse.loginSuccess();
        else loginResponse.loginError();
    }

    @Override
    protected void onCancelled() {
        loginResponse.loginCancelled();
    }
}
