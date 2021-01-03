package com.allexandresantos.shoestore.models

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.library.baseAdapters.BR
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Shoe(var name: String? = null, var size: String? = null, var company: String? = null,
                var description: String? = null, val images: List<String> = mutableListOf()) : Parcelable, BaseObservable()