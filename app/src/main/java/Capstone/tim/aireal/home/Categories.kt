package Capstone.tim.aireal.home

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Categories(
    val photo: Int,
    val name: String
) : Parcelable
