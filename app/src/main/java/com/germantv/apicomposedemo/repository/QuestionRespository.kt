package com.germantv.apicomposedemo.repository

import android.util.Log
import com.germantv.apicomposedemo.data.DataOrException
import com.germantv.apicomposedemo.model.QuestionItem
import com.germantv.apicomposedemo.network.QuestionAPI
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionAPI) {
    private val tag = "QuestionRepository"
    private val dataOrException =  DataOrException<ArrayList<QuestionItem>,Boolean,Exception>()

    suspend fun getAllQuestions():DataOrException<ArrayList<QuestionItem>,Boolean,java.lang.Exception>{
        try {
            dataOrException.loading = true
            val bb = api.getAllQuestions()
            Log.d(tag,"getAllQuestions: ${bb.toString()}")
            dataOrException.data = bb
            if(dataOrException.data.toString().isNotEmpty()){
                Log.d(tag,"getAllQuestions: ${dataOrException.data.toString()}")
                dataOrException.loading = false
            }
        }catch (exception:Exception ){
            dataOrException.e = exception
            //Log.d(tag,"getAllQuestions: ${exception.localizedMessage}") same as below
            Log.d(tag,"getAllQuestions Error: ${dataOrException.e!!.localizedMessage}")
        }
        return dataOrException
    }

    suspend fun getMyPrograms():String {
        var response: String = ""
        try {
            response = api.myTest()
        }catch (exception:Exception){
            response = "error ${exception.localizedMessage}";
        }
        return response
    }
}