/*******************************************************************************
 * The MIT License (MIT)
 * 
 * Copyright (c) 2013 Triggertrap Ltd
 * Author Neil Davies
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 ******************************************************************************/
package com.triggertrap.sample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.triggertrap.seekarc.CircularSelector;
import com.triggertrap.seekarc.CircularSelector.OnSeekArcChangeListener;

/**
 * 
 * SimpleActivity.java
 * @author Neil Davies
 * 
 */
public class SimpleActivity extends Activity {

	private CircularSelector mCircularSelector;
	private SeekBar mRotation;
	private SeekBar mStartAngle;
	private SeekBar mSweepAngle;
	private SeekBar mArcWidth;
	private SeekBar mProgressWidth;
	private CheckBox mRoundedEdges;
	private CheckBox mTouchInside;
	private CheckBox mClockwise;
	private TextView mSeekArcProgress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.holo_sample);
		
		mCircularSelector = (CircularSelector) findViewById(R.id.seekArc);
		mSeekArcProgress = (TextView) findViewById(R.id.seekArcProgress);
		mRotation = (SeekBar) findViewById(R.id.rotation);
		mStartAngle = (SeekBar) findViewById(R.id.startAngle);
		mSweepAngle  = (SeekBar) findViewById(R.id.sweepAngle);
		mArcWidth = (SeekBar) findViewById(R.id.arcWidth);
		mProgressWidth = (SeekBar) findViewById(R.id.progressWidth);
		mRoundedEdges = (CheckBox) findViewById(R.id.roundedEdges);
		mTouchInside = (CheckBox) findViewById(R.id.touchInside);
		mClockwise = (CheckBox) findViewById(R.id.clockwise);
		
		mRotation.setProgress(mCircularSelector.getArcRotation());
		mStartAngle.setProgress(mCircularSelector.getStartAngle());
		mSweepAngle.setProgress(mCircularSelector.getSweepAngle());
		mArcWidth.setProgress(mCircularSelector.getArcWidth());
		mProgressWidth.setProgress(mCircularSelector.getProgressWidth());
		
		mCircularSelector.setOnSeekArcChangeListener(new OnSeekArcChangeListener() {
			
			@Override
			public void onStopTrackingTouch(CircularSelector circularSelector) {
			}		
			@Override
			public void onStartTrackingTouch(CircularSelector circularSelector) {
			}
			
			@Override
			public void onProgressChanged(CircularSelector circularSelector, int progress,
					boolean fromUser) {
				mSeekArcProgress.setText(String.valueOf(progress));
			}
		});
			
		mRotation.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {

			}		
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {		
			}
			
			@Override
			public void onProgressChanged(SeekBar view, int progress, boolean fromUser) {
				mCircularSelector.setArcRotation(progress);
				mCircularSelector.invalidate();
			}
		});
		
		mStartAngle.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {

			}		
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {		
			}
			
			@Override
			public void onProgressChanged(SeekBar view, int progress, boolean fromUser) {
				mCircularSelector.setStartAngle(progress);
				mCircularSelector.invalidate();
			}
		});
		
		mSweepAngle.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {

			}		
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {		
			}
			
			@Override
			public void onProgressChanged(SeekBar view, int progress, boolean fromUser) {
				mCircularSelector.setSweepAngle(progress);
				mCircularSelector.invalidate();
			}
		});
			
		mArcWidth.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {

			}		
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {		
			}
			
			@Override
			public void onProgressChanged(SeekBar view, int progress, boolean fromUser) {
				mCircularSelector.setArcWidth(progress);
				mCircularSelector.invalidate();
			}
		});
		
		mProgressWidth.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {
			@Override
			public void onStopTrackingTouch(SeekBar arg0) {

			}		
			@Override
			public void onStartTrackingTouch(SeekBar arg0) {		
			}
			
			@Override
			public void onProgressChanged(SeekBar view, int progress, boolean fromUser) {
				mCircularSelector.setProgressWidth(progress);
				mCircularSelector.invalidate();
			}
		});
		
		mRoundedEdges.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			   @Override
			   public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				   mCircularSelector.setRoundedEdges(isChecked);
				   mCircularSelector.invalidate();
			   }
		});
		
		mTouchInside.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			   @Override
			   public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				   mCircularSelector.setTouchInSide(isChecked);
			   }
		});
		
		mClockwise.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			   @Override
			   public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
				   mCircularSelector.setClockwise(isChecked);
				   mCircularSelector.invalidate();
			   }
		});
		
	}
	
}
