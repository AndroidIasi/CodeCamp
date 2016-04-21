package ro.androidiasi.codecamp.data.source.remote;

import android.content.Context;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import java.lang.ref.WeakReference;

import ro.androidiasi.codecamp.data.source.remote.exception.DataUnavailable;

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

    @UiThread
    @Override public void startCodecampJsonRequest() {
        if (mWebViewWeakReference == null || mWebViewWeakReference.get() == null) {
            WebView webView = new WebView(mContext);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.getSettings().setBlockNetworkImage(true);
            webView.addJavascriptInterface(this, "android");
            webView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
            webView.setWebViewClient(new WebViewClient() {
                @Override public void onPageFinished(WebView view, String url) {
                    if (mWebViewWeakReference.get() != null) {
                        mWebViewWeakReference.get().loadUrl(MIGHTY_JS_HACK);
                    }
                }

                @Override public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                    onFailure(new DataUnavailable());
                }

                @Override public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
                    onFailure(new DataUnavailable());
                }
            });
            this.mWebViewWeakReference = new WeakReference<>(webView);
        }
        this.mWebViewWeakReference.get().loadUrl(INDEX_HTML_PATH);
    }

    @JavascriptInterface public void onData(String data){
        Log.d("DATA", data);
        this.onSuccess(data);
    }

}
