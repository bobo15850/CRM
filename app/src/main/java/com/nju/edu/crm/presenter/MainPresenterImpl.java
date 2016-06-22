package com.nju.edu.crm.presenter;

import com.nju.edu.crm.view.iview.IMainView;

/**
 * Created by 张波波 on 2016-06-20.
 */
public class MainPresenterImpl implements IMainPresenter {
    //界面的操作
    private IMainView mainView;

    public MainPresenterImpl(IMainView iMainView) {
        this.mainView = iMainView;
    }

    @Override
    public void toCustomer() {
        mainView.toCustomer();
    }

    @Override
    public void toOpportunity() {
        mainView.toOpportunity();
    }

    @Override
    public void toContract() {
        mainView.toContract();
    }

    @Override
    public void toContact() {
        mainView.toContact();
    }

    @Override
    public void toProduct() {
        mainView.toProduct();
    }
}
