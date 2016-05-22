package accountms.com.dell.accountms;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GridView gvInfo;
    private String[] titles = new String[]{"新增支出","新增收入","我的支出","我的收入","数据管理","系统管理","收支便签","退出",};
    private int[] images = new int[]{R.drawable.addoutaccount,R.drawable.addinaccount,R.drawable.outaccountinfo,R.drawable.inaccountinfo,
    R.drawable.showinfo,R.drawable.sysset,R.drawable.accountflag,R.drawable.exit};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        gvInfo = (GridView) findViewById(R.id.gvInfo);
        pictureAdapter adapter = new pictureAdapter(titles,images,this);
        gvInfo.setAdapter(adapter);
        gvInfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = null;
                switch (position){
                    case 0:
                        intent = new Intent(MainActivity.this,AddOutaccount.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(MainActivity.this,AddInaccount.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(MainActivity.this,Outaccountinfo.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(MainActivity.this,Inaccountinfo.class);
                        startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(MainActivity.this,Showinfo.class);
                        startActivity(intent);
                        break;
                    case 5:
                        intent = new Intent(MainActivity.this,Sysset.class);
                        startActivity(intent);
                        break;
                    case 6:
                        intent = new Intent(MainActivity.this,Accountflag.class);
                        startActivity(intent);
                        break;
                    case 7:
                        finish();
                }
            }
        });
    }

    class ViewHolder{
        public TextView title;
        private ImageView image;
    }

    class Picture{
        private String title;
        private int imageId;




        public Picture(String title,int imageId){
            super();
            this.title = title;
            this.imageId = imageId;
        }


        public int getImageId() {
            return imageId;
        }

        public void setImageId(int imageId) {
            this.imageId = imageId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Picture(){
            super();
        }

    }

    class pictureAdapter extends BaseAdapter{
        private LayoutInflater inflater;
        private List<Picture> pictures;

        public pictureAdapter(String[] titles, int[] images, Context context){
            super();
            pictures = new ArrayList<Picture>();
            inflater = LayoutInflater.from(context);
            for (int i =0;i<images.length;i++){
                Picture picture = new Picture(titles[i],images[i]);
                pictures.add(picture);
            }
        }

        @Override
        public int getCount() {
            if (null!= pictures){
                return pictures.size();
            }
            else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            return pictures.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null){
                convertView = inflater.inflate(R.layout.gvitem,null);
                viewHolder=new ViewHolder();
                viewHolder.title = (TextView) convertView.findViewById(R.id.ItemTitle);
                viewHolder.image = (ImageView) convertView.findViewById(R.id.ItemImage);
                convertView.setTag(viewHolder);
            }else {
//                convertView = inflater.inflate(R.layout.gvitem,null);
//                viewHolder=new ViewHolder();
//                viewHolder.title = (TextView) convertView.findViewById(R.id.ItemTitle);
//                viewHolder.image = (ImageView) convertView.findViewById(R.id.ItemImage);
//                convertView.setTag(viewHolder);
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.title.setText(pictures.get(position).getTitle());
            viewHolder.image.setImageResource(pictures.get(position).getImageId());
            return convertView;
        }
    }
}
