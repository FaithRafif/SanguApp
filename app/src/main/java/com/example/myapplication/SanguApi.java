package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class SanguApi {


    public interface login{
        void onSucces(String result);
        void onFail(String errorMessage);
    }
    public static void getLogin(String password,String email,login callback){
        new Thread(new Runnable() {
            HttpURLConnection connection = null;
            @Override
            public void run() {
                try{
                    String endPointUrl = "http://localhost:5000/api/auth/login";
                    URL url = new URL(endPointUrl);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("POST");
                    connection.setRequestProperty("Authorization","Bearer "+"SDmadaskd29ddas");
                    connection.setReadTimeout(10000);
                    connection.setDoOutput(true);
                    connection.setReadTimeout(10000);
                    String penampung = "Email="+ email +"&Password="+password;

                    OutputStream os = connection.getOutputStream();
                    os.flush();
                    os.close();
                    int response = connection.getResponseCode();
                    if (response != HttpURLConnection.HTTP_OK){
                        callback.onFail("Http : "+response);
                        return;
                    }
                    BufferedReader cvByte = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    StringBuilder storageText = new StringBuilder();
                    String line;
                    while((line = cvByte.readLine()) != null){
                        storageText.append(line);
                    }
                    cvByte.close();
                    callback.onSucces(penampung);
                } catch (Exception e) {
                    callback.onFail("Http : ");
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }
    public interface claim{
        void onSucces(ArrayList<SanguModel> sanguModels);
        void onFail(String error);
    }
    public static void getClaim (claim callback){
        new Thread(new Runnable() {
            HttpURLConnection connection = null ;
            @Override
            public void run() {
                try {
                    String endPoint = "http://localhost:5000/api/claim";
                    URL url = new URL(endPoint);
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setRequestProperty("Authorization","Bearer "+"SDmadaskd29ddas");
                    connection.setReadTimeout(10000);
                    connection.setConnectTimeout(10000);
                    int response = connection.getResponseCode();
                    if (response != HttpURLConnection.HTTP_OK){
                        callback.onFail("Http : "+response);
                        return;
                    }
                    InputStream inputStream = connection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                    StringBuilder storageText = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        storageText.append(line);
                    }
                    reader.close();
                    JSONObject jsonObject = new JSONObject(storageText.toString());
                    JSONArray items = jsonObject.getJSONArray("items");
                    ArrayList<SanguModel> sanguModel = new ArrayList<>();
                    for (int i = 0 ; i < items.length(); i++){
                        JSONObject result = items.getJSONObject(i);
                        int id = result.getInt("id");
                        String claimNumber = result.getString("claimNumber");
                        String title = result.getString("title");
                        String claimDate = result.getString("claimDate");
                        String status = result.getString("status");
                        int totalAmount = result.getInt("totalAmount");
                        String categoryName = result.getString("categoryName");
                        SanguModel model = new SanguModel(claimNumber,title,claimDate,status,totalAmount,categoryName,id);
                        sanguModel.add(model);
                    }
                    callback.onSucces(sanguModel);
                } catch (Exception e) {
                    callback.onFail("Http : ");
                }finally {
                    if (connection != null){
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    public static void getDetail(int movieId,login callback){
        new Thread(new Runnable() {
            HttpURLConnection connection = null;
            @Override
            public void run() {
                try {


                } catch (Exception e) {
                    throw new RuntimeException(e);
                }finally {

                }
            }
        }).start();
    }

}
