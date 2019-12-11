package com.thescar.mvp.ui.fragment;

import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.blankj.utilcode.util.LogUtils;
import com.thescar.mvp.R;
import com.thescar.mvp.base.MainBaseView;
import com.thescar.mvp.base.MvpBaseFragment;
import com.thescar.mvp.model.JokeModel;
import com.thescar.mvp.presenter.MainPresenter;

import butterknife.BindView;

import static com.qmuiteam.qmui.widget.dialog.QMUITipDialog.Builder.ICON_TYPE_FAIL;

/**
 * @Author :TheScar
 * @Date :2019/12/10 13:22
 * @Email :han_shuaishuai@126.com
 * @Description : MessageFragment
 */
public class JokeFragment extends MvpBaseFragment<MainPresenter> implements MainBaseView<JokeModel> {
    @BindView(R.id.text_joke)
    TextView mTextJoker;
    @BindView(R.id.btn_reset_joke)
    Button mBtnResetJoker;

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    protected void onFragmentFirstVisible() {
        mTextJoker.setMovementMethod(ScrollingMovementMethod.getInstance());
        LogUtils.d("Fragment", "MessageFragment---onFragmentFirstVisible");
    }

    @Override
    protected void onFragmentResume() {
        LogUtils.d("Fragment", "MessageFragment---onFragmentResume");
        mvpPresenter.getJoke();
        mBtnResetJoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mvpPresenter.getJoke();
            }
        });
    }

    @Override
    protected void onFragmentPause() {
        LogUtils.d("Fragment", "MessageFragment---onFragmentPause");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_message;
    }

    @Override
    public void getDataSuccess(JokeModel model) {
        String joke = model.getResult().get(0).getContent();
        mTextJoker.setText(joke);
    }

    @Override
    public void getDataFail(String msg) {
        showProgressDialog(ICON_TYPE_FAIL, msg);
    }
}
