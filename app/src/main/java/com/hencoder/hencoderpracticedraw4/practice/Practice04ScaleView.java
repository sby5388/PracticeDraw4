package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hencoder.hencoderpracticedraw4.R;

/**
 * Scale：缩放
 */
public class Practice04ScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice04ScaleView(Context context) {
        super(context);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice04ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();

        canvas.save();
        // TODO: 2020/1/12
        //sx:横向放大倍数
        //sy：垂直放大倍数
        //px,py :放大的原点
        canvas.scale(1.3f, 1.3f, point1.x - 200, point1.y);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        canvas.save();
        // TODO: 2020/1/12
        canvas.scale(0.5f, 2f, point2.x + 200, point2.y);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
