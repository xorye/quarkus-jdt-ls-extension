package com.redhat.jdtls.quarkus.jdt.ls.quarkus.core.internal;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class ExtensionActivator implements BundleActivator {

	// The plug-in ID
	public static final String PLUGIN_ID = "jdt.ls.quarkus.core";

	// The shared instance
	private static ExtensionActivator plugin;
	
	public void start(BundleContext context) throws Exception {
		plugin  = this;
	}

	public void stop(BundleContext context) throws Exception {
		plugin = null;
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static ExtensionActivator getDefault() {
		return plugin;
	}
}
