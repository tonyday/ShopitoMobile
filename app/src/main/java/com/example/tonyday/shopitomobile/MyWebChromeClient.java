package com.example.tonyday.shopitomobile;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

class MyWebChromeClient extends WebChromeClient {

    private Context _context;


    public MyWebChromeClient(Context context) {
        super();
        _context = context;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        Log.d("tonyTag", "onJsAlert00");
        //handle Alert event, here we are showing AlertDialog
        new AlertDialog.Builder(_context)
                .setTitle("Alert dialog created in java")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsAlert01");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.confirm();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsAlert02");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.cancel();
                            }
                        })
                .setCancelable(false)
                .create()
                .show();
        return true;
    }

    @Override
    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        Log.d("tonyTag", "onJsConfirm00");
        //handle Confirm event, here we are showing AlertDialog
        new AlertDialog.Builder(_context)
                .setTitle("Confirm dialog created in java")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsConfirm01");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.confirm();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsConfirm02");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.cancel();
                            }
                        })
                .setCancelable(false)
                .create()
                .show();
        return true;
    }

    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
        Log.d("tonyTag", "onJsPrompt00");
        //handle Prompt event, here we are showing AlertDialog
        new AlertDialog.Builder(_context)
                .setTitle("Prompt dialog created in java")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsPrompt01");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.confirm();
                            }
                        })
                .setNegativeButton(android.R.string.cancel,
                        new AlertDialog.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("tonyTag", "onJsPrompt02");
                                Log.d("tonyTag", String.valueOf(which));
                                // do your stuff
                                result.cancel();
                            }
                        })
                .setCancelable(false)
                .create()
                .show();
        return true;
    }
}
