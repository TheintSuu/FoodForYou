package com.theintsuhtwe.foodforyou.views.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.theintsuhtwe.foodforyou.R

class ProfileImage @JvmOverloads  constructor(
    context : Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
)  : AppCompatImageView(context, attrs, defStyleAttr){

    private var cornerRadius = 0f
    private var borderWidth = 5f
    private var borderColor = Color.BLUE

    private val path = Path()

    init {

        context.withStyledAttributes(attrs, R.styleable.ProfileImageView) {
            cornerRadius = getDimension(R.styleable.ProfileImageView_cornerRadius, 0f)
            borderWidth = getDimension(R.styleable.ProfileImageView_borderWidth, 0f)
            borderColor = getColor(R.styleable.ProfileImageView_borderColor, borderColor)
        }


    }
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE

        color = borderColor

        strokeWidth = borderWidth
    }

    override fun onDraw(canvas: Canvas) {

        val rectangle = RectF(0f, 0f, width.toFloat(), height.toFloat())

        val size = width.toFloat()
        val radius  = size/2
        cornerRadius = radius


        path.addRoundRect(rectangle, cornerRadius, cornerRadius, Path.Direction.CCW)

        canvas?.clipPath(path)

        canvas.drawCircle(size / 2f, size / 2f, radius - borderWidth / 2f, paint)

        super.onDraw(canvas)
    }


}