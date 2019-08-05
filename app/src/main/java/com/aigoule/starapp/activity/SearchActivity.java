package com.aigoule.starapp.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.aigoule.starapp.R;
import com.aigoule.starapp.adapter.SearchAdapter;
import com.aigoule.starapp.api.HttpCallback;
import com.aigoule.starapp.api.HttpRequest;
import com.aigoule.starapp.base.BaseActivity;
import com.aigoule.starapp.model.SearchModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.iv_backs)
    ImageView ivBacks;
    @BindView(R.id.iv_new_video)
    ImageView ivNewVideo;
    @BindView(R.id.tv_title_newvideo)
    TextView tvTitleNewvideo;
    @BindView(R.id.editext_videos)
    EditText editextVideos;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.lv_video)
    ListView lvVideo;
    @BindView(R.id.tv_search)
    TextView tvSearch;
    private String text_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        text_video=getIntent().getStringExtra("search_id");
        search(text_video);
    }


    private void search(String wd) {
        HttpRequest.getInstance().search(SearchActivity.this, wd, new HttpCallback<SearchModel>() {
            @Override
            public void onSuccess(SearchModel data) {
                if (data.getData().size()==0){
                    tvSearch.setText("未搜索到与"+wd+"相关的视频");
                    lvVideo.setVisibility(View.GONE);
                }else{
                    tvSearch.setText("搜索到与"+wd+"相关的视频");
                    lvVideo.setVisibility(View.VISIBLE);
                    SearchAdapter adapter = new SearchAdapter(SearchActivity.this, data.getData());
                    lvVideo.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }

                hideSoftKeyboard(SearchActivity.this,editextVideos);
            }

            @Override
            public void onFailure(int msgCode, String errorMsg) {
                Toast.makeText(SearchActivity.this, errorMsg, Toast.LENGTH_SHORT).show();
                hideSoftKeyboard(SearchActivity.this,editextVideos);
            }
        });
    }


    @OnClick({R.id.iv_backs, R.id.iv_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.iv_backs:
                finish();
                break;
            case R.id.iv_search:
                search(editextVideos.getText().toString().replace(" ", ""));
                break;
        }
    }

    /**
     * 隐藏软键盘(有输入框)
     * @param context
     * @param mEditText
     */
    public static void hideSoftKeyboard(@NonNull Context context, @NonNull EditText mEditText) {
        InputMethodManager inputmanger = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputmanger.hideSoftInputFromWindow(mEditText.getWindowToken(), 0);
    }
}
