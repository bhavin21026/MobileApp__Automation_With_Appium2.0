package com.cma.constants;

public final class FrameworkConstants {

    //lombak

    private FrameworkConstants(){}

    private static final String resourcepath = System.getProperty("user.dir") + "//resources";
    private static final String apkfilepath = resourcepath+"//apkbuilds//";
    private static final String configfilepath = resourcepath+"//config/config.properties";
    private static final String serverBatFile = resourcepath+"//startEmulator.bat";
    private static final String runEmulator = resourcepath+"//runEmulator.bat";
	private static final String SCRRENSHOTPATH = resourcepath+"/Screenshots/";
	private static final String EXTENTREPORTPATH = resourcepath+"/AutomationReports/";

	private static final String JASONDATAPATH = resourcepath+"//jsontestdata";


    
    private static final String saveToast="@content-desc='Info\n"
    		+ "The task has been saved successfully. Please note that the mandatory criteria must be fulfilled before clicking on the submit action'";
    
    //AudioFiles
    
    private static final String audio1 = resourcepath+"//audioToBeUpload//1 min diff_1.wav";
    private static final String remotePath = "/storage/emulated/0/Download/1 min diff_1.wav";
    
    
    public static String getJsonDataPath() {
        return JASONDATAPATH;
    }
    
    public static String getResourcesPath() {
        return resourcepath;
    }
    
    
    public static String getRemotePath() {
        return remotePath;
    }
    
    public static String getAudio1() {
        return audio1;
    }
    
    public static String getSaveToastMessage() {
        return saveToast;
    }
    
    
    public static String getApkFilePath() {
        return apkfilepath;
    }

    public static String getConfigFilePath() {
        return configfilepath;
    }
    
    public static String getServerBatFilePath() {
        return serverBatFile;
    }
    
    public static String getRunEmulatorPath() {
        return runEmulator;
    }
    
    public static String getScreenShotPath() {

		return SCRRENSHOTPATH;
	}
    
    public static String getExtentReportPath() {

		return EXTENTREPORTPATH;
	}
}
