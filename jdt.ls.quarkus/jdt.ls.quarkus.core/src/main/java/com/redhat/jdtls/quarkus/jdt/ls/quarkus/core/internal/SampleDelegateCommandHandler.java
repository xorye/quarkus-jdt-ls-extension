package com.redhat.jdtls.quarkus.jdt.ls.quarkus.core.internal;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
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
            
            //JavaClientConnection connection = JavaLanguageServerPlugin.getInstance().getClientConnection();
            
            // VSCode command for VSCode to run
        	
            String metadataString = "[{\"propertyName\":\"quarkus.application.name\",\"type\":\"java.lang.String\"},{\"propertyName\":\"quarkus.application.version\",\"type\":\"java.lang.String\"},{\"propertyName\":\"quarkus.jni.library-paths\"},{\"propertyName\":\"quarkus.jni.enable\",\"defaultValue\":\"false\"},{\"propertyName\":\"quarkus.ssl.native\"},{\"propertyName\":\"quarkus.index-dependency\"},{\"propertyName\":\"quarkus.thread-pool.core-threads\",\"defaultValue\":\"1\"},{\"propertyName\":\"quarkus.thread-pool.max-threads\",\"type\":\"java.util.OptionalInt\"},{\"propertyName\":\"quarkus.thread-pool.queue-size\",\"type\":\"java.util.OptionalInt\"},{\"propertyName\":\"quarkus.thread-pool.growth-resistance\",\"defaultValue\":\"0\"}]";
            
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();    
            ExtendedConfigDescriptionBuildItem[] metadata = gson.fromJson(metadataString, ExtendedConfigDescriptionBuildItem[].class);
            List<ExtendedConfigDescriptionBuildItem> items = new ArrayList<>();
            for (ExtendedConfigDescriptionBuildItem item : metadata) {
				items.add(item);
			}  
            return items;
        }
        throw new UnsupportedOperationException(String.format("Unsupported command '%s'!", commandId));
    }


}
