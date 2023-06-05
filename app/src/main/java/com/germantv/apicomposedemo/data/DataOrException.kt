package com.germantv.apicomposedemo.data

import java.lang.Exception
//wrapper class to manage data and exception
data class DataOrException<T,Boolean,E : Exception>(
    var data: T? = null,
    var loading: Boolean? = null,
    var e : E? = null
)