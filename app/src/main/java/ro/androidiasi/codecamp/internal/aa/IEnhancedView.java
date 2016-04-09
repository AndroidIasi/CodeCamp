package ro.androidiasi.codecamp.internal.aa;

/**
 * Created by andrei on 08/04/16.
 */
public interface IEnhancedView {

    void afterMembersInject();
    void afterViewsInject();

    void afterInject();
    void afterViews();

}
