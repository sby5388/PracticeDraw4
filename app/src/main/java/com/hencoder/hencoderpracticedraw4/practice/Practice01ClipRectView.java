package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice01ClipRectView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    private RectF mRectF = new RectF();

    public Practice01ClipRectView(Context context) {
        super(context);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01ClipRectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //保存Canvas当前的状态
        canvas.save();


        int left = (getWidth() - bitmap.getWidth()) / 2;
        int top = (getHeight() - bitmap.getHeight()) / 2;
        mRectF.left = left + 50;
        mRectF.top = top + 50;
        mRectF.right = getWidth() - left - 100;
        mRectF.bottom = getHeight() - top - 100;
        // TODO: 2020/1/12 范围裁切有两个方法： clipRect() 和 clipPath()。
        //  裁切方法之后的绘制代码，都会被限制在裁切范围内。
        canvas.clipRect(mRectF);
        canvas.drawBitmap(bitmap, left, top, paint);
        //恢复Canvas 之前保存的状态
        canvas.restore();
    }
}
