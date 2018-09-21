package io.useful

import android.view.ViewConfiguration
import org.junit.Before
import org.mockito.Mockito

internal const val SCALED_TOUCH_SLOP = 15
internal const val SCALED_TAP_SLOP = 15
internal const val SCALED_DOUBLE_TAP_SLOP = 63
internal const val SCALED_MIN_FLING_VELOCITY = 1050
internal const val SCALED_MAX_FLING_VELOCITY = 21000

abstract class BaseMockAndroidTest {

    lateinit var mockViewConfiguration: ViewConfiguration

    @Before
    fun `setup android mock`() {
        mockViewConfiguration = Mockito.mock(ViewConfiguration::class.java)
        Mockito.`when`(mockViewConfiguration.scaledTouchSlop).thenReturn(SCALED_TOUCH_SLOP)
        Mockito.`when`(mockViewConfiguration.scaledDoubleTapSlop).thenReturn(SCALED_DOUBLE_TAP_SLOP)
        Mockito.`when`(mockViewConfiguration.scaledMinimumFlingVelocity).thenReturn(SCALED_MIN_FLING_VELOCITY)
        Mockito.`when`(mockViewConfiguration.scaledMaximumFlingVelocity).thenReturn(SCALED_MAX_FLING_VELOCITY)
    }
}
