package org.askerov.dynamicgrid;

import android.util.Log;

public final class L {

	private static final String LOG_FORMAT = "%1$s\n%2$s";
	
	private static volatile int logPriority = 0;

	private L() {
	}


	public static void v(String tag, String message, Object... args) {
		if (logPriority > Log.VERBOSE) return;
		log(Log.VERBOSE, tag, message, null, args);
	}
	
	public static void d(String tag, String message, Object... args) {
		if (logPriority > Log.DEBUG) return;
		log(Log.DEBUG, tag, message, null, args);
	}

	public static void i(String tag, String message, Object... args) {
		if (logPriority > Log.INFO) return;
		log(Log.INFO, tag, message, null, args);
	}

	public static void w(String tag, String message, Object... args) {
		if (logPriority > Log.WARN) return;
		log(Log.WARN, tag, message, null, args);
	}

	public static void e(String tag, Throwable ex) {
		if (logPriority > Log.ERROR) return;
		log(Log.ERROR, tag, null, ex);
	}

	public static void e(String tag, String message, Object... args) {
		if (logPriority > Log.ERROR) return;
		log(Log.ERROR, tag, message, null, args);
	}

	public static void e(String tag, String message, Throwable ex, Object... args) {
		if (logPriority > Log.ERROR) return;
		log(Log.ERROR, tag, message, ex, args);
	}

	private static void log(int priority, String tag, String message, Throwable ex, Object... args) {
		if (args.length > 0) {
			message = String.format(message, args);
		}

		String log;
		if (ex == null) {
			log = message;
		} else {
			String logMessage = message == null ? ex.getMessage() : message;
			String logBody = Log.getStackTraceString(ex);
			log = String.format(LOG_FORMAT, logMessage, logBody);
		}
		Log.println(priority, tag, log);
	}
}