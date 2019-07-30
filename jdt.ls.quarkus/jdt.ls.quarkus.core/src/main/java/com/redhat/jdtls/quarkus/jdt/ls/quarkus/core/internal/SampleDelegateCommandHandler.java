package com.redhat.jdtls.quarkus.jdt.ls.quarkus.core.internal;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;



import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ls.core.internal.IDelegateCommandHandler;
import org.eclipse.jdt.ls.core.internal.JavaClientConnection;
import org.eclipse.jdt.ls.core.internal.JavaLanguageServerPlugin;

public class SampleDelegateCommandHandler implements IDelegateCommandHandler {

    public static final String COMMAND_ID = "com.redhat.jdtls.quarkus.jdt.ls.quarkus.samplecommand";

    @Override
    public Object executeCommand(String commandId, List<Object> arguments, IProgressMonitor progress) throws Exception {
        if (COMMAND_ID.equals(commandId)) {
            
            JavaClientConnection connection = JavaLanguageServerPlugin.getInstance().getClientConnection();
            
            // VSCode command for VSCode to run
            String command = "quarkusTools.notifyQuarkusLS";
            
            // Any number of objects used as parameters for the VSCode command
            String metadataString = "[{\"propertyName\":\"quarkus.application.name\"},{\"propertyName\":\"quarkus.application.version\"},{\"propertyName\":\"quarkus.jni.library-paths\"},{\"propertyName\":\"quarkus.jni.enable\"},{\"propertyName\":\"quarkus.ssl.native_\"},{\"propertyName\":\"quarkus.index-dependency.index-dependency\"},{\"propertyName\":\"quarkus.thread-pool.core-threads\"},{\"propertyName\":\"quarkus.thread-pool.max-threads\"},{\"propertyName\":\"quarkus.thread-pool.queue-size\"},{\"propertyName\":\"quarkus.thread-pool.growth-resistance\"},{\"propertyName\":\"quarkus.thread-pool.shutdown-timeout\"},{\"propertyName\":\"quarkus.thread-pool.shutdown-interrupt\"},{\"propertyName\":\"quarkus.thread-pool.shutdown-check-interval\"},{\"propertyName\":\"quarkus.thread-pool.keep-alive-time\"},{\"propertyName\":\"quarkus.log.categories\"},{\"propertyName\":\"quarkus.log.filters\"},{\"propertyName\":\"quarkus.log.level\"},{\"propertyName\":\"quarkus.log.min-level\"},{\"propertyName\":\"quarkus.log.console\",\"defaultValue\":\"\\u003c\\u003cno default\\u003e\\u003e\"},{\"propertyName\":\"quarkus.log.file\",\"defaultValue\":\"\\u003c\\u003cno default\\u003e\\u003e\"},{\"propertyName\":\"quarkus.infinispan-client.infinispan-client\"},{\"propertyName\":\"quarkus.infinispan-client.infinispan-client\"},{\"propertyName\":\"quarkus.http.http\"},{\"propertyName\":\"quarkus.http.port\"},{\"propertyName\":\"quarkus.http.ssl-port\"},{\"propertyName\":\"quarkus.http.test-port\"},{\"propertyName\":\"quarkus.http.test-ssl-port\"},{\"propertyName\":\"quarkus.http.host\"},{\"propertyName\":\"quarkus.http.io-threads\"},{\"propertyName\":\"quarkus.http.ssl\",\"defaultValue\":\"\\u003c\\u003cno default\\u003e\\u003e\"},{\"propertyName\":\"quarkus.http.cors\",\"defaultValue\":\"\\u003c\\u003cno default\\u003e\\u003e\"}]";
            
            
            ///////////////////////////////////////////////////
            // This is what I think Fred wanted me to try out
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            Metadata[] metadata = gson.fromJson(metadataString, Metadata[].class);
            ///////////////////////////////////////////////////
            
            // Tells VSCode to execute a command with specified parameters
            connection.executeClientCommand(command, metadata);
            
            return "Done";
            
        }
        throw new UnsupportedOperationException(String.format("Unsupported command '%s'!", commandId));
    }


}