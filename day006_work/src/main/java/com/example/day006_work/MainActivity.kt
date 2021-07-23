package com.example.day006_work

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.test7_21.MyToobar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

//    var str:Array<String> = arrayOf("飞狐外传","雪山飞狐","连城决","天龙八部","射雕英雄传","白马啸西风","鹿鼎记","笑傲江湖","书剑恩仇录","神雕侠侣",
//        "倚天屠龙记","碧血剑","鸳鸯刀","疯狂JAVA讲义","第一行代码","安卓艺术鉴赏","安卓群英传",
//        "三国演义","水浒传","红楼梦","西游记")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            btn.am()
        }

        mytoolbar.setOnToolbarclickListener(object : MyToobar.LeftButtonListener {
            override fun LeftBtnOnclick() {
                val builder = Notification.Builder(this@MainActivity)
                builder.setSmallIcon(R.mipmap.ic_launcher)
                builder.setContentTitle("自定Bar通知")
                builder.setContentText("大图通知")

                var big:Notification.BigPictureStyle = Notification.BigPictureStyle()
                big.bigPicture(BitmapFactory.decodeResource(resources,R.drawable.wallhaven832el2))
                builder.setStyle(big)

                val build = builder.build()
                val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(1, build)
            }
        })
    }
}
