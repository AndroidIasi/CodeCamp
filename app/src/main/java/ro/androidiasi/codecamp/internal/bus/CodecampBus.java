package ro.androidiasi.codecamp.internal.bus;

import org.androidannotations.annotations.EBean;
import org.greenrobot.eventbus.EventBus;

/**
 * Created by andrei on 19/04/16.
 */
@EBean(scope = EBean.Scope.Singleton)
public class CodecampBus extends EventBus {

}
