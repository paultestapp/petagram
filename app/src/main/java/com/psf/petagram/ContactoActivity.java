package com.psf.petagram;

import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.psf.petagram.models.MensajeMail;
import com.psf.petagram.util.MailUtil;

public class ContactoActivity extends AppCompatActivity {
    private Resources resources;

    private TextInputEditText tie_nombre;
    private TextInputEditText tie_email;
    private TextInputEditText tie_mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        resources = getResources();

        Toolbar mainActionbar = findViewById(R.id.main_actionbar);
        if(mainActionbar != null) setSupportActionBar(mainActionbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        tie_nombre = findViewById(R.id.tie_nombre);
        tie_email = findViewById(R.id.tie_email);
        tie_mensaje = findViewById(R.id.tie_mensaje);
    }

    public void btnEnviarAction(View view) {
        if (tie_nombre.getText().toString().length()>0 &&
                tie_email.getText().toString().length()>0 &&
                tie_mensaje.getText().toString().length()>0) {
            enviar(view);
        }else{
            Snackbar.make(view, resources.getString(R.string.msg_fail_form_mail), Snackbar.LENGTH_SHORT).show();
        }
    }

    public void enviar(View view) {
        final View v = view;
        final MensajeMail mensajeMail = new MensajeMail(tie_nombre.getText().toString(),
                tie_email.getText().toString(),
                tie_mensaje.getText().toString());

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    MailUtil mailUtil = new MailUtil();
                    mailUtil.enviar(mensajeMail);
                    Snackbar.make(v, resources.getString(R.string.msg_success_form_mail), Snackbar.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                    Snackbar.make(v, resources.getString(R.string.msg_failed_form_mail), Snackbar.LENGTH_LONG).show();
                }
            }
        });
        thread.start();

        tie_nombre.setText(null);
        tie_email.setText(null);
        tie_mensaje.setText(null);
        
        Snackbar.make(view, resources.getString(R.string.msg_sending_form_mail), Snackbar.LENGTH_LONG).show();
    }

}
