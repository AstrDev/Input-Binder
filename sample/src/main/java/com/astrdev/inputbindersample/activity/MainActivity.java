package com.astrdev.inputbindersample.activity;

import com.astrdev.inputbindersample.BR;
import com.astrdev.inputbindersample.R;
import com.astrdev.inputbindersample.databinding.ActivityMainBinding;
import com.astrdev.inputbindersample.viewmodel.MainViewModel;

import cz.kinst.jakub.viewmodelbinding.ViewModelActivity;
import cz.kinst.jakub.viewmodelbinding.ViewModelBindingConfig;


public class MainActivity extends ViewModelActivity<ActivityMainBinding, MainViewModel> {


	@Override
	public ViewModelBindingConfig getViewModelBindingConfig() {
		return new ViewModelBindingConfig(R.layout.activity_main, MainViewModel.class, BR.viewModel);
	}
}
