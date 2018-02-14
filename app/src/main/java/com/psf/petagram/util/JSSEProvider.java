package com.psf.petagram.util;

import java.security.AccessController;
import java.security.Provider;

/**
 * Created by paulsalcedo on 13/2/18.
 */

public final class JSSEProvider extends Provider {

    protected JSSEProvider() {
        super("HarmonyJSSE", 1.0, "Harmony JSSE Provider");

        AccessController.doPrivileged(new java.security.PrivilegedAction<Void>() {

            @Override
            public Void run() {

                put("SSLContext.TLS", "org.apache.harmony.xnet.provider.jsse.SSLContextImpl");
                put("Alg.Alias.SSLContext.TLSv1", "TLS");
                put("KeyManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.KeyManagerFactoryImpl");
                put("TrustManagerFactory.X509", "org.apache.harmony.xnet.provider.jsse.TrustManagerFactoryImpl");

                return null;
            }
        });
    }

}