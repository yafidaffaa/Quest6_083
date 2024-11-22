package com.example.navigasiwithdata.ui.viewmodel

import com.example.navigasiwithdata.model.RencanaStudy
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RencanaStudyViewModel {
    private val _krsState = MutableStateFlow(RencanaStudy())
    val krsStateUi: StateFlow<RencanaStudy> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update {
            stateMK -> stateMK.copy(namaMK = mkPilihan)
        }
    }
}