package com.security.util;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import com.security.activities.FragmentChangeActivity;
import com.security.classes.Cache;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.widget.ArrayAdapter;

public class SecAppUtil {
	public static final int MEDIA_TYPE_IMAGE = 1;
	public static final int MEDIA_TYPE_VIDEO = 2;
	public static boolean debugMode = true;
	
	public static boolean isSignificant(Object obj){
		if(obj==null)return false;
		
		if(obj instanceof ArrayAdapter){
			return !((ArrayAdapter)obj).isEmpty();
		}
		if(obj instanceof JsonArray){
			return (((JsonArray)obj).size()>0);
		}
		if(obj instanceof List){
			return (((List)obj).size()>0);
		}else if(obj instanceof String){
			return !((String) obj).trim().equals("");
		}else if(obj instanceof File[]){
			File[] arr = (File[]) obj;
			for(int i = 0;i < arr.length; i++){
				if(arr[i] != null){
					return true;
				}
			}
			return false;
		}else if(obj instanceof File){
			return ((File)obj).exists();
		}
		
		return false;
	}

	public static void showAlert(Exception message, Activity activity){
		if(SecAppUtil.debugMode){
			StringWriter writer = new StringWriter();
			PrintWriter printWriter = new PrintWriter( writer );
			message.printStackTrace( printWriter );
			printWriter.flush();

			showAlert(message.toString() + "-" + writer.toString(), activity, 100000);
		}else{
			showAlert("Ha ocurrido un problema, por favor intente nuevamente la operacion. Revise su conexion.", activity, null);			
		}
	}
	
	public static void showAlert(String message, Activity activity){
		showAlert(message, activity, null);
	}
	
	public static void showAlert(String message, Activity activity, Integer timeout){
		if(activity != null){
			try {
				writeLog(message);
			} catch (Exception e) {
			}
			AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(activity);
			alertDialogBuilder.setMessage(message);
			final AlertDialog a = alertDialogBuilder.show();
			Handler handler = new Handler();
			handler.postDelayed(new Runnable() {
				public void run() {
					if(a!=null){
						a.dismiss();	
					}
				}
			}, (timeout != null)?timeout : 10000);
		}
	}
	
	public static void showProgressBar(Activity act){
	}

	public static boolean checkConnection(){
		if(!isNetworkAvailable()){
			SecAppUtil.showAlert("No se ha detectado la conexion a Internet, por favor verifique su estado...", Cache.appActivity, 4000);
			return false;
		}
		return true;
	}
	
	public static boolean isNetworkAvailable() {
		if(Cache.appActivity != null){
			try {
				ConnectivityManager connectivityManager = (ConnectivityManager) Cache.appActivity.getSystemService(Context.CONNECTIVITY_SERVICE);
		    	NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
		    	return activeNetworkInfo != null && activeNetworkInfo.isConnected();
			} catch (Exception e) {
				//Catch??
				return true;
			}
		}
		return true;
	}
	
	private static void showAlert(String message, Exception e, Activity activity) {
		if(SecAppUtil.debugMode){
			showAlert(e, activity);
		}else{
			showAlert(message, activity);			
		}
		
	}

	public static void saveToDisk(InputStream u, File out){
		InputStream inputStream = null;
		OutputStream outputStream = null;
	 
		try {
			outputStream = 
	                    new FileOutputStream(out);
			int read = 0;
			byte[] bytes = new byte[1024];
	 
			while ((read = u.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

    public static void writeLog(Throwable e) {
    	try {
            final Writer result = new StringWriter();
            final PrintWriter printWriter = new PrintWriter(result);
            e.printStackTrace(printWriter);
            String stacktrace = result.toString();
            printWriter.close();
            writeLog(stacktrace);
		} catch (Exception e2) {
		}
}
    
    public static void writeLog(String stacktrace) {
    	try {
    	    File logMediaStorageDir = new File(Environment.getExternalStorageDirectory().getPath(), "SecApp");
    	    if (! logMediaStorageDir.exists()){
    	        if (! logMediaStorageDir.mkdirs()){
    	        	showAlert("Por favor revise su memoria externa SD y reintente la operacion", Cache.appActivity);
    	        }
    	    }
        	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
    	    File logFileName = new File(logMediaStorageDir.getPath() + File.separator + "log_" + timeStamp + ".txt");
            BufferedWriter bos = new BufferedWriter(new FileWriter(logFileName));
            bos.write(stacktrace);
            bos.flush();
            bos.close();
		} catch (Exception e) {
		}
    }
    
	public static JsonArray toJsonArray(List<String> list){
		JsonArray res = new JsonArray();
		if (isSignificant(list)){
			for (String adj : list){
				res.add(new JsonPrimitive(adj));
			}
		}
		return res;
	}
}
