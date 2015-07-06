package com.example.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends FragmentActivity implements OnClickListener {
   //这是版本222
	private LinearLayout tab1;
	private LinearLayout tab2;
	private LinearLayout tab3;
	private LinearLayout tab4;

	private ImageButton img1;
	private ImageButton img2;
	private ImageButton img3;
	private ImageButton img4;

	private Fragment mTab1;
	private Fragment mTab2;
	private Fragment mTab3;
	private Fragment mTab4;

	private TextView tv1;
	private TextView tv2;
	private TextView tv3;
	private TextView tv4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		init();
		setSelet(1);
	}

	private void init() {
		tab1 = (LinearLayout) findViewById(R.id.tab1);
		tab2 = (LinearLayout) findViewById(R.id.tab2);
		tab3 = (LinearLayout) findViewById(R.id.tab3);
		tab4 = (LinearLayout) findViewById(R.id.tab4);

		img1 = (ImageButton) findViewById(R.id.img1);
		img2 = (ImageButton) findViewById(R.id.img2);
		img3 = (ImageButton) findViewById(R.id.img3);
		img4 = (ImageButton) findViewById(R.id.img4);

		tab1.setOnClickListener(this);
		tab2.setOnClickListener(this);
		tab3.setOnClickListener(this);
		tab4.setOnClickListener(this);

		tv1 = (TextView) findViewById(R.id.tv1);
		tv2 = (TextView) findViewById(R.id.tv2);
		tv3 = (TextView) findViewById(R.id.tv3);
		tv4 = (TextView) findViewById(R.id.tv4);

	}

	/**
	 * 把图片、文字换成亮色，切换内容22222
	 */
	private void setSelet(int i) {

		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction transaction = fm.beginTransaction();
		hideFragment(transaction);

		switch (i) {
		case 1:
			if (mTab1 == null) {
				mTab1 = new Tab1();
				transaction.add(R.id.content, mTab1);
			} else {
				transaction.show(mTab1);
			}
			img1.setImageResource(R.drawable.b1);
			tv1.setTextColor(getResources().getColor(R.color.press));
			break;
			
		case 2:
			if (mTab2 == null) {
				mTab2 = new Tab2();
				transaction.add(R.id.content, mTab2);
			} else {
				transaction.show(mTab2);
			}
			img2.setImageResource(R.drawable.b2);
			tv2.setTextColor(getResources().getColor(R.color.press));
			break;
			
		case 3:
			if (mTab3 == null) {
				mTab3 = new Tab3();
				transaction.add(R.id.content, mTab3);
			} else {
				transaction.show(mTab3);
			}
			img3.setImageResource(R.drawable.b3);
			tv3.setTextColor(getResources().getColor(R.color.press));
			break;
			
		case 4:
			if (mTab4 == null) {
				mTab4 = new Tab4();
				transaction.add(R.id.content, mTab4);
			} else {
				transaction.show(mTab4);
			}
			img4.setImageResource(R.drawable.b4);
			tv4.setTextColor(getResources().getColor(R.color.press));
			break;

		default:
			break;
		}
		transaction.commit();
	}

	private void hideFragment(FragmentTransaction transaction) {
		if (mTab1 != null) {
			transaction.hide(mTab1);
		}
		if (mTab2 != null) {
			transaction.hide(mTab2);
		}
		if (mTab3 != null) {
			transaction.hide(mTab3);
		}
		if (mTab4 != null) {
			transaction.hide(mTab4);
		}
	}

	@Override
	public void onClick(View v) {
		resetImage();
		switch (v.getId()) {
		case R.id.tab1:
			setSelet(1);
			break;
		case R.id.tab2:
			setSelet(2);
			break;
		case R.id.tab3:
			setSelet(3);
			break;
		case R.id.tab4:
			setSelet(4);
			break;

		}
	}

	/**
	 * 重置图片，把所有图片、文字换成暗色
	 * 
	 */

	private void resetImage() {
		img1.setImageResource(R.drawable.a1);
		img2.setImageResource(R.drawable.a2);
		img3.setImageResource(R.drawable.a3);
		img4.setImageResource(R.drawable.a4);

		tv1.setTextColor(getResources().getColor(R.color.normal));
		tv2.setTextColor(getResources().getColor(R.color.normal));
		tv3.setTextColor(getResources().getColor(R.color.normal));
		tv4.setTextColor(getResources().getColor(R.color.normal));

	}

}
