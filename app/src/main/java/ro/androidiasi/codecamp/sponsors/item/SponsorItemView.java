package ro.androidiasi.codecamp.sponsors.item;

import android.content.Context;
import android.net.Uri;
import android.util.AttributeSet;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EView;

/**
 * Created by andrei.
 */
@EView
public class SponsorItemView extends SimpleDraweeView implements SponsorItemContract.View{

    private static final int WEBSITE_LOGO_WIDTH = 200;
    private static final int WEBSITE_LOGO_HEIGHT = 90;

    public SponsorItemView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public SponsorItemView(Context context) {
        super(context);
    }

    public SponsorItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SponsorItemView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SponsorItemView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
    
    @AfterInject void afterMembersInject(){
        GenericDraweeHierarchy hierarchy = getHierarchy();
        hierarchy.setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
    }

    @Override protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = WEBSITE_LOGO_HEIGHT * getMeasuredWidth() / WEBSITE_LOGO_WIDTH;
        setMeasuredDimension(getMeasuredWidth(), height);
    }

    @Override public void loadLogo(final String pLogoUrl) {
        setImageURI(Uri.parse(pLogoUrl));
    }
}
