package ro.androidiasi.codecamp.sponsors.item;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.androidannotations.annotations.EView;

/**
 * Created by andrei.
 */
@EView
public class SponsorItemView extends ImageView implements SponsorItemContract.View {

    private static final int WEBSITE_LOGO_WIDTH = 200;
    private static final int WEBSITE_LOGO_HEIGHT = 90;

    public SponsorItemView(Context context) {
        super(context);
    }

    public SponsorItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SponsorItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = WEBSITE_LOGO_HEIGHT * getMeasuredWidth() / WEBSITE_LOGO_WIDTH;
        setMeasuredDimension(getMeasuredWidth(), height);
    }

    @Override public void loadLogo(final String pLogoUrl) {
        Glide.with(getContext())
                .load(pLogoUrl)
                .fitCenter()
                .into(this);
    }
}
