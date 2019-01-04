package hoangit.dev.g1.com.eduonline.view;

import android.content.Context;
import android.graphics.*;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import hoangit.dev.g1.com.eduonline.R;

public class RecycleViewCustom extends RecyclerView {

    private String msg;
    private float x, y;
    private float xStr;
    private Bitmap icEmpty;
    private Paint paint;

    public RecycleViewCustom(@NonNull Context context) {
        super(context);
        init();
    }

    public RecycleViewCustom(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RecycleViewCustom(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        msg = getResources().getString(R.string.no_data);
        paint = new Paint();
        paint.setTextSize(getContext().getResources().getDimension(R.dimen.dimen_14));
        paint.setColor(getContext().getResources().getColor(R.color.grey));
        paint.setAntiAlias(true);

        Rect recStr = new Rect();
        paint.getTextBounds(msg, 0, msg.length(), recStr);

        x = getResources().getDisplayMetrics().widthPixels;
        y = getResources().getDisplayMetrics().heightPixels;
        icEmpty = getBitmapFromVectorDrawable(getContext(), R.drawable.ic_empty);
        xStr = (x - recStr.width()) / 2;

        x = (x - icEmpty.getWidth()) / 2;
        y = (y - icEmpty.getHeight()) / 3;

    }

    @Override
    public void onDraw(Canvas c) {
        super.onDraw(c);
        if (getChildCount() == 0) {
            c.drawBitmap(icEmpty, x, y, null);
            c.drawText(msg, xStr, y + icEmpty.getHeight() + 50, paint);
        }
    }


    public static Bitmap getBitmapFromVectorDrawable(Context context, int drawableId) {
        Drawable drawable = ContextCompat.getDrawable(context, drawableId);
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            drawable = (DrawableCompat.wrap(drawable)).mutate();
        }

        Bitmap bitmap = Bitmap.createBitmap(256,
                256, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, 256, 256);
        drawable.draw(canvas);

        return bitmap;
    }

}
