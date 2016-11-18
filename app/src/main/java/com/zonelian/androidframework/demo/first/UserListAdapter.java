package com.zonelian.androidframework.demo.first;

import com.zonelian.androidframework.demo.R;
import com.zonelian.framework.core.adapter.recycler.CommonRecyclerAdapter;
import com.zonelian.framework.core.adapter.recycler.RecyclerViewHolder;

/**
 * Created by kernel on 2016/11/17.
 * Email: 372786297@qq.com
 */

public class UserListAdapter extends CommonRecyclerAdapter<UserData> {

    public UserListAdapter() {
        super();
    }

    @Override
    public int getContentLayoutResId(int viewType) {
        return R.layout.item_user_list;
    }

    @Override
    public void onDataBindContentView(RecyclerViewHolder holder, UserData item) {
        holder.getTextView(R.id.tvName).setText(item.name);
    }
}
