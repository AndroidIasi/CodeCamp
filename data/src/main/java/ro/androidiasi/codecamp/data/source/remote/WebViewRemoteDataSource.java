package ro.androidiasi.codecamp.data.source.remote;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.lang.ref.WeakReference;

/**
 * Created by andrei on 21/04/16.
 */
@EBean
public class WebViewRemoteDataSource extends BaseRemoteDataSource {

    private static final String INDEX_HTML_PATH = "file:///android_asset/index.html";
    private static final String MIGHTY_JS_HACK = "javascript:android.onData(ko.toJSON(new ConferenceViewModel()))";

    @RootContext  Context mContext;

    private WeakReference<WebView> mWebViewWeakReference;

    @Override public void afterInject() {

    }

    @Override public String startCodecampJsonRequest() {
        if(mWebViewWeakReference.get() == null){
            WebView webView = new WebView(mContext);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBlockNetworkImage(true);
            webView.addJavascriptInterface(this, "android");
            webView.setWebViewClient(new WebViewClient(){
                @Override public void onPageFinished(WebView view, String url) {
                    if(mWebViewWeakReference.get() != null){
                        mWebViewWeakReference.get().loadUrl(MIGHTY_JS_HACK);
                    }
                }
            });
            this.mWebViewWeakReference = new WeakReference<>(webView);
        }
        this.mWebViewWeakReference.get().loadUrl(INDEX_HTML_PATH);
        return "";
    }

    @JavascriptInterface public void onData(String data){
        Log.d("DATA", data);
        this.onSuccess(data);
    }

}
