package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice08MatrixScaleView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    Matrix mMatrix = new Matrix();

    public Practice08MatrixScaleView(Context context) {
        super(context);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice08MatrixScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final int width = bitmap.getWidth();
        final int height = bitmap.getHeight();

        // TODO: 2020/1/12  
        canvas.save();
        mMatrix.reset();
        mMatrix.postScale(1.3f, 1.3f, point1.x + width / 2, point1.y + height / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();
        
        canvas.save();
        mMatrix.reset();
        mMatrix.postScale(0.5f, 2f, point2.x + width / 2, point2.y + height / 2);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
