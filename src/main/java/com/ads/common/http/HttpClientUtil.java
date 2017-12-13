package com.ads.common.http;

import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PC端登录Controller
 *
 * @author dfggking@hotmail.com
 * @version 1.0
 * @date 2017-06-28
 */
@Component("httpClientUtil")
public class HttpClientUtil implements BeanFactoryAware {
    private BeanFactory beanFactory;
    /**
     * Callback that supplies the owning factory to a bean instance.
     * <p>Invoked after the population of normal bean properties
     * but before an initialization callback such as
     * {@link InitializingBean#afterPropertiesSet()} or a custom init-method.
     *
     * @param beanFactory owning BeanFactory (never {@code null}).
     * The bean can immediately call methods on the factory.
     * @throws BeansException in case of initialization errors
     * @see BeanInitializationException
     */
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    /**
     * 将required设置为false:
     * 为了避免RequestConfig没被注进来的时候其他方法都不能用,报createbeanfailedexception
     */
    @Autowired(required = false)
    private RequestConfig requestConfig;

    private CloseableHttpClient getHttpClient(){
        return this.beanFactory.getBean(CloseableHttpClient.class);
    }

    /**
     * 无参get请求
     * @param url
     * @return
     */
    public String doGet(String url) throws IOException {
        // 创建http GET请求
        HttpGet httpGet = new HttpGet(url);
        //设置请求参数
        httpGet.setConfig(requestConfig);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = this.getHttpClient().execute(httpGet);
            // 判断返回状态是否为200
            int STATUS_CODE = 200;
            if (response.getStatusLine().getStatusCode() == STATUS_CODE) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                return content;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            response.close();
        }
        return null;
    };

    public String doGet(String url, Map<String, String> params) throws IOException {
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(url);
            if (Objects.nonNull(params)) {
                for (String key : params.keySet()) {
                    uriBuilder.setParameter(key, params.get(key));
                }
            }
            return this.doGet(uriBuilder.build().toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 有参post请求
     * @param url
     * @param params
     * @return
     */
    public HttpResult doPost(String url, Map<String, String> params) throws IOException {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        if (Objects.nonNull(params)) {
            // 设置2个post参数 一个是scope 一个是q
            List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
            for (String key : params.keySet()) {
                parameters.add(new BasicNameValuePair(key, params.get(key)));
            }
            // 构造一个form表单式的实体
            UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters, "UTF-8");
            // 将请求实体设置到httpPost对象中
            httpPost.setEntity(formEntity);
        }
        CloseableHttpResponse response = null;

        // 执行请求
        try {
            response = this.getHttpClient().execute(httpPost);
            // 判断返回状态是否为200
            /*if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }*/
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity()
                    , "UTF-8"));
        } catch (IOException e) {

            e.printStackTrace();
        }finally {
            if (Objects.nonNull(response)) {
                response.close();
            }
        }
        return null;
    }

    /**
     * 有参post请求 json交互
     * @param url
     * @param json
     * @return
     */
    public HttpResult doPostJson(String url, String json) throws IOException {
        // 创建http post 请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(requestConfig);
        if (Objects.nonNull(json)) {
            // 标识传递参数是application/json
            StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
            httpPost.setEntity(stringEntity);
        }
        CloseableHttpResponse response = null;

        try {
            // 执行请求
            response = this.getHttpClient().execute(httpPost);
            // 判断返回状态是否为200
            /*if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }*/
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity()
                    , "UTF-8"));
        } finally {
            if (Objects.nonNull(response)) {
                response.close();
            }
        }
    }

    /**
     * 无参post请求
     * @param url
     * @return
     */
    public HttpResult doPost(String url) throws IOException {
        return this.doPost(url, null);
    }
}


