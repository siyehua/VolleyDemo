package com.siyehua.volleydemo;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


/**
 * NetWork Request,One Instance.
 * Created by siyehua on 2015/12/9.
 */
public class NetWorkUtils {
    private NetWorkUtils() {//private.
        requestQueue = Volley.newRequestQueue(SiApplication.getInstance());
    }

    private static NetWorkUtils netWorkUtils;

    public synchronized static NetWorkUtils getInstance() {//get the instance.
        if (netWorkUtils == null) {
            netWorkUtils = new NetWorkUtils();
        }
        return netWorkUtils;
    }

    private RequestQueue requestQueue;//request queue

    /*
    * startrequest
    * url:service url
    * parmas:parmas,you can change key-value.
    * getDataListener:get data listener
    * */
    public void startRequest(final String url, final String parmas, final GetDataListener getDataListener) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url + parmas, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                if (getDataListener != null) getDataListener.getDataSuccess(url + parmas, s);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                if (getDataListener != null) {
                    getDataListener.getDataError(url + parmas, volleyError.toString());
                }
            }
        });
        requestQueue.add(stringRequest);
    }

    /*
    * Request Data Listener
    * */
    public interface GetDataListener {
        /*
        * success method
        * requestId:request id.if you want switch different request.
        * resutl:the result form the service.
        * */
        void getDataSuccess(String requestId, String result);

        /*
        * error method
        * requestId:request id.if you want switch different request.
        * result:the error result.
        * */
        void getDataError(String requestId, String result);//失败
    }

}
