package com.bawei.jiajianhai.expandablelistview20170308.activity;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.jiajianhai.expandablelistview20170308.R;
import com.bawei.jiajianhai.expandablelistview20170308.bean.Bean;
import com.bawei.jiajianhai.expandablelistview20170308.bean.DataBean;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshExpandableListView;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;

@ContentView(R.layout.activity_main)//类外
public class MainActivity extends AppCompatActivity {
    @ViewInject(R.id.ex_list)//方法外
            PullToRefreshExpandableListView ex_list;


    private ArrayList<String> lists=new ArrayList<>();
    private ArrayList<DataBean> listd=new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        //控件的初始化
        initView();

    }

    private void initView() {
        //控件的初始化
        x.view().inject(this);
        //进行刷新
        ex_list.setMode(PullToRefreshBase.Mode.BOTH);
        ex_list.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ExpandableListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                ex_list.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ex_list.onRefreshComplete();
                    }
                },2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ExpandableListView> refreshView) {
                ex_list.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ex_list.onRefreshComplete();
                    }
                },2000);
            }
        });

        //获得数据进行解析
        getData();

    }

    private void getData() {
      /*   String url="http://mock.eoapi.cn/success/syfu1B3lIcelZsjCD9Psw5sq7zfPMiTJ";
       // String url1="http://mock.eoapi.cn/success/rq7m6GNqurs93zYkEANkY8Z4358Aihf1";*/

        /*//设置请求的参数
        RequestParams params=new RequestParams(url);
        //设置缓存
       */
        String url = "https://mock.eolinker.com/success/rq7m6GNqurs93zYkEANkY8Z4358Aihf1";
        RequestParams params = new RequestParams(url);
        //  params.addQueryStringParameter("channelId", "0");
        // params.addQueryStringParameter("startNum", "0");
        params.setCacheMaxAge(1000*60);
        //发送请求
        x.http().get(params, new Callback.CacheCallback<String>() {
            private String result=null;
            @Override
            public void onSuccess(String result) {
                if(result!=null){
                    this.result=result;

                }

                Gson gson=new Gson();
                Bean bean = gson.fromJson(result, Bean.class);
                //设置适配器

                ArrayList<DataBean> list = (ArrayList<DataBean>) bean.getData();
                for(int i=0;i<list.size();i++){

                    DataBean dataBean = list.get(i);
                    lists.add(dataBean.getTitle());
                    listd.add(dataBean);

                }
                ex_list.getRefreshableView().setAdapter(new MyAdapter());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Toast.makeText(MainActivity.this, "错误了", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

            //缓存的方法
            @Override
            public boolean onCache(String result) {
                this.result=result;
                Toast.makeText(MainActivity.this, "这是缓存的", Toast.LENGTH_SHORT).show();

                return true;
            }
        });

    }
    private class MyAdapter implements ExpandableListAdapter{

        @Override
        public void registerDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public void unregisterDataSetObserver(DataSetObserver observer) {

        }

        @Override
        public int getGroupCount() {
            return lists.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return listd.get(groupPosition).getDatas().size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return listd.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return listd.get(groupPosition).getDatas().get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            ViewHolderP holder=null;
            if(convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.group_layout,null);
                holder=new ViewHolderP();
                holder.text= (TextView) convertView.findViewById(R.id.text_group_title);
                convertView.setTag(holder);
            }else{
                holder= (ViewHolderP) convertView.getTag();
            }
            holder.text.setText(lists.get(groupPosition));

            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            ViewHolderC holderc=null;
            if(convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.child_layout,null);
                holderc=new ViewHolderC();
                holderc.title= (TextView) convertView.findViewById(R.id.text_title);
                holderc.con= (TextView) convertView.findViewById(R.id.text_con);
                holderc.price= (TextView) convertView.findViewById(R.id.text_price);
                convertView.setTag(holderc);
            }else{
                holderc= (ViewHolderC) convertView.getTag();
            }
            holderc.title.setText(listd.get(groupPosition).getDatas().get(childPosition).getAdd_time());
            holderc.con.setText(listd.get(groupPosition).getDatas().get(childPosition).getType_name());
            holderc.price.setText("￥"+listd.get(groupPosition).getDatas().get(childPosition).getPrice()+"");
            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEmpty() {
            return true;
        }

        @Override
        public void onGroupExpanded(int groupPosition) {

        }

        @Override
        public void onGroupCollapsed(int groupPosition) {

        }

        @Override
        public long getCombinedChildId(long groupId, long childId) {
            return childId;
        }

        @Override
        public long getCombinedGroupId(long groupId) {
            return groupId;
        }
    }
    class ViewHolderP{
        TextView text;
    }
    class ViewHolderC{
        TextView title;
        TextView con;
        TextView price;
    }

}