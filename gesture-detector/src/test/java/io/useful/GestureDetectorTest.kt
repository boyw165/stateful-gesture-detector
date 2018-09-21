package io.useful

import android.os.Looper
import android.view.MotionEvent
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(manifest = Config.NONE)
@RunWith(RobolectricTestRunner::class)
class GestureDetectorTest : BaseMockAndroidTest() {

    private lateinit var mockLifecycleListener: IGestureLifecycleListener
    private lateinit var mockTapListener: ITapGestureListener
    private lateinit var mockDragListener: IDragGestureListener
    private lateinit var mockPinchListener: IPinchGestureListener

    private lateinit var gestureDetector: GestureDetector

    @Before
    fun setup() {
        mockLifecycleListener = Mockito.mock(IGestureLifecycleListener::class.java)
        mockTapListener = Mockito.mock(ITapGestureListener::class.java)
        mockDragListener = Mockito.mock(IDragGestureListener::class.java)
        mockPinchListener = Mockito.mock(IPinchGestureListener::class.java)

        gestureDetector = GestureDetector(uiLooper = Looper.getMainLooper(),
                                          viewConfig = mockViewConfiguration,
                                          touchSlop = SCALED_TOUCH_SLOP.toFloat(),
                                          tapSlop = SCALED_TAP_SLOP.toFloat(),
                                          minFlingVec = SCALED_MIN_FLING_VELOCITY.toFloat(),
                                          maxFlingVec = SCALED_MAX_FLING_VELOCITY.toFloat())
    }

    @Test
    fun `lifecycle test`() {
        gestureDetector.addLifecycleListener(mockLifecycleListener)

        // obtain arguments: downTime: Long,
        //                   eventTime: Long,
        //                   action: Int,
        //                   x: Float,
        //                   y: Float,
        //                   metaState: Int
        gestureDetector.onTouchEvent(MotionEvent.obtain(0L, 0L, MotionEvent.ACTION_DOWN, 0f, 0f, 0), null, null)
        gestureDetector.onTouchEvent(MotionEvent.obtain(0L, 1L, MotionEvent.ACTION_UP, 0f, 0f, 0), null, null)

        Mockito.verify(mockLifecycleListener, Mockito.times(1))
            .onTouchBegin(ShadowMotionEvent(maskedAction = MotionEvent.ACTION_DOWN,
                                            downFocusX = 0f,
                                            downFocusY = 0f,
                                            downXs = FloatArray(1) { 0f },
                                            downYs = FloatArray(1) { 0f }),
                          null, null)
        // FIXME: Handler doesn't really work
//        Mockito.verify(mockLifecycleListener, Mockito.times(1))
//            .onTouchEnd(ShadowMotionEvent(maskedAction = MotionEvent.ACTION_UP,
//                                          downFocusX = 0f,
//                                          downFocusY = 0f,
//                                          downXs = FloatArray(1) { 0f },
//                                          downYs = FloatArray(1) { 0f }),
//                        null, null)
    }
}
