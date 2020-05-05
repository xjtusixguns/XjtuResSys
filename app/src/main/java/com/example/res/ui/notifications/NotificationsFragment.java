package com.example.res.ui.notifications;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.res.MyApplication;
import com.example.res.MyDatabaseHelper;
import com.example.res.R;
import com.example.res.User;

public class NotificationsFragment extends Fragment {
    FragmentManager fm;
    FragmentTransaction transaction;

    private View view;
    private EditText et_username;
    private EditText et_password;
    private Button bt_log;
    private Button bt_bos;
    private SQLiteDatabase db;
    private MyDatabaseHelper helper;

    MyApplication application;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        helper = new MyDatabaseHelper(getActivity(), "User.db", null, 2);
        this.application = (MyApplication) this.getActivity().getApplicationContext();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_notifications, container, false);
        et_username = view.findViewById(R.id.et_username);
        et_password = view.findViewById(R.id.et_password);
        bt_log = view.findViewById(R.id.bt_log);
        bt_bos = view.findViewById(R.id.bt_bos);

        return view;
    }

    private void replaceFragment(Fragment fragment) {
        this.fm = getChildFragmentManager();
        this.transaction = fm.beginTransaction();
//        this.transaction.addToBackStack(null);
//        transaction.add(fragment, "User");
//        transaction.show(fragment);
//        FragmentManager fmself = getFragmentManager();
//        Fragment a = fmself.findFragmentById(R.id.navigation_notifications);
//        fmself.beginTransaction().hide(a);
        transaction.add(R.id.replaceFragment, fragment).show(fragment);
//        transaction.replace(R.id.replaceFragment, fragment);
        transaction.commit();
    }

    @Override
    public void onStart() {
        super.onStart();
        if (bt_log != null)
            bt_log.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //获取用户输入的数据
                    String strUsername = et_username.getText().toString();
                    String strPassword = et_password.getText().toString();
                    String PWD = "";
                    int UserId = 0;
                    db = helper.getWritableDatabase();
                    Cursor cursor = db.rawQuery("select id, UserPWD from User where UserName=?", new String[]{strUsername});
                    if (cursor.moveToFirst()) {
                        do {
                            UserId = cursor.getInt(cursor.getColumnIndex("id"));
                            PWD = cursor.getString(cursor.getColumnIndex("UserPWD"));
                        } while (cursor.moveToNext());
                    }
                    //判断用户名和密码是否正确（为可以进行测试，将用户名和密码都定义为admin
                    if (strPassword.equals(PWD)) {
                        application.LogIn();
                        application.setUserUsing(UserId);
                        Toast.makeText(getContext(), "用户名和密码正确！", Toast.LENGTH_SHORT).show();
                        onResume();
//                        replaceFragment(new OrdersFragment());
                    } else {
                        Toast.makeText(getContext(), "用户名或密码错误！", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        //给取消按钮注册监听器，实现监听器接口，编写事件
        if (bt_bos != null)
            bt_bos.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    db = helper.getWritableDatabase();
                    //获取用户输入的数据
                    String strUsername = et_username.getText().toString();
                    String strPassword = et_password.getText().toString();

                    ContentValues values = new ContentValues();
                    values.put("UserName", strUsername);
                    values.put("UserPWD", strPassword);
                    db.insert("User", null, values);

                }
            });
    }

    @Override
    public void onResume() {
        super.onResume();
        if (this.application.logIn == 1) {
            replaceFragment(new OrdersFragment());
        }
    }
}
