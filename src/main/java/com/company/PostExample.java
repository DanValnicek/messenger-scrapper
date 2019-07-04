package main.java.com.company;

import okhttp3.*;

import java.io.IOException;



    public class PostExample {
        public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

        OkHttpClient client = new OkHttpClient();

        String post(String url, String json) throws IOException {
            RequestBody body = RequestBody.create(JSON, json);
            Request request = new Request.Builder()
                    .url(url)
                    .post(body)
                    .build();
            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
        }




        //        HttpsURLConnection connection = null;
//        try {
//            URL url = new URL("https://tea-bot.eu-gb.mybluemix.net/");
//            connection = (HttpsURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Map<String, String> parameters = new HashMap<>();
//        parameters.put("param1", "val");
//
//        try {
//            connection.setDoOutput(true);
//            DataOutputStream outputStream = new DataOutputStream(connection.getOutputStream());
//            outputStream.writeBytes(ParameterStringBuilder.getParamsString(parameters));
//        }catch (Exception e){
//            System.out.println("something is wrong with http");
//        }
    }



