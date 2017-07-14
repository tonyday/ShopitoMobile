package com.example.tonyday.shopitomobile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.basecamp.turbolinks.TurbolinksAdapter;
import com.basecamp.turbolinks.TurbolinksSession;
import com.basecamp.turbolinks.TurbolinksView;

public class MainActivity extends AppCompatActivity implements TurbolinksAdapter {
    private static final String BASE_URL = "http://192.168.1.66:3000";
    private static final String INTENT_URL = "intentUrl";

    private String location;
    private TurbolinksView turbolinksView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("tonyTag", "onCreate00");
        super.onCreate(savedInstanceState);
        Log.d("tonyTag", "onCreate01");
        setContentView(R.layout.activity_main);
        Log.d("tonyTag", "onCreate02");


        // Find the custom TurbolinksView object in your layout
        turbolinksView = (TurbolinksView) findViewById(R.id.turbolinks_view);
        Log.d("tonyTag", "onCreate03");

        // For this demo app, we force debug logging on. You will only want to do
        // this for debug builds of your app (it is off by default)
        TurbolinksSession.getDefault(this).setDebugLoggingEnabled(true);
        Log.d("tonyTag", "onCreate04");
        TurbolinksSession
                .getDefault(this)
                .getWebView()
                .setWebChromeClient(new MyWebChromeClient(this));
        Log.d("tonyTag", "onCreate05");

        // For this example we set a default location, unless one is passed in through an intent
        location = getIntent().getStringExtra(INTENT_URL) != null ? getIntent().getStringExtra(INTENT_URL) : BASE_URL;
        Log.d("tonyTag", "onCreate06");

        // Execute the visit
        TurbolinksSession.getDefault(this)
                .activity(this)
                .adapter(this)
                .view(turbolinksView)
                .visit(location);
        Log.d("tonyTag", "onCreate07");
    }

    @Override
    protected void onRestart() {
        Log.d("tonyTag", "onRestart");
        super.onRestart();

        // Since the webView is shared between activities, we need to tell Turbolinks
        // to load the location from the previous activity upon restarting
        TurbolinksSession.getDefault(this)
                .activity(this)
                .adapter(this)
                .restoreWithCachedSnapshot(true)
                .view(turbolinksView)
                .visit(location);
    }

    @Override
    public void onPageFinished() {
        Log.d("tonyTag", "onPageFinished");

    }

    @Override
    public void onReceivedError(int errorCode) {
        Log.d("tonyTag", "onReceivedError");
        handleError(errorCode);
    }

    @Override
    public void pageInvalidated() {
        Log.d("tonyTag", "pageInvalidated");

    }

    @Override
    public void requestFailedWithStatusCode(int statusCode) {
        Log.d("tonyTag", "requestFailedWithStatusCode");

    }

    @Override
    public void visitCompleted() {
        Log.d("tonyTag", "visitCompleted");

    }

    // The starting point for any href clicked inside a Turbolinks enabled site. In a simple case
    // you can just open another activity, or in more complex cases, this would be a good spot for
    // routing logic to take you to the right place within your app.
    @Override
    public void visitProposedToLocationWithAction(String location, String action) {
        Log.d("tonyTag", "visitProposedToLocationWithAction");

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(INTENT_URL, location);

        this.startActivity(intent);
    }

    private void handleError(int code) {
        if (code == 404) {
            TurbolinksSession.getDefault(this)
                    .activity(this)
                    .adapter(this)
                    .restoreWithCachedSnapshot(false)
                    .view(turbolinksView)
                    .visit(BASE_URL + "/error");
        }
    }
}
