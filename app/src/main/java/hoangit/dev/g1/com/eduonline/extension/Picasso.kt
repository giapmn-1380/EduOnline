package hoangit.dev.g1.com.eduonline.extension

import android.content.Context
import com.squareup.picasso.Picasso


public val Context.picasso: Picasso
    get() = Picasso.with(this)