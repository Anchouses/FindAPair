package com.silaeva.game_impl.data

import com.silaeva.game_impl.R
import javax.inject.Inject


class DataSource @Inject constructor() {
    val diamondList = listOf(
        Diamond(R.drawable.blue_circle),
        Diamond(R.drawable.blue_rhombus),
        Diamond(R.drawable.green_circle),
        Diamond(R.drawable.orange),
        Diamond(R.drawable.pink_circle),
        Diamond(R.drawable.purple_circle),
//        Diamond(R.drawable.red_circle),
//        Diamond(R.drawable.teal_circle),
//        Diamond(R.drawable.white_circle),
//        Diamond(R.drawable.yellow_circle),
    )
}
