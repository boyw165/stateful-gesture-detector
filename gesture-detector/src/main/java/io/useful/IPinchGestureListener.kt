// Copyright Feb 2017-present TAI-CHUN, WANG
//
// Author: boyw165@gmail.com
//
// Permission is hereby granted, free of charge, to any person obtaining
// a copy of this software and associated documentation files (the "Software"),
// to deal in the Software without restriction, including without limitation
// the rights to use, copy, modify, merge, publish, distribute, sublicense,
// and/or sell copies of the Software, and to permit persons to whom the
// Software is furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included
// in all copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
// OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
// THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
// FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER
// DEALINGS IN THE SOFTWARE.

package io.useful

interface IPinchGestureListener {

    fun onPinchBegin(event: ShadowMotionEvent,
                     target: Any?,
                     context: Any?,
                     startPointers: Array<Pair<Float, Float>>)

    fun onPinch(event: ShadowMotionEvent,
                target: Any?,
                context: Any?,
                startPointers: Array<Pair<Float, Float>>,
                stopPointers: Array<Pair<Float, Float>>)

    // TODO: (Not implemented) Figure out the arguments.
    fun onPinchFling(event: ShadowMotionEvent,
                     target: Any?,
                     context: Any?)

    fun onPinchEnd(event: ShadowMotionEvent,
                   target: Any?,
                   context: Any?,
                   startPointers: Array<Pair<Float, Float>>,
                   stopPointers: Array<Pair<Float, Float>>)
}