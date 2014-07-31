package com.phodal.android.athome;

/**
 * Created by fdhuang on 5/24/14.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HTTP;

/*
 * This Class is coming from
 * http://lukencode.com/2010/04/27/calling-web-services-in-android-using-httpclient/
 *
 * Modification :
 *  - Added PUT and DELETE method on execute
 *  - Added GZIP
 *
 * HOW to USE :
 * RestClient client = new RestClient(LOGIN_URL);
 * client.AddParam("accountType", "GOOGLE");
 * client.AddParam("source", "tboda-widgalytics-0.1");
 * client.AddParam("Email", _username);
 * client.AddParam("Passwd", _password);
 * client.AddParam("service", "analytics");
 * client.AddHeader("GData-Version", "2");
 *
 * try {
 *     client.Execute(RequestMethod.POST);
 * } catch (Exception e) {
 *     e.printStackTrace();
 * }
 *
 * String response = client.getResponse();
 */

public class RestClient {

    protected ArrayList<NameValuePair> params;
    protected ArrayList<NameValuePair> headers;

    protected String url;
    private String data = "";

    private int responseCode;
    private String message;

    private String response;

    private int timeoutConnection = 60000;
    private int timeoutSocket = 60000;

    public enum RequestMethod {
        GET, POST, PUT, DELETE
    }

    public String getResponse() {
        return response;
    }

    public String getErrorMessage() {
        return message;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public RestClient(String url) {
        this.url = url;
        params = new ArrayList<NameValuePair>();
        headers = new ArrayList<NameValuePair>();
    }

    public void AddParam(String data) {
        this.data = data;
    }

    public void AddParam(String name, String value) {
        params.add(new BasicNameValuePair(name, value));
    }

    public void AddHeader(String name, String value) {
        headers.add(new BasicNameValuePair(name, value));
    }

    public void Execute(RequestMethod method) throws Exception {
        switch (method) {
            case GET: {
                // add parameters
                String combinedParams = "";
                if (!params.isEmpty()) {
                    combinedParams += "?";
                    for (NameValuePair p : params) {
                        String paramString = p.getName() + "="
                                + URLEncoder.encode(p.getValue(), HTTP.UTF_8);
                        if (combinedParams.length() > 1) {
                            combinedParams += "&" + paramString;
                        } else {
                            combinedParams += paramString;
                        }
                    }
                }

                HttpGet request = new HttpGet(url + combinedParams);
                request.addHeader("Accept-Encoding", "gzip");

                // add headers
                for (NameValuePair h : headers) {
                    request.addHeader(h.getName(), h.getValue());
                }

                executeRequest(request, url);
                break;
            }
            case POST: {
                HttpPost request = new HttpPost(url);
                request.addHeader("Accept-Encoding", "gzip");

                // add headers
                for (NameValuePair h : headers) {
                    request.addHeader(h.getName(), h.getValue());
                }
                if (!data.equals("")) {
                    request.setEntity(new StringEntity(data, HTTP.UTF_8));
                }

                if (!params.isEmpty()) {
                    request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                }

                executeRequest(request, url);
                break;
            }
            case PUT: {
                HttpPut request = new HttpPut(url);
                request.addHeader("Accept-Encoding", "gzip");

                // add headers
                for (NameValuePair h : headers) {
                    request.addHeader(h.getName(), h.getValue());
                }
                if (!data.equals("")) {
                    request.setEntity(new StringEntity(data, HTTP.UTF_8));
                }

                if (!params.isEmpty()) {
                    request.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
                }

                executeRequest(request, url);
                break;
            }
            case DELETE: {
                HttpDelete request = new HttpDelete(url);
                request.addHeader("Accept-Encoding", "gzip");

                // add headers
                for (NameValuePair h : headers) {
                    request.addHeader(h.getName(), h.getValue());
                }

                executeRequest(request, url);
                break;
            }
        }
    }

    protected void executeRequest(HttpUriRequest request, String url) {

        HttpParams httpParameters = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParameters,
                timeoutConnection);
        HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);

        HttpProtocolParams.setUseExpectContinue(httpParameters, false);
        request.setParams(httpParameters);

        setOauth(request);

        DefaultHttpClient client = new DefaultHttpClient();

        HttpResponse httpResponse;

        try {
            httpResponse = client.execute(request);
            responseCode = httpResponse.getStatusLine().getStatusCode();
            message = httpResponse.getStatusLine().getReasonPhrase();

            HttpEntity entity = httpResponse.getEntity();

            if (entity != null) {
                InputStream instream = httpResponse.getEntity().getContent();
                Header contentEncoding = httpResponse
                        .getFirstHeader("Content-Encoding");

                if (contentEncoding != null
                        && contentEncoding.getValue().equalsIgnoreCase("gzip")) {
                    instream = new GZIPInputStream(instream);
                }

                // instream = entity.getContent();
                response = convertStreamToString(instream);

                // Closing the input stream will trigger connection release
                instream.close();
            }

        } catch (ClientProtocolException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        } catch (IOException e) {
            client.getConnectionManager().shutdown();
            e.printStackTrace();
        }
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    protected void setOauth(HttpUriRequest request) {

    }
}