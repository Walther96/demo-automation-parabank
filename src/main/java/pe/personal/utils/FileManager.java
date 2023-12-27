package pe.personal.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.personal.constants.KeysConstants;

import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FileManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileManager.class);
    private static FileManager instance;
    private Map<String,String> properties;

    private FileManager(){
        properties = new HashMap<>();
    }

    private void readProperties(){

        try {
            File text = new File(KeysConstants.PROPERTIES_PATH);

            Scanner scnr = new Scanner(text);
            while(scnr.hasNextLine()){
                String line = scnr.nextLine();
                propertiesHandlerDecoder(line);
            }
            scnr.close();
        }catch (FileNotFoundException e){
            LOGGER.error(e.getMessage());
        }
    }
    private void writeFile(String val){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(KeysConstants.DYNAMIC_FILE_PATH);
                pw = new PrintWriter(fichero);
                pw.println(propertiesHandlerEncoder(val));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                LOGGER.error(e2.getMessage());
            }
        }
    }
    private static String readFile(){
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String linea="";
        try {
            archivo = new File (KeysConstants.DYNAMIC_FILE_PATH);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
            linea = br.readLine();
            return linea;
        }
        catch(Exception e){
            LOGGER.error(e.getMessage());
        }finally{
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                LOGGER.error(e2.getMessage());
            }
        }
        return linea;
    }
    public String readValueEncrypted(){
        byte[] decodedBytes = Base64.getUrlDecoder().decode(readFile());
        return new String(decodedBytes);
    }
    private void propertiesHandlerDecoder(String line){
        String key = line.substring(0,line.indexOf("="));
        String val = line.substring(line.indexOf("=")+1);
        byte[] decodedBytes = Base64.getUrlDecoder().decode(val);
        val = new String(decodedBytes);
        properties.put(key, val);
    }
    public String propertiesHandlerEncoder(String value){
        return Base64.getEncoder().encodeToString(value.getBytes());
    }

    public static synchronized FileManager getInstance(){
        if(instance == null){
            instance = new FileManager();
        }
        return instance;
    }

    public String getProperties(String key) {
        return properties.get(key);
    }
    public void getValuesDecrypted(){
        readProperties();
    }
    public void setValuesEncrypted(String valuesEncrypted){
        writeFile(valuesEncrypted);
    }

}
