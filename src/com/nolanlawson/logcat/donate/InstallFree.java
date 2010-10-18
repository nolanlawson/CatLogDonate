package com.nolanlawson.logcat.donate;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;

public class InstallFree extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		final boolean installed = Helper.isCatlogFreeInstalled(this);
		AlertDialog.Builder builder = new Builder(this);
		builder.setTitle(R.string.app_name);
		builder.setCancelable(false);
		builder.setPositiveButton(android.R.string.ok, new OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				if (installed) {
					Intent i = new Intent();
					i.setClassName("com.nolanlawson.logcat", "com.nolanlawson.logcat.LogcatActivity");
					i.setAction(Intent.ACTION_MAIN);
					startActivity(i);
				}
				finish();
			}
		});
		if (installed) {
			Helper.setCatlogDonateIcon(this, false);
			builder.setMessage(R.string.thanks);
		}
		else {
			builder.setMessage(R.string.install_free_text);
		}
		builder.create().show();
	}
}
