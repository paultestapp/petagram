package com.psf.petagram.util;

import android.util.Log;

import com.psf.petagram.Config;
import com.psf.petagram.models.MensajeMail;

import java.security.Security;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public class MailUtil extends javax.mail.Authenticator {
    private static String TAG = "MailUtil";

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(Config.gmail_user, Config.gmail_pass);
    }

    static {
        Security.addProvider(new JSSEProvider());
    }

    public synchronized void enviar (MensajeMail msg) throws Exception {

        String mensaje = msg.getNombre() + " " + msg.getEmail() + msg.getMensaje();

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "465");
        props.put("mail.smtp.socketFactory", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        try{
            Session session = Session.getDefaultInstance(props, this);

            if(session != null) {
                final Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress(Config.gmail_user));
                message.setSubject(Config.gmail_asunto);
                message.setRecipient(Message.RecipientType.TO, new InternetAddress(Config.gmail_email));
                message.setContent(mensaje, "text/html");

                Transport.send(message);
            }else{
                Log.e(TAG, "No session");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
