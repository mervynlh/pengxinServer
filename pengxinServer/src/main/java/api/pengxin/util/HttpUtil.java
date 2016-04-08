package api.pengxin.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class HttpUtil {

	private static Log log = LogFactory.getLog(HttpUtil.class);

	/**
	 * 定义编码格式 UTF-8
	 */
	public static final String URL_PARAM_DECODECHARSET_UTF8 = "UTF-8";

	/**
	 * 定义编码格式
	 */
	public static final String GB2312 = "gb2312";

	/**
	 * 定义编码格式 GBK
	 */
	public static final String URL_PARAM_DECODECHARSET_GBK = "GBK";

	private static final String URL_PARAM_CONNECT_FLAG = "&";

	private static final String EMPTY = "";

	private static MultiThreadedHttpConnectionManager connectionManager = null;

	private static int connectionTimeOut = 25000;

	private static int socketTimeOut = 25000;

	private static int maxConnectionPerHost = 20;

	private static int maxTotalConnections = 20;

	private static HttpClient client;

	static {
		connectionManager = new MultiThreadedHttpConnectionManager();
		connectionManager.getParams().setConnectionTimeout(connectionTimeOut);
		connectionManager.getParams().setSoTimeout(socketTimeOut);
		connectionManager.getParams().setDefaultMaxConnectionsPerHost(maxConnectionPerHost);
		connectionManager.getParams().setMaxTotalConnections(maxTotalConnections);
		client = new HttpClient(connectionManager);
	}

	/**
	 * POST方式提交数据
	 * 
	 * @param url
	 *            待请求的URL
	 * @param params
	 *            要提交的数据
	 * @param enc
	 *            编码
	 * @return 响应结果
	 * @throws IOException
	 *             IO异常
	 */
	public static String URLPost(String url, Map<String, String> params, String enc) {

		String response = EMPTY;
		PostMethod postMethod = null;
		try {
			postMethod = new PostMethod(url);
			postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
			// 将表单的值放入postMethod中
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				String value = params.get(key);
				postMethod.addParameter(key, value);
			}
			// 执行postMethod
			int statusCode = client.executeMethod(postMethod);

			if (statusCode == HttpStatus.SC_OK) {
				response = postMethod.getResponseBodyAsString();
			} else {
				log.error("响应状态码 = " + postMethod.getStatusCode());
			}
		} catch (HttpException e) {
			log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("发生网络异常", e);
			e.printStackTrace();
		} finally {
			if (postMethod != null) {
				postMethod.releaseConnection();
				postMethod = null;
			}
		}

		return response;
	}

	/**
	 * GET方式提交数据
	 * 
	 * @param url
	 *            待请求的URL
	 * @param params
	 *            要提交的数据
	 * @param enc
	 *            编码
	 * @return 响应结果
	 * @throws IOException
	 *             IO异常
	 */
	public static String URLGet(String url, Map<String, String> params, String enc) {

		String response = EMPTY;
		GetMethod getMethod = null;
		StringBuffer strtTotalURL = new StringBuffer(EMPTY);

		if (strtTotalURL.indexOf("?") == -1) {
			strtTotalURL.append(url).append("?").append(getUrl(params, enc));
		} else {
			strtTotalURL.append(url).append("&").append(getUrl(params, enc));
		}
		log.debug("GET请求URL = \n" + strtTotalURL.toString());
		System.out.println("url" + strtTotalURL.toString());
		try {
			getMethod = new GetMethod(strtTotalURL.toString());
			getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded;charset=" + enc);
			// 执行getMethod
			int statusCode = client.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				response = getMethod.getResponseBodyAsString();
			} else {
				log.debug("响应状态码 = " + getMethod.getStatusCode());
			}
		} catch (HttpException e) {
			log.error("发生致命的异常，可能是协议不对或者返回的内容有问题", e);
			e.printStackTrace();
		} catch (IOException e) {
			log.error("发生网络异常", e);
			e.printStackTrace();
		} finally {
			if (getMethod != null) {
				getMethod.releaseConnection();
				getMethod = null;
			}
		}

		return response;
	}

	/**
	 * 据Map生成URL字符串
	 * 
	 * @param map
	 *            Map
	 * @param valueEnc
	 *            URL编码
	 * @return URL
	 */
	private static String getUrl(Map<String, String> map, String valueEnc) {

		if (null == map || map.keySet().size() == 0) {
			return (EMPTY);
		}
		StringBuffer url = new StringBuffer();
		Set<String> keys = map.keySet();
		for (Iterator<String> it = keys.iterator(); it.hasNext();) {
			String key = it.next();
			if (map.containsKey(key)) {
				String val = map.get(key);
				String str = val != null ? val : EMPTY;
				try {
					str = URLEncoder.encode(str, valueEnc);
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				url.append(key).append("=").append(str).append(URL_PARAM_CONNECT_FLAG);
			}
		}
		String strURL = EMPTY;
		strURL = url.toString();
		// 截取掉末尾的&
		if (URL_PARAM_CONNECT_FLAG.equals(EMPTY + strURL.charAt(strURL.length() - 1))) {
			strURL = strURL.substring(0, strURL.length() - 1);
		}

		return (strURL);
	}

	// 封装pexip get相关的请求

	public static String pexipUrlget(String url, String username, String password) {
		GetMethod getMethod = new GetMethod(url);
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		getMethod.setRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
		int statusCode = 0;
		String response = "";
		try {
			statusCode = client.executeMethod(getMethod);
			response = getMethod.getResponseBodyAsString();
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	// 封装pexip post 相关的请求

	public static int pexipUrlpost(String url, String username, String password, HashMap<String, Object> params) {

		PostMethod postMethod = new PostMethod(url);
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		postMethod.setRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
		postMethod.setRequestHeader("Content-Type", "application/json");

		JSONObject jsonObject = new JSONObject();

		Set<String> keySet = params.keySet();
		for (String key : keySet) {
			Object value = params.get(key);
			jsonObject.put(key, value);
		}
		String transJson = jsonObject.toString();
		RequestEntity se = null;
		String response = "";
		int statusCode = 0;
		try {
			se = new StringRequestEntity(transJson, "application/json", "UTF-8");
			postMethod.setRequestEntity(se);
			// 使用系统提供的默认的恢复策略
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			// 设置超时的时间
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000000);
			// 执行postMethod
			statusCode = client.executeMethod(postMethod);
			System.out.println("statusCode==" + statusCode);
			// response = postMethod.getResponseBodyAsString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusCode;

	}

	public static int pexipUrlpost(String url, String username, String password, JsonObject params) {
		PostMethod postMethod = new PostMethod(url);
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		postMethod.setRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
		postMethod.setRequestHeader("Content-Type", "application/json");

		String transJson = params.toString();
		RequestEntity se = null;
		String response = "";
		int statusCode = 0;
		try {
			se = new StringRequestEntity(transJson, "application/json", "UTF-8");
			postMethod.setRequestEntity(se);
			// 使用系统提供的默认的恢复策略
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			// 设置超时的时间
			postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000000);

			// 执行postMethod

			statusCode = client.executeMethod(postMethod);
			System.out.println("statusCode==" + statusCode);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statusCode;

	}

	public static StringBuffer pexipUrlget(String url, String username, String password, Map<String, String> params) {
		InputStream response;

		StringBuffer strtTotalURL = new StringBuffer();

		if (strtTotalURL.indexOf("?") == -1) {
			strtTotalURL.append(url).append("?").append(getUrl(params, "US-ASCII"));
		} else {
			strtTotalURL.append(url).append("&").append(getUrl(params, "US-ASCII"));
		}
		System.out.println("url==" + strtTotalURL.toString());

		GetMethod getMethod = new GetMethod(strtTotalURL.toString());
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		getMethod.setRequestHeader(HttpHeaders.AUTHORIZATION, authHeader);
		getMethod.setRequestHeader("Content-Type", "application/json");

		// String transJson = params.toString();
		RequestEntity se = null;
		// String response = "";
		int statusCode = 0;
		StringBuffer stringBuffer = null;
		try {
			// se = new StringRequestEntity(transJson, "application/json",
			// "UTF-8");
			// getMethod.setRequestEntity(se);
			// 使用系统提供的默认的恢复策略
			getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
			// 设置超时的时间
			getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 5000000);
			// 执行postMethod
			statusCode = client.executeMethod(getMethod);
			response = getMethod.getResponseBodyAsStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(response));
			stringBuffer = new StringBuffer();
			String str = "";
			while ((str = br.readLine()) != null) {
				stringBuffer.append(str);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stringBuffer;

	}

	public static JSONObject pexipUrlpatch(String url, String username, String password, JsonObject params) {
		JSONObject resultJsonObject = null;
		JSONObject resultObj = null;
		@SuppressWarnings({ "deprecation", "resource" })
		// DefaultHttpClient httpClient = new DefaultHttpClient();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		System.out.println("url==" + url);
		HttpPatch httpPut = new HttpPatch(url);
		httpPut.setHeader("Content-type", "application/json");
		httpPut.setHeader("Charset", HTTP.UTF_8);
		httpPut.setHeader("Accept", "application/json");
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		httpPut.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		try {
			if (params != null) {
				StringEntity entity = new StringEntity(params.toString(), HTTP.UTF_8);
				httpPut.setEntity(entity);
			}
			HttpResponse response = httpClient.execute(httpPut);
			System.out.println(EntityUtils.toString(response.getEntity()));
			int statusCode = response.getStatusLine().getStatusCode();

			System.out.println("statusCode==" + statusCode);
			// resultObj = new
			// JSONObject(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultObj;

	}


	public static int pexipUrldel(String url, String username, String password) {
		JSONObject resultObj = null;
		@SuppressWarnings({ "deprecation", "resource" })
		// DefaultHttpClient httpClient = new DefaultHttpClient();
		CloseableHttpClient httpClient = HttpClients.createDefault();
		System.out.println("url==" + url);
		HttpDelete httpDel = new HttpDelete(url);
		httpDel.setHeader("Content-type", "application/json");
		httpDel.setHeader("Charset", HTTP.UTF_8);
		httpDel.setHeader("Accept", "application/json");
		String auth = username + ":" + password;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
		String authHeader = "Basic " + new String(encodedAuth);
		httpDel.setHeader(HttpHeaders.AUTHORIZATION, authHeader);
		int statusCode=0;
		try {
			// if (params != null) {
			// StringEntity entity = new StringEntity(params.toString(),
			// HTTP.UTF_8);
			// ((HttpResponse) httpDel).setEntity(entity);
			// }
			HttpResponse response = httpClient.execute(httpDel);
			// System.out.println(EntityUtils.toString(response.getEntity()));
			 statusCode = response.getStatusLine().getStatusCode();

			System.out.println("statusCode==" + statusCode);
			// resultObj = new
			// JSONObject(EntityUtils.toString(response.getEntity()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusCode;
	}

	// ============

	public static void main(String[] args) throws Exception {

		// 一分钟一条 十分钟三条 一天不可以超过五条
		// String url = "http://si.800617.com:4400/SendSms.aspx";
		// Map<String, String> hm = new HashMap<String, String>();
		// hm.put("un", "pbsdx-1");
		// hm.put("pwd", "4360ad");
		// hm.put("mobile", "18204318106");
		// hm.put("msg", "验证码：444666，在5分钟内有效，如非本人操作，请忽略本短信。【鹏云课堂】");
		// String responseParameter = HttpUtil.URLPost(url, hm,
		// HttpUtil.GB2312);
		// System.out.println(responseParameter+"~~~~~~~~~~~~~~~~");

		String url = "https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/conference/?limit=200&service_type=conference";
		String username = "pbs_zhjy_20";
		String password = "BJDXT_CDN?";

		String url2 = "https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/conference/1/";
		String url4 = "https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/conference_alias/13/";
		// /api/admin/configuration/v1/device/
		String url5 = "https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/device/";
		Map map = new HashMap();
		// map.put("name", "710018");
		map.put("username", "200002");

	JsonObject jsob = new JsonObject();
//		JsonArray jsonarr = new JsonArray();
//
//		JsonObject jsob1 = new JsonObject();
//		jsob1.addProperty("alias", "ttttttt");
//		 JsonObject jsob2 = new JsonObject();
//		 jsob2.addProperty("alias", "ddd");
//
//		 jsonarr.add(jsob1);
//		 jsonarr.add(jsob2);

		jsob.addProperty("name", "7200466");
		//
		// jsob.addProperty("service_type", "conference");
		//jsob.addProperty("allow_guests", "False");
		jsob.addProperty("allow_guests", "True");
		jsob.addProperty("pin", "444444");
	   jsob.addProperty("guest_pin", "");
		jsob.addProperty("participant_limit", "6");
		jsob.addProperty("description", "哈哈哈哈");
		jsob.addProperty("password", "234567");
		jsob.addProperty("alias", "tttt");
		
		JsonArray jsonarr = new JsonArray();

		JsonObject jsob1 = new JsonObject();
		jsob1.addProperty("name", "test.cloudp.cc");
		
		JsonObject jsob2 = new JsonObject();
		jsob2.addProperty("uuid", "6a713ab2-6131-448e-85ca-d9f4913f6860");
		JsonObject jsob3 = new JsonObject();
		jsob3.addProperty("id", "28");
		
		
		//jsob.addProperty("ivr_theme", "test");
		// one_main_zero_pips: 全屏主要发言者（单个语音切换布局）
		// one_main_seven_pips: 较大的主要发言者和最多 7 位其他与会者(1 + 7 布局)
		// one_main_twentyone_pips: 较小的主要发言者和最多 21 位其他与会者(1 + 21 布局)
		// jsob.addProperty("host_view", "one_main_twentyone_pips");

		// System.out.println(jsob.toString());
//		  HttpUtil.pexipUrlpost(url, username, password, jsob);
		 String response = HttpUtil.pexipUrlget(url, username, password);
		 System.out.println("conference=======" + response);
		//
		//
		//
		// JSONObject meetroomJSONObject = new JSONObject(response);
		// String jsarr = meetroomJSONObject.get("objects").toString();
		// System.out.println("jsarr=="+jsarr);
		//
		// JSONArray ja = new JSONArray(jsarr);
		// for(int i=0;i<ja.length();i++){
		// JSONObject job = ja.getJSONObject(i);
		// System.out.println("name=="+job.get("name"));
		// System.out.println("alias=="+job.get("aliases"));
		//
		// JSONArray jaa = new JSONArray(job.get("aliases").toString());
		// for(int j=0;j<jaa.length();j++){
		// JSONObject jobb = jaa.getJSONObject(j);
		// //System.out.println("jobb=="+jobb);
		// System.out.println("alias==="+jobb.get("alias"));
		// }
		// }

		 HttpUtil.pexipUrlpatch("https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/conference/28/",
		 username, password, jsob);

		///api/admin/configuration/v1/ivr_theme/ 
		 
		// 更新设备密码
		// HttpUtil.pexipUrlpatch("https://pexip-admin-test.cloudp.cc/api/admin/configuration/v1/device/2/",
		// username,
		// password, jsob);

	}

}
